package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    String getNextCustomerId() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException;

}
