package com.example.layeredarchitecture.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private String customerName;
    private BigDecimal orderTotal;

    public Order(String orderId, LocalDate orderDate, String customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }
}
