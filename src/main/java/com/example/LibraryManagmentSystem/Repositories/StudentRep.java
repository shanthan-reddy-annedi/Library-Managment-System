package com.example.LibraryManagmentSystem.Repositories;

import com.example.LibraryManagmentSystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRep extends JpaRepository<Student, Integer>{

}
