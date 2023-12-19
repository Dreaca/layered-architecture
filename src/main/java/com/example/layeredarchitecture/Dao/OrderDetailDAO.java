package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDAO {
    int saveOrder(String orderId,OrderDetailDTO detail ) throws SQLException, ClassNotFoundException;
}
