package com.example.LibraryManagmentSystem.Controllers;

import com.example.LibraryManagmentSystem.Models.Admin;
import com.example.LibraryManagmentSystem.Request.AdminCreateRequest;
import com.example.LibraryManagmentSystem.Request.ProcessRequest;
import com.example.LibraryManagmentSystem.Response.ProcessResponse;
import com.example.LibraryManagmentSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@Valid @RequestBody AdminCreateRequest adminCreateRequest){
        adminService.createAdmin(adminCreateRequest);
    }

    @GetMapping("/admin/{adminId}")
    public Admin getAdminById(@PathVariable("adminId")int id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/admin/process")
    public ProcessResponse processRequest(@RequestBody ProcessRequest processRequest) throws Exception {
            return adminService.processRequest(processRequest);
    }
}
