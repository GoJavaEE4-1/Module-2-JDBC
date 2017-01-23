package model.dao;

import model.entity.Customer;
import utilities.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDaoImpl implements CustomersDao<Customer> {

    @Override
    public void create(Customer customer) {
        try {
            ConnectionUtility.PreparedStatementcreateCustomer(
                    "INSERT INTO CUSTOMERS (customer_name) VALUES (?)", customer);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Customer get(int id) {
        String resultName = "";
        Customer customer = new Customer(id, null);


        try {

            ResultSet resultSet = ConnectionUtility.PreparedStatementGet(
                    "SELECT * FROM CUSTOMERS WHERE customer_id = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                resultName = resultSet.getString("customer_name");
            }
            customer.setCustomerId(id);
            customer.setCustomerName(resultName);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {

        try {
            ConnectionUtility.PreparedStatementcreateCustomer
                    ("UPDATE CUSTOMERS SET customer_name = ?", customer);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            ConnectionUtility.PreparedStatementdelete(
                    "DELETE FROM CUSTOMERS WHERE customer_id = ?", id);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findByName(String name) {
        String resultName = "";
        try {

            ResultSet resultSet = ConnectionUtility.PreparedStatementFindbyName(
                    "SELECT customer_name FROM CUSTOMERS WHERE customer_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("customer_name");
            }
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultName;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer(0, null);
        int id = 0;
        String name = "";
        try {
            ResultSet resultSet = ConnectionUtility.performStatement("SELECT * FROM CUSTOMERS");
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                name = resultSet.getString("customer_name");
                customer.setCustomerId(id);
                customer.setCustomerName(name);
                customers.add(customer);
            }
            ConnectionUtility.closeStatement();
            ConnectionUtility.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
