package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T>T test(String sql, Object...strings) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i= 0 ; i < strings.length; i++){
            pstm.setObject((i+1), strings[i]);
        }
        if(sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        }else{
            return (T)(Boolean)(pstm.executeUpdate() >0);
        }
    }
}
