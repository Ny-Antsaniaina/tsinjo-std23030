package com.company.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Donor {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
}
