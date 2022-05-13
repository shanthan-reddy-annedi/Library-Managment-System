package com.example.LibraryManagmentSystem.Repositories;
import com.example.LibraryManagmentSystem.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRep extends JpaRepository<Admin, Integer> {
}
