package model.entity;

public class Customer {

    private int CustomerId;
    private String CustomerName;

    public Customer(int customerId, String customerName) {
        CustomerId = customerId;
        CustomerName = customerName;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
