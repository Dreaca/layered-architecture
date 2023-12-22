package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.view.tdm.CustomerOrderTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomerOrderTM> loadJoinQuery() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.execute("SELECT * FROM customer c RIGHT JOIN orders o ON c.id = o.customerId ");
        ArrayList<CustomerOrderTM> list = new ArrayList<>();
        while(set.next()){
            list.add(
                    new CustomerOrderTM(
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
