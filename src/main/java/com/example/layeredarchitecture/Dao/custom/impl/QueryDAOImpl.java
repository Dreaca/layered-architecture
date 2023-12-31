package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.QueryDAO;
import com.example.layeredarchitecture.entity.CustomerOrder;
import com.example.layeredarchitecture.model.CustomerOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomerOrder> loadJoinQuery() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.execute("SELECT * FROM customer c RIGHT JOIN orders o ON c.id = o.customerId ");
        ArrayList<CustomerOrder> list = new ArrayList<>();
        while(set.next()){
            list.add(
                    new CustomerOrder(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getDate(5).toLocalDate()
                    )
            );
        }
        System.out.println();
        return list;
    }
}
