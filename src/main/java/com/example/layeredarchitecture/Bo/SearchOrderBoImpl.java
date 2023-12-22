package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.Dao.QueryDAO;
import com.example.layeredarchitecture.Dao.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderBoImpl implements SearchOrderBO{
    QueryDAO queryDAO = new QueryDAOImpl();
    @Override
    public ArrayList<CustomerOrderDTO> loadData() throws SQLException, ClassNotFoundException {
        return queryDAO.loadJoinQuery();
    }
}
