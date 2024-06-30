package com.example.kewltewls.beans.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentalRecord {
    
    @Id
    @GeneratedValue
    private Integer rentalRecordId;

    @Column
    private String rentedToolId;

    @Column
    private LocalDate rentalDate;
    
    @Column
    private LocalDate returnDate;

    @Column
    private Integer chargeDays; // number of days the customer is charged for

    @Column
    private Double preDiscountCharge;

    @Column
    private Double totalCharge;

    @Column
    private Integer discountPercent;

    @Column
    private LocalDateTime lastChangeTs;

    @Column
    private String lastChangeClientId; // should be scraped from HTTP Authorization header 

}
