package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.Dao.custom.impl.*;

public class DAOFactory {
    static DAOFactory DaoFactory ;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (DaoFactory == null) ? DaoFactory = new DAOFactory() : DaoFactory;
    }
    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, QUERY
    }
    public SuperDAO getDao(DAOTypes daoType ){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
