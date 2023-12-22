package com.example.layeredarchitecture.entity;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;

}
