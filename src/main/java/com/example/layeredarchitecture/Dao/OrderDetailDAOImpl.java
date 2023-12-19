package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;

public class OrderDetailDAOImpl implements  OrderDetailDAO{
    @Override
    public int saveOrder(String orderId,OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)"
                ,orderId,detail.getItemCode(),detail.getUnitPrice(),detail.getQty());
    }
}
