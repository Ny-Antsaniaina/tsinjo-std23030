package com.company.demo.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Help {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Beneficiary beneficiary;

    @OneToOne
    private Payment payment;

    private String description;
    private LocalDateTime helpDate;
}
