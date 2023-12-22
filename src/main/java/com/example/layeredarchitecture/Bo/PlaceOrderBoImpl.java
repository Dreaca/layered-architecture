package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.Dao.Transaction;
import com.example.layeredarchitecture.Dao.custom.CustomerDAO;
import com.example.layeredarchitecture.Dao.custom.ItemDAO;
import com.example.layeredarchitecture.Dao.custom.OrderDAO;
import com.example.layeredarchitecture.Dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.Dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.Dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.Dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.Dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBO {
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private ItemDAO itemDAO = new ItemDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        try {
            /*if order id already exist*/
            if (orderDAO.exist(orderId)) {
                return false;
            }
            Transaction.setAutoCommit(false);

            if (orderDAO.save(new OrderDTO(orderId,orderDate,customerId))) {
                Transaction.rollback();
                Transaction.setAutoCommit(true);
                return false;
            }
            for (OrderDetailDTO detail : orderDetails) {
                if (orderDetailDAO.save(new OrderDetailDTO(orderId,detail.getItemCode(),detail.getQty(),detail.getUnitPrice()))) {
                    Transaction.rollback();
                    Transaction.setAutoCommit(true);
                    return false;
                }
//                //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
                ItemDTO item = null;

                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                if (!itemDAO.update(item)) {
                    Transaction.rollback();
                    Transaction.setAutoCommit(true);
                    return false;
                }
            }

            Transaction.commit();
            Transaction.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
