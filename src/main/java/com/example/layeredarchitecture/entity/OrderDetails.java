package com.example.layeredarchitecture.entity;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

}
