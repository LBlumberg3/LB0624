package com.example.kewltewls.beans.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutDTO {
    
    private String toolCode;
    private Integer rentalDayCount;
    private Integer discountPercent;
    private String checkoutDate;

}
