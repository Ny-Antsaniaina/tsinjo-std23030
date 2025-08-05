package com.company.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    private String pspPaymentId;
    private String status;
    private Integer amount;
    private LocalDateTime paymentDate;
}
