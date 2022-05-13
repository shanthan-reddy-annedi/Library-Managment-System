package com.example.LibraryManagmentSystem.Service;

import com.example.LibraryManagmentSystem.Models.Admin;
import com.example.LibraryManagmentSystem.Models.Student;
import com.example.LibraryManagmentSystem.Repositories.StudentRep;
import com.example.LibraryManagmentSystem.Request.PlaceRequest;
import com.example.LibraryManagmentSystem.Request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRep studentRep;

    @Autowired
    RequestService requestService;

    @Autowired
    AdminService adminService;

    public void createStudent(StudentCreateRequest studentCreateRequest){
        studentRep.save(studentCreateRequest.to());
    }

    public Student getStudentById(int id){
        return studentRep.findById(id).orElse(null);
    }

    public String placeRequest(PlaceRequest placeRequest){
        List<Admin> admins = adminService.allAdmins();
        Admin admin = admins.stream().min(Comparator.comparing(a -> a.getRequestsToProcess().size())).orElse(null);

        return requestService.saveOrUpdateRequest(placeRequest.toRequest(admin)).getRequestId();
    }
}
