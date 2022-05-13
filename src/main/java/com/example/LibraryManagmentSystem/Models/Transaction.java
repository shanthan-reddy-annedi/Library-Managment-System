package com.example.LibraryManagmentSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String externalTransactionId; // like 501a26b4-0366-44ec-b537-c3d39d51f67c

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("transaction")
    private Request request;

    @CreationTimestamp
    private Date transactionDate;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Double fine;
}
