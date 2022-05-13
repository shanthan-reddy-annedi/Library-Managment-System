package com.example.LibraryManagmentSystem.Controllers;

import com.example.LibraryManagmentSystem.Models.Book;
import com.example.LibraryManagmentSystem.Request.BookCreateRequest;
import com.example.LibraryManagmentSystem.Request.BookFilterQuery;
import com.example.LibraryManagmentSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void CreateBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
            bookService.createBook(bookCreateRequest);
    }

    @GetMapping("/book")
    public List<Book> getBook(@RequestParam("filtertype") String filterType,
                              @RequestParam("filtervalue") String filtervalue){
        switch (BookFilterQuery.valueOf(filterType)){
            case ID:
                return bookService.getBookById(Integer.parseInt(filtervalue));
            case GENRE:
                return bookService.getBookByGenre(filtervalue);
            case AUTHOR:
                return bookService.getBookByAuthorEmail(filtervalue);
            case AVAILABILITY:
                return bookService.getBookAvail(Boolean.valueOf(filtervalue));
        }
        return null;
    }
}
