package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;


public class OrderDAOImpl implements OrderDAO {
    private ItemDAO itemDAO = new ItemDAOImpl();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean existsOrder(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.test("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return set.next();
    }

    @Override
    public int saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,Date.valueOf(orderDate),customerId);
    }
}
