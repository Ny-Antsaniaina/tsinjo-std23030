package com.company.demo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Donation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Donor donor;

    @OneToOne
    private Payment payment;

    private LocalDateTime donationDate;


}
