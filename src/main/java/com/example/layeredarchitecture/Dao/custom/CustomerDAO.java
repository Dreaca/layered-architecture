package com.example.layeredarchitecture.Dao.custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {

}
