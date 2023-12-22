package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
     ArrayList<CustomerOrderDTO> loadJoinQuery() throws SQLException, ClassNotFoundException;
    }
