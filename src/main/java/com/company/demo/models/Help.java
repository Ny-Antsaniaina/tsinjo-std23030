package com.company.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Help {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Beneficiary beneficiary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "pspPaymentId")
    private Payment payment;

    private String description;
    private LocalDateTime helpDate;
}
