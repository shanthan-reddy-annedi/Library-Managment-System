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
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String urn;

    private String phoneNo;

    @OneToMany(mappedBy = "admin")
    @JsonIgnoreProperties({"admin","student","book","transaction"})
    private List<Request> requestsToProcess;

    @CreationTimestamp
    private Date createdOn;
}
