package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.Bo.SearchOrderBO;
import com.example.layeredarchitecture.Bo.SearchOrderBoImpl;
import com.example.layeredarchitecture.Dao.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomerOrderDTO;
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
//    QueryDAOImpl joinQueryDao = new QueryDAOImpl();
    SearchOrderBO searchOrderBO = new SearchOrderBoImpl();
    public void initialize() {
        setCellValueFactory();
        loadData();
    }

    private void loadData()  {
        ArrayList<CustomerOrderDTO> list = null;
        try {
            list = searchOrderBO.loadData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObservableList<CustomerOrderTM> oblist =  FXCollections.observableArrayList();
        for (CustomerOrderDTO t: list) {
            System.out.println(t);
            oblist.add(
                    new CustomerOrderTM(
                            t.getCustomerId(),
                            t.getCustomerName(),
                            t.getCustomerAddress(),
                            t.getOrderId(),
                            t.getDate()
                    )
            );
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
