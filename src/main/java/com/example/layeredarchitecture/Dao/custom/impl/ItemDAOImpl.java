package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.Dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> itemDTOS  = new ArrayList<>();
        while(rst.next()){
            itemDTOS.add(
                    new ItemDTO(
                            rst.getString("code"),
                            rst.getString("description"),
                            rst.getBigDecimal("unitPrice"),
                            rst.getInt("qtyOnHand")
                    )
            );
        }
        return itemDTOS;
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
            return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                itemDTO.getCode(),itemDTO.getDescription(), itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {;
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            list.add(rst.getString("code"));
        }
        return list;
    }
    @Override
    public ItemDTO search( String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
        rst.next();
        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}