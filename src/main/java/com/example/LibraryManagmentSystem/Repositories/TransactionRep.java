package com.example.LibraryManagmentSystem.Repositories;

import com.example.LibraryManagmentSystem.Models.Transaction;
import com.example.LibraryManagmentSystem.Models.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRep extends JpaRepository<Transaction, Integer> {
    List<Transaction> findTransactionByRequest_Book_IdAndTransactionStatusOrderByTransactionDateDesc(int bookId, TransactionStatus transactionStatus);
}
