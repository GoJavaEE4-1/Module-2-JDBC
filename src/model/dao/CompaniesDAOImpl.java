package model.dao;

import model.entity.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiy on 12/4/16.
 */
public class CompaniesDAOImpl implements CompaniesDAO<Company> {

    private static final String DB = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "darren";
    private static final String insertSql = "INSERT into Companies VALUES (?,?)";
    private static final String selectById = "Select * from Companies where companie_id = ?";
    private static final String findByNameSql = "Select * from Companies where companie_name = ? ";
    private static final String getAllSql = "Select * from Companies";
    PreparedStatement statement;


    @Override
    public void create(Company company) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(insertSql);
            statement.setInt(1, company.getCompanyId());
            statement.setString(2, company.getCompanyName());
            statement.executeQuery();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(DB, USER, PASS);
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    public Company get(int id) {
        String name = "";
        Company company = new Company(id, name);
        try {

            loadDriver();
            Connection connection = connectToDB();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(selectById);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            company.setCompanyId(resultSet.getInt("companie_id"));
            company.setCompanyName(resultSet.getString("companie_name"));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void update(Company company) {
        try {
            loadDriver();
            Connection connection = connectToDB();
            PreparedStatement statement =
                    connection.prepareStatement("Update Companies set companie_id = ? and companie_name = ? where ");
            statement.setInt(1, company.getCompanyId());
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
            PreparedStatement statement =
                    connection.prepareStatement("DELETE from COMPANIES where companie_id  = ?  ");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company findByName(String name) {
        int id;

        try {

            loadDriver();
            Connection connection = connectToDB();
            statement = connection.prepareStatement(findByNameSql);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("companie_id");
                name = (resultSet.getString("companie_name"));
                Company company = new Company(id, name);
                return company;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        try {
            loadDriver();
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllSql);
            while (resultSet.next()){
                int id = resultSet.getInt("companie_id");
                String name = resultSet.getString("companie_name") ;
                companies.add(new Company(id,name));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return companies;
    }
}



