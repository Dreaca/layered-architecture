package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    String generateOrderID() throws SQLException, ClassNotFoundException;
    boolean existsOrder(String orderId) throws SQLException,ClassNotFoundException;
    boolean SaveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
