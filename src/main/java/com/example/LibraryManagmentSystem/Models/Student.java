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
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phoneNo;

    @Column(unique = true,nullable = false)
    private String URN;

    private int age;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties({"student","requestList"})
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties({"student","admin","transaction","book"})
    private List<Request> requestsCreated;

    @CreationTimestamp
    private Date createdOn;
}
