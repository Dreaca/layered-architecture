package com.example.layeredarchitecture.model;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerOrderDTO {
    private String customerId;
    private  String customerName;
    private String customerAddress;
    private String orderId;
    private LocalDate date;

}
