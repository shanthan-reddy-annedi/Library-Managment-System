package com.example.LibraryManagmentSystem.Repositories;

import com.example.LibraryManagmentSystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRep extends JpaRepository<Author, Integer> {

    @Query("select a from Author a where a.email = :email")
    Author findbyEmailid(String email);
}
