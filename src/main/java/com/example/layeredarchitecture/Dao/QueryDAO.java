package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.view.tdm.CustomerOrderTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
     ArrayList<CustomerOrderTM> loadJoinQuery() throws SQLException, ClassNotFoundException;
    }
