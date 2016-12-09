package model.dao;

import model.entity.Project;

import java.sql.*;

public class ProjectsDAOImpl implements ProjectsDAO<Project> {
    private static final String DB = "jdbc:postgresql://localhost:5432/postgres";
    private static final String User = "postgres";
    private static final String Password = "111";
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;

    static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB, System.getProperty(User), System.getProperty(Password));
    }

    @Override
    public void create(Project project) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("Insert into Projects values (?,?,?,?,?)");
            preparedStatement.setInt(1, project.getProjectId());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setDate(3, (Date) project.getProjectDate());
            preparedStatement.setString(4, String.valueOf(project.getCompany()));
            preparedStatement.setString(5, String.valueOf(project.getCustomer()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project get(int id) {
        String name = "";
        Project project = new Project(id,name);
        try {
            connect();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("Select * from Projects where project_id = ? ");
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setProjectId(resultSet.getInt("project_id"));
            project.setProjectName(resultSet.getString("project_name"));
            project.setProjectDate(resultSet.getDate("project_date"));
            project.setCompany(resultSet.getString("project_company_id"));
            project.setCustomer(resultSet.getString("project_customer_id"));

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
            connect();
            preparedStatement = connection.prepareStatement("Update Projects set project_id = ? and project_name = ? and project_date = ? and project_company_id = ? and project_customer_id = ? ");
            preparedStatement.setInt(1, project.getProjectId());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setDate(3, (Date) project.getProjectDate());
            preparedStatement.setString(4, String.valueOf(project.getCompany()));
            preparedStatement.setString(5, String.valueOf(project.getCustomer()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            connect();
            preparedStatement = connection.prepareStatement("Delete from Projects where project_id  = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project findByName(String name) {
        int id;
        try {
            connect();
            preparedStatement = connection.prepareStatement("Select * from Projects where project_name = ?");
            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                id= resultSet.getInt("project_id");
                name = (resultSet.getString("project_name"));
                Project project = new Project(id,name);
                return project;
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
