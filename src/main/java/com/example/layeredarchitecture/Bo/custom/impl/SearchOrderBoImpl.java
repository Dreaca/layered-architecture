package com.example.layeredarchitecture.Bo.custom.impl;

import com.example.layeredarchitecture.Bo.custom.SearchOrderBO;
import com.example.layeredarchitecture.Dao.DAOFactory;
import com.example.layeredarchitecture.Dao.custom.QueryDAO;
import com.example.layeredarchitecture.Dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderBoImpl implements SearchOrderBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.QUERY);
    @Override
    public ArrayList<CustomerOrderDTO> loadData() throws SQLException, ClassNotFoundException {
        return queryDAO.loadJoinQuery();
    }
}
