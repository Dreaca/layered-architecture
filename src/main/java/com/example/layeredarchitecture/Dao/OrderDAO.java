package com.example.layeredarchitecture.Dao;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    String generateOrderID() throws SQLException, ClassNotFoundException;
    boolean existsOrder(String orderId) throws SQLException,ClassNotFoundException;
    int saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
