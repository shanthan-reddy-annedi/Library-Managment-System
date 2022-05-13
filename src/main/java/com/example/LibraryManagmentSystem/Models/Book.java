package com.example.LibraryManagmentSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private String bookName;

    @CreationTimestamp
    private Date createdOn;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Student student;

    @JoinColumn
    @ManyToOne // Many (Books)  to   One (Author)
    @JsonIgnoreProperties("bookList")
    private Author author;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Request> requestList;


}
