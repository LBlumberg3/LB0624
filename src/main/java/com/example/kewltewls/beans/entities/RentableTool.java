package com.example.kewltewls.beans.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RentableTool {

    @Id
    private String toolId;

    @Column
    private String toolType;

    @Column
    private String toolBrand;

    @Column
    private Double dailyRentalCharge;

    @Column
    private Boolean weekendCharge;

    @Column
    private Boolean holidayCharge;
    
}
