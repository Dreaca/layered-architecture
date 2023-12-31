package com.example.layeredarchitecture.Dao.custom;

import com.example.layeredarchitecture.Dao.SuperDAO;
import com.example.layeredarchitecture.entity.CustomerOrder;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
     ArrayList<CustomerOrder> loadJoinQuery() throws SQLException, ClassNotFoundException;
    }
