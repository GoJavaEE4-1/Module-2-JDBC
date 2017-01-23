package model.dao;

import model.entity.Company;
import utilities.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CompaniesDaoImpl implements CompaniesDao<Company>{

    @Override
    public void create(Company company) {
        try {
            ConnectionUtility.PreparedStatementcreateCompany(
                    "INSERT INTO COMPANIES (company_name) VALUES (?)", company);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Company get(int id) {
        String resultName = "";
        Company company = new Company(id, null);

        try {

            ResultSet resultSet = ConnectionUtility.PreparedStatementGet(
                    "SELECT * FROM COMPANIES WHERE company_id = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("company_id");
                resultName = resultSet.getString("company_name");
            }
            company.setCompanyId(id);
            company.setCompanyName(resultName);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

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
            ConnectionUtility.PreparedStatementcreateCompany
                    ("UPDATE COMPANIES SET company_name = ?", company);
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
                    "DELETE FROM COMPANIES WHERE company_id = ?", id);
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
                    "SELECT company_name FROM COMPANIES WHERE company_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("company_name");
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
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        Company company = new Company(0, null);
        int id = 0;
        String name = "";
        try {
            ResultSet resultSet = ConnectionUtility.performStatement("SELECT * FROM COMPANIES");
            while (resultSet.next()) {
                id = resultSet.getInt("company_id");
                name = resultSet.getString("company_name");
                company.setCompanyId(id);
                company.setCompanyName(name);
                companies.add(company);
            }
            ConnectionUtility.closeStatement();
            ConnectionUtility.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return companies;
    }
}



