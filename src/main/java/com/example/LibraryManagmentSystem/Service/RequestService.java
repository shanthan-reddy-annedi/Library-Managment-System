package com.example.LibraryManagmentSystem.Service;
import com.example.LibraryManagmentSystem.Models.Admin;
import com.example.LibraryManagmentSystem.Models.Request;
import com.example.LibraryManagmentSystem.Repositories.RequestRep;
import com.example.LibraryManagmentSystem.Request.PlaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRep requestRep;

//    @Autowired
//    AdminService adminService;


    public Request getRequestById(int requestId) {
        return requestRep.findById(requestId).orElse(null);
    }

    public Request saveOrUpdateRequest(Request request){
        return requestRep.save(request);
    }

}
