package com.example.LibraryManagmentSystem.Controllers;

import com.example.LibraryManagmentSystem.Models.Student;
import com.example.LibraryManagmentSystem.Request.PlaceRequest;
import com.example.LibraryManagmentSystem.Request.StudentCreateRequest;
import com.example.LibraryManagmentSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/request")
    public String placeRequest(@Valid @RequestBody PlaceRequest placeRequest){

        return studentService.placeRequest(placeRequest);
    }

//    @PostMapping("/request")
//    public String placeRequest(@Valid @RequestBody PlaceRequest placeRequest){
//        return requestService.placeRequest(placeRequest).getRequestId();
//    }

}
