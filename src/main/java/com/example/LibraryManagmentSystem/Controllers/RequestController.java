//package com.example.LibraryManagmentSystem.Controllers;
//
//import com.example.LibraryManagmentSystem.Request.PlaceRequest;
//import com.example.LibraryManagmentSystem.Service.RequestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//public class RequestController {
//    @Autowired
//    RequestService requestService;
//
//    @PostMapping("/request")
//    public String placeRequest(@Valid @RequestBody PlaceRequest placeRequest){
//        return requestService.placeRequest(placeRequest).getRequestId();
//    }
//
//}
