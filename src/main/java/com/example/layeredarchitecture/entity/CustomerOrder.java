package com.example.layeredarchitecture.entity;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerOrder {
    private String customerId;
    private  String customerName;
    private String customerAddress;
    private String orderId;
    private LocalDate date;

}
