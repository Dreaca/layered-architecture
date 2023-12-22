package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchOrderBO {
    ArrayList<CustomerOrderDTO> loadData() throws SQLException, ClassNotFoundException;
}
