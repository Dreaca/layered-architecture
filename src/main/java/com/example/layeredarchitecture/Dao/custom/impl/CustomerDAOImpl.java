package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.CustomerDAO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("Check");
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> getAllCustomer = new ArrayList<>();
        while (rst.next()){
            Customer entity =  new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
               entity.getId(),entity.getName(),entity.getAddress());
    }
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
               entity.getName(),entity.getAddress(),entity.getId());
    }
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }
    public String getNextID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString(1);
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<String > list =  new ArrayList<>();
        while (rst.next()){
            list.add(
                    rst.getString(1)
            );
        }
        return list;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id+" ");
        rst.next();
        Customer entity = new Customer(id + "", rst.getString("name"), rst.getString("address"));
        return entity ;
    }

}
