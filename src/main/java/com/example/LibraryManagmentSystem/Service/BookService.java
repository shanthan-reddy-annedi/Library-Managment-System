package com.example.LibraryManagmentSystem.Service;

import com.example.LibraryManagmentSystem.Models.Author;
import com.example.LibraryManagmentSystem.Models.Book;
import com.example.LibraryManagmentSystem.Models.Genre;
import com.example.LibraryManagmentSystem.Repositories.BookRep;
import com.example.LibraryManagmentSystem.Request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRep bookRep;

    @Autowired
    AuthorService authorService;

    public Book createBook(BookCreateRequest bookCreateRequest){
        Author author = bookCreateRequest.toAuthor();

        author =authorService.createOrGetAuthor(author);
        //bookRep.save(bookCreateRequest);
        Book book = bookCreateRequest.toBook(author);
        return bookRep.save(book);
    }

    public List<Book> getBookById(int id){
        return Collections.singletonList(bookRep.findById(id).orElse(null));
    }

    public Book createOrUpdateBook(Book requestedBook) {
        return bookRep.save(requestedBook);
    }


    public List<Book> getBookByGenre(String filtervalue) {
        return bookRep.getBooksInGenre(Genre.valueOf(filtervalue));
    }

    public List<Book> getBookByAuthorEmail(String filtervalue) {
        return null;
    }

    public List<Book> getBookAvail(Boolean valueOf) {
        return null;
    }
}
