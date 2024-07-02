package com.xecommerce.kafka;

public class Account {

    public Integer customerId;
    public String customerName;
    public String current_view;

    public Account(Integer customerId, String customerName, String current_view) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.current_view = current_view;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCurrent_view() {
        return current_view;
    }

    public void setCurrent_view(String current_view) {
        this.current_view = current_view;
    }
}
