package com.example.LibraryManagmentSystem.Request;

import com.example.LibraryManagmentSystem.Models.Author;
import com.example.LibraryManagmentSystem.Models.Book;
import com.example.LibraryManagmentSystem.Models.Genre;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateRequest {
    @NotNull
    private String bookName;
    @NotNull
    private Genre genre;
    @NotNull
    private String authorName;
    @Email
    @NotNull
    private String authorEmail;

    private String auhorwebsite;


    public Book toBook(Author author){
        return Book.builder()
                .author(author)
                .bookName(this.getBookName())
                .genre(this.getGenre())
                .build();
    }

    public Author toAuthor(){
        return Author.builder()
                .email(this.authorEmail)
                .name(this.authorName)
                .website(this.auhorwebsite)
                .build();
    }

}
