package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    String getNextID()throws SQLException, ClassNotFoundException;
    ArrayList<String> getIds()throws SQLException, ClassNotFoundException;
    T search(String id)throws SQLException, ClassNotFoundException;
}
