package com.example.layeredarchitecture.Bo;

import com.example.layeredarchitecture.Bo.custom.SuperBO;
import com.example.layeredarchitecture.Bo.custom.impl.CustomerBoImpl;
import com.example.layeredarchitecture.Bo.custom.impl.ItemBoImpl;
import com.example.layeredarchitecture.Bo.custom.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.Bo.custom.impl.SearchOrderBoImpl;

public class BOFactory {
    public static BOFactory boFactory ;
    private BOFactory(){

    }

    public static BOFactory getBoFactory() {
        return boFactory == null ? new BOFactory() : boFactory;
    }
    public  enum BOTypes {
        CUSTOMER,ITEM,PLACE_ORDER,SEARCHORDER
    }
    public SuperBO getBo(BOTypes boTypes ){
        switch (boTypes){
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case SEARCHORDER:
                return new SearchOrderBoImpl();
            default:
                return null;
        }
    }
}
