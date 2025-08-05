package com.company.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;

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
