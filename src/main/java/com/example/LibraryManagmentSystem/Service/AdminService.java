package com.example.LibraryManagmentSystem.Service;

import com.example.LibraryManagmentSystem.Models.Admin;
import com.example.LibraryManagmentSystem.Models.Request;
import com.example.LibraryManagmentSystem.Models.RequestStatus;
import com.example.LibraryManagmentSystem.Repositories.AdminRep;
import com.example.LibraryManagmentSystem.Request.AdminCreateRequest;
import com.example.LibraryManagmentSystem.Request.ProcessRequest;
import com.example.LibraryManagmentSystem.Response.ProcessResponse;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private static final String REJECTED_STATUS = "Rejected";
    private static final String APPROVED_STATUS = "Approved";

    @Autowired
    private AdminRep adminRep;

    @Autowired
    private RequestService requestService;

    @Autowired
    TransactionService transactionService;

    public void createAdmin(AdminCreateRequest adminCreateRequest){
        adminRep.save(adminCreateRequest.to());
    }

    public Admin getAdmin(int id){
        return adminRep.findById(id).orElse(null);
    }

    public List<Admin> allAdmins(){
        return adminRep.findAll();
    }

    public ProcessResponse processRequest(ProcessRequest processRequest) throws Exception {
        Request request = requestService.getRequestById(processRequest.getRequestId());


        if (request== null){
            throw new Exception("Invalid Request");
        }
        if (request.getAdmin()==null || request.getAdmin().getId() != processRequest.getAdminId()){
            throw new Exception("Request is not assigned to admin"+processRequest.getAdminId());
        }
        if (!RequestStatus.PENDING.equals(request.getRequestStatus())){
            throw new Exception("This Request is already Processed");
        }

        // when the admin reject the request
        if(RequestStatus.REJECTED.equals(processRequest.getRequestStatus())){
            // setting the status of the request as rejected
            request.setRequestStatus(RequestStatus.REJECTED);

            //setting the admin and system comments to the request
            request.setAdminComment(processRequest.getComment());
            request.setSystemComment(REJECTED_STATUS);

            // updating the request object in the database;
            requestService.saveOrUpdateRequest(request);

            //returning the processReponse
            return ProcessResponse.builder()
                    .systemComment(REJECTED_STATUS)
                    .requestStatus(RequestStatus.REJECTED)
                    .adminComment(processRequest.getComment())
                    .build();
        }
        // no need to check wether and create transaction

        // setting the request status as accepted
        request.setRequestStatus(RequestStatus.ACCEPTED);
        request.setAdminComment(processRequest.getComment());
        request.setSystemComment(APPROVED_STATUS);

        Request savedRequest = requestService.saveOrUpdateRequest(request);

        transactionService.createTransaction(savedRequest);

        return ProcessResponse.builder()
                .systemComment(APPROVED_STATUS)
                .requestStatus(RequestStatus.ACCEPTED)
                .adminComment(processRequest.getComment())
                .build();

    }

}
