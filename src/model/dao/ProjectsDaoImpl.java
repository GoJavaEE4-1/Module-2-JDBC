package model.dao;


import model.entity.Company;
import model.entity.Customer;
import model.entity.Project;
import utilities.ConnectionUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectsDaoImpl implements ProjectsDao<Project> {

    @Override
    public void create(Project project) {
        try {
            ConnectionUtility.PreparedStatementcreateProject(
                    "INSERT INTO PROJECTS (project_name) VALUES (?)", project);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project get(int id) {
        String resultName = "";
        Project project = new Project(id, null, null, null, null);
        Company companyId = project.getProjectCompanyId();
        Customer customerId = project.getProjectCustomerId();
        int companyID = 0;
        int customerID = 0;
        Date date = null;

        try {

            ResultSet resultSet = ConnectionUtility.PreparedStatementGet(
                    "SELECT * FROM PROJECTS WHERE project_id = ?", id);
            while (resultSet.next()) {
                id = resultSet.getInt("project_id");
                resultName = resultSet.getString("project_name");
                companyID = resultSet.getInt("project_company_id_fk");
                companyId.setCompanyId(companyID);
                customerID = resultSet.getInt("project_customer_id_fk");
                customerId.setCustomerId(customerID);
                customerId.setCustomerId(customerID);
                date = resultSet.getDate("production_date");
            }
            project.setProjectId(id);
            project.setProjectName(resultName);
            project.setProjectCompanyId(companyId);
            project.setProjectCustomerId(customerId);
            project.setProductionDate(date);
            ConnectionUtility.closePreparedStatement();
            ConnectionUtility.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        try {
            ConnectionUtility.PreparedStatementcreateProject
                    ("UPDATE PROJECTS SET project_name = ?", project);
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
                    "DELETE FROM PROJECTS WHERE project_id = ?", id);
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
                    "SELECT project_name FROM PROJECTS WHERE project_name = ?", name);
            while (resultSet.next()) {
                resultName = resultSet.getString("project_name");
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
    public List getAll() {
        List<Project> projects = new ArrayList<>();
        Project project = new Project(0, null, null, null, null);
        Company companyId = project.getProjectCompanyId();
        Customer customerId = project.getProjectCustomerId();
        int id = 0;
        String resultName = "";
        int companyID = 0;
        int customerID = 0;
        Date date = null;
        try {
            ResultSet resultSet = ConnectionUtility.performStatement("SELECT * FROM PROJECTS");
            while (resultSet.next()) {
                id = resultSet.getInt("project_id");
                resultName = resultSet.getString("project_name");
                project.setProjectId(id);
                project.setProjectName(resultName);
                project.setProjectCompanyId(companyId);
                project.setProjectCustomerId(customerId);
                project.setProductionDate(date);
                projects.add(project);
            }
            ConnectionUtility.closeStatement();
            ConnectionUtility.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
