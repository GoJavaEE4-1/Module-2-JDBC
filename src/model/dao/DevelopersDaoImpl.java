package model.dao;


import model.entity.Company;
import model.entity.Developer;
import model.entity.Project;
import utilities.ConnectionUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopersDaoImpl implements DevelopersDao<Developer> {

    @Override
    public void create(Developer developer) {
        try {
            ConnectionUtility.PreparedStatementcreateDeveloper(
                    "INSERT INTO DEVELOPERS (developer_name) VALUES (?)", developer);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer get(int id) {
        String resultName = "";
        Developer developer = new Developer (id, null, null, null);
        Company companyId = developer.getDeveloperCompanyId();
        Project projectId = developer.getDeveloperProjectId();
        int companyID = 0;
        int projectID = 0;

        try {

            ResultSet resultSet = ConnectionUtility.PreparedStatementGet(
                    "SELECT * FROM DEVELOPERS WHERE developer_id = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("developer_id");
                resultName = resultSet.getString("developer_name");
                companyID = resultSet.getInt("developer_company_id_fk");
                companyId.setCompanyId(companyID);
                projectID = resultSet.getInt("developer_project_id_fk");
                projectId.setProjectId(projectID);
            }
            developer.setDeveloperId(id);
            developer.setDeveloperName(resultName);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void update(Developer developer) {
        try {
            ConnectionUtility.PreparedStatementcreateDeveloper("UPDATE DEVELOPERS SET developer_name = ?", developer);
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
                    "DELETE FROM DEVELOPERS WHERE developer_id = ?", id);
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
                    "SELECT developer_name FROM DEVELOPERS WHERE developer_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("developer_name");
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
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        Developer developer = new Developer(0, null, null, null);
        Company companyId = developer.getDeveloperCompanyId();
        Project projectId = developer.getDeveloperProjectId();
        int id = 0;
        String resultName = "";
        int companyID = 0;
        int customerID = 0;
        try {
            ResultSet resultSet = ConnectionUtility.performStatement("SELECT * FROM DEVELOPERS");
            while (resultSet.next()) {
                id = resultSet.getInt("developer_id");
                resultName = resultSet.getString("developer_name");
                developer.setDeveloperId(id);
                developer.setDeveloperName(resultName);
                developer.setDeveloperCompanyId(companyId);
                developer.setDeveloperProjectId(projectId);
                developers.add(developer);
            }
            ConnectionUtility.closeStatement();
            ConnectionUtility.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return developers;
    }
}

