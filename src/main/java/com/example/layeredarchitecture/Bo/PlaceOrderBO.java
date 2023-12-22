package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBO {
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    }
