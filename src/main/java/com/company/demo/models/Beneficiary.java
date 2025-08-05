package com.company.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
}
