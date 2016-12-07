package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DeveloperDAOImpl implements DeveloperDAO {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/goit";
	static final String USER = "postgres";
	static final String PASSWORD = "superuser";
	
	@Override
	public void create(Developer t) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "insert into m2.developers (developer_id, developer_first_name, developer_last_name, developer_email, developer_phone, project_id, company_id) "
						+ "values (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getDeveloperId());
			preparedStatement.setString(2, t.getDeveloperFirstName());
			preparedStatement.setString(3, t.getDeveloperLastName());
			preparedStatement.setString(4, t.getDeveloperEmail());
			preparedStatement.setString(5, t.getDeveloperPhone());
			preparedStatement.setInt(6, t.getProject().getProjectId());
			preparedStatement.setInt(7, t.getCompany().getCompanyId());
	        preparedStatement.executeUpdate();
            System.out.println("Successfully added!");
		} catch (ClassNotFoundException | SQLException e){
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	@Override
	public Developer get(int id) {
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select m2.developers.developer_id, m2.developers.developer_first_name, m2.developers.developer_last_name, m2.developers.developer_email, "
						+ "m2.developers.developer_phone, m2.developers.project_id, m2.projects.project_name, m2.developers.company_id, m2.companies.company_name "
						+ "from m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				d.setDeveloperId(resultSet.getInt("developer_id"));
				d.setDeveloperFirstName(resultSet.getString("developer_first_name"));
				d.setDeveloperLastName(resultSet.getString("developer_last_name"));
				d.setDeveloperEmail(resultSet.getString("developer_email"));
				d.setDeveloperPhone(resultSet.getString("developer_phone"));
				d.setProject(new Project(resultSet.getInt("project_id"), resultSet.getString("project_name")));
				d.setCompany(new Company(resultSet.getInt("company_id"), resultSet.getString("company_name")));
			}
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		return d;
	}
	
	@Override
	public void update(Developer t) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "update m2.developers set developer_first_name=?, developer_last_name=?, developer_email=?, developer_phone=?, project_id=?, company_id=? where developer_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "ValentinOOO");
			preparedStatement.setString(2, t.getDeveloperLastName());
			preparedStatement.setString(3, t.getDeveloperEmail());
			preparedStatement.setString(4, t.getDeveloperPhone());
			preparedStatement.setInt(5, t.getProject().getProjectId());
			preparedStatement.setInt(6, t.getCompany().getCompanyId());
			preparedStatement.setInt(7, t.getDeveloperId());
            preparedStatement.executeUpdate();
            System.out.println("Seccessfully updated!");
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	@Override
	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "delete from m2.developers where developer_id = ?";
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
            System.out.println("Successfully deleted!");
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	@Override
	public Developer findByName(String name) {
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select m2.developers.developer_id, m2.developers.developer_first_name, m2.developers.developer_last_name, m2.developers.developer_email, "
						+ "m2.developers.developer_phone, m2.developers.project_id, m2.projects.project_name, m2.developers.company_id, m2.companies.company_name "
						+ "from m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_first_name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				d.setDeveloperId(resultSet.getInt("developer_id"));
				d.setDeveloperFirstName(resultSet.getString("developer_first_name"));
				d.setDeveloperLastName(resultSet.getString("developer_last_name"));
				d.setDeveloperEmail(resultSet.getString("developer_email"));
				d.setDeveloperPhone(resultSet.getString("developer_phone"));
				d.setProject(new Project(resultSet.getInt("project_id"), resultSet.getString("project_name")));
				d.setCompany(new Company(resultSet.getInt("company_id"), resultSet.getString("company_name")));
			}
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		return d;
	}
	@Override
	public Developer findByFullName(String firstName, String lastName) {
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select m2.developers.developer_id, m2.developers.developer_first_name, m2.developers.developer_last_name, m2.developers.developer_email, "
						+ "m2.developers.developer_phone, m2.developers.project_id, m2.projects.project_name, m2.developers.company_id, m2.companies.company_name "
						+ "from m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_first_name = ? and developer_last_name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				d.setDeveloperId(resultSet.getInt("developer_id"));
				d.setDeveloperFirstName(resultSet.getString("developer_first_name"));
				d.setDeveloperLastName(resultSet.getString("developer_last_name"));
				d.setDeveloperEmail(resultSet.getString("developer_email"));
				d.setDeveloperPhone(resultSet.getString("developer_phone"));
				d.setProject(new Project(resultSet.getInt("project_id"), resultSet.getString("project_name")));
				d.setCompany(new Company(resultSet.getInt("company_id"), resultSet.getString("company_name")));
			}
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			System.out.println("Bug!");
		} finally {
			try {
				if(connection != null) connection.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {e.printStackTrace();}
			try {
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
		return d;
	}
}
