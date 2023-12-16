package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;

public class OrderDetailDAOImpl implements  OrderDetailDAO{
    @Override
    public int saveOrder(OrderDetailDTO detail,String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, orderId);
        stm.setString(2, detail.getItemCode());
        stm.setBigDecimal(3, detail.getUnitPrice());
        stm.setInt(4, detail.getQty());
        return stm.executeUpdate();
    }
}
