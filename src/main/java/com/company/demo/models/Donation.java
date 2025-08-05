package com.company.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Donor donor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "pspPaymentId")
    private Payment payment;

    private LocalDateTime donationDate;

}
