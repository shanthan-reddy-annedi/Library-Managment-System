package com.example.LibraryManagmentSystem.Repositories;

import com.example.LibraryManagmentSystem.Models.Book;
import com.example.LibraryManagmentSystem.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRep extends JpaRepository<Book, Integer> {
//    two type of custom querys:
//        1. JPQL - java persistence Query language
//        2. Native sql query - Querys with respective to sql tables

    @Query("select b from Book b where b.genre = :genre")
    List<Book> getBooksInGenre(Genre genre);

    @Query(value = "select * from book b where b.genre= :genre", nativeQuery = true)
    List<Book> getBooksInGenreSql(Genre genre);

}
