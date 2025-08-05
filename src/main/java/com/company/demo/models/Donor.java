package com.company.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donor {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
}
