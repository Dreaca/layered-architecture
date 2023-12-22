package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {
   static Connection connection;

    static {
        try {
            connection = DBConnection.getDbConnection().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  static boolean setAutoCommit(boolean stat) throws SQLException, ClassNotFoundException {

            if(stat){
                connection.setAutoCommit(true);
                return  true;
            }
            else {
                connection.setAutoCommit(false);
                return false;
            }
    }
    public static void  rollback() throws SQLException {
        connection.rollback();
    }

    public static void commit() throws SQLException {
        connection.commit();
    }
}
