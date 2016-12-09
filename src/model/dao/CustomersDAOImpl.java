package model.dao;

import model.entity.Customer;

import java.sql.*;

public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static final String DB = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "111";
    private static  final String insertSql = "Insert into Customers values (?,?)";
    private static  final String selectById = "Select * from Customers where customer_id = ?";
    private  static final String updatetSql = "Update Customers set customer_name = ? where customer_id = ?";
    private static final String deleteSql = "Delete from Customers where customer_id  = ?  ";
    private static final String findByNameSql = "Select * from Customers where customer_name = ? ";
    public static PreparedStatement statement = null;

    @Override
    public void create(Customer customer) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(insertSql);
            statement.setInt(1,customer.getCustomerId());
            statement.setString(2,customer.getCustomerName());
            statement.executeQuery();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(DB,USER,PASS);
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Customer get(int id) {
        String name = "";
        Customer customer = new Customer(id,name);
        try {

            loadDriver();
            Connection connection = connectToDB();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(selectById);
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            customer.setCustomerId(resultSet.getInt("customer_id"));
            customer.setCustomerName(resultSet.getString("customer_name"));


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
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(updatetSql);
            statement.setString(1,customer.getCustomerName());
            statement.setInt(2,customer.getCustomerId());
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(deleteSql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findByName(String name) {
        int id;
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(findByNameSql);
            statement.setString(1,name);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                id= resultSet.getInt("customer_id");
                name = (resultSet.getString("customer_name"));
                Customer customer = new Customer(id,name);
                return customer;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
