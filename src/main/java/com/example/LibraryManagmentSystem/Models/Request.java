package com.example.LibraryManagmentSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String requestId;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"requestsCreated","book"})
    private Student student;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"requestsToProcess"})
    private Admin admin;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties({"requestList","student","author"})
    private Book book;

    @OneToOne(mappedBy = "request")
    @JsonIgnoreProperties("request")
    private Transaction transaction;

    @CreationTimestamp
    private Date requestDate;

    @Enumerated(value = EnumType.STRING)
    private RequestStatus requestStatus;

    @Enumerated(value = EnumType.STRING)
    private RequestType requestType;

    private String adminComment;

    private String systemComment;
}
