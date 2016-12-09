package model.dao;

public interface CustomersDAO<Customer> extends DAO<Customer>{
    public Customer findByName(String name);
}
