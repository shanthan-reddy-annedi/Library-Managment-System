package com.example.LibraryManagmentSystem.Service;

import com.example.LibraryManagmentSystem.Models.*;
import com.example.LibraryManagmentSystem.Repositories.TransactionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionRep transactionRep;

    @Autowired
    RequestService requestService;

    @Autowired
    BookService bookService;

    @Value("${book.allotted.max_days}")
    int allottedDays;

    @Value("${book.fine.per_day}")
    int finePerDay;

    public String createTransaction(int requestId) throws Exception {
        Request request = Request.builder()
                .id(requestId)
                .build();
        return createTransaction(request);
    }

    public String createTransaction(Request request) throws Exception {
        Transaction transaction = Transaction.builder()
                .externalTransactionId(UUID.randomUUID().toString())
                .request(request)
                .transactionStatus(TransactionStatus.PENDING)
                .fine(calculateFine(request))
                .build();
        try {
            System.out.println("\n\n\n"+transaction.getExternalTransactionId()+"\n\n"+transaction.getTransactionStatus());
            Transaction savedTxn = transactionRep.save(transaction);

            if (request.getBook() == null || request.getStudent() == null) {
                request = requestService.getRequestById(request.getId());
            }

            // Actual transaction process

            switch (request.getRequestType()) {
                case ISSUE:
                    issueBook(request);
                    break;
                case RETURN:
                    returnBook(request);
                    break;

            }
            savedTxn.setTransactionStatus(TransactionStatus.SUCCESS);
            transactionRep.save(savedTxn);
        }catch(Exception e){
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRep.save(transaction);

            }

        return transaction.getExternalTransactionId();
    }
    private void issueBook(Request request){
        Book requestedBook = request.getBook();
        Student student = request.getStudent();

        requestedBook.setStudent(student);

        bookService.createOrUpdateBook(requestedBook);
    }

    private void returnBook(Request request){
        Book requestedBook = request.getBook();
        requestedBook.setStudent(null);
        bookService.createOrUpdateBook(requestedBook);
    }

    public Double calculateFine(Request request) throws Exception {

        if (RequestType.ISSUE.equals(request.getRequestType())) {
            return null;
        }
        List<Transaction> transactions = transactionRep.findTransactionByRequest_Book_IdAndTransactionStatusOrderByTransactionDateDesc(
                request.getBook().getId(), TransactionStatus.SUCCESS);

        Transaction txn = transactions.get(0);

        if(!RequestType.ISSUE.equals(txn.getRequest().getRequestType())){
            throw new Exception("Last txn is not an issue txn");
        }

        long timeOfIssueInMillis = txn.getTransactionDate().getTime();
        long timeDiff = System.currentTimeMillis() - timeOfIssueInMillis;
        long noOfDaysPassed = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        double fine = 0.0;

        if(noOfDaysPassed > allottedDays){
            fine += (noOfDaysPassed - allottedDays) * finePerDay;
        }

        return fine;
    }
}
