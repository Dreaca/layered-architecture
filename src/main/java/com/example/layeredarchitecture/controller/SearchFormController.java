package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.Dao.QueryDAOImpl;
import com.example.layeredarchitecture.view.tdm.CustomerOrderTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchFormController {
    public TableView tblOrderStuff;
    public TableColumn customerId;
    public TableColumn cName;
    public TableColumn cAddress;
    public TableColumn orderId;
    public TableColumn date;
    QueryDAOImpl joinQueryDao = new QueryDAOImpl();
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadData();
    }

    private void loadData() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerOrderTM> list = joinQueryDao.loadJoinQuery();
        ObservableList<CustomerOrderTM> oblist =  FXCollections.observableArrayList();
        for (CustomerOrderTM t: list) {
            System.out.println(t);
            oblist.add(t);
        }
        tblOrderStuff.setItems(oblist);
    }
    public void setCellValueFactory(){
        customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        cName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        cAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
}
