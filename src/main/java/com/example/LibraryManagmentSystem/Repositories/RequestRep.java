package com.example.LibraryManagmentSystem.Repositories;

import com.example.LibraryManagmentSystem.Models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRep extends JpaRepository<Request, Integer> {
}
