package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderDAO {
    public String generateOrderID() throws SQLException, ClassNotFoundException;
    boolean saveOrder (String orderId, LocalDate orderDate, String customerId, List < OrderDetailDTO > orderDetails);
    }
