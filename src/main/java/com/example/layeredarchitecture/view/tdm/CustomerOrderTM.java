package com.example.layeredarchitecture.view.tdm;

import java.time.LocalDate;

public class CustomerOrderTM {
    private String customerId;
    private  String customerName;
    private String customerAddress;
    private String orderId;
    private LocalDate date;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CustomerOrderTM(String cutomerId, String customerName, String customerAddress, String orderId, LocalDate date) {
        this.customerId = cutomerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderId = orderId;
        this.date = date;
    }

    public CustomerOrderTM() {
    }

    @Override
    public String toString() {
        return "CustomerOrderTM{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", orderId='" + orderId + '\'' +
                ", date=" + date +
                '}';
    }
}
