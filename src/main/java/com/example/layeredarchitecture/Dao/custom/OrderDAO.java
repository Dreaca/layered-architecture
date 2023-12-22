package com.example.layeredarchitecture.Dao.custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<Order> {
}
