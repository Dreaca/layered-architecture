package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDAO {
    int saveOrder(OrderDetailDTO detail,String orderId ) throws SQLException, ClassNotFoundException;
}
