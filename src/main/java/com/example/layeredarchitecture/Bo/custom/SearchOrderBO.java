package com.example.layeredarchitecture.Bo.custom;

import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchOrderBO extends SuperBO {
    ArrayList<CustomerOrderDTO> loadData() throws SQLException, ClassNotFoundException;
}
