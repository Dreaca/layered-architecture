package com.example.layeredarchitecture.Bo.custom.impl;

import com.example.layeredarchitecture.Bo.custom.SearchOrderBO;
import com.example.layeredarchitecture.Dao.DAOFactory;
import com.example.layeredarchitecture.Dao.custom.QueryDAO;
import com.example.layeredarchitecture.Dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.entity.CustomerOrder;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderBoImpl implements SearchOrderBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.QUERY);
    @Override
    public ArrayList<CustomerOrderDTO> loadData() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerOrderDTO> list = new ArrayList<>();
        ArrayList<CustomerOrder>orders = queryDAO.loadJoinQuery();
        for (CustomerOrder order : orders) {
            list.add(new CustomerOrderDTO(
               order.getCustomerId(),
               order.getCustomerName(),
               order.getCustomerAddress(),
                    order.getOrderId(),
                    order.getDate()
            ));
        }
        return list;
    }
}
