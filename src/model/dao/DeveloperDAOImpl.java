package java_ee_module_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DeveloperDAOImpl<T> implements DeveloperDAO<T>{
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/goit";
	static final String USER = "postgres";
	static final String PASSWORD = "superuser";
	
	@Override
	public void create(T t) {
		Developer newDeveloper = (Developer) t;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "insert into m2.developers (developer_id, developer_first_name, developer_last_name, developer_email, developer_phone, project_id, company_id) "
						+ "values (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newDeveloper.getDeveloper_id());
			preparedStatement.setString(2, newDeveloper.getDeveloper_first_name());
			preparedStatement.setString(3, newDeveloper.getDeveloper_last_name());
			preparedStatement.setString(4, newDeveloper.getDeveloper_email());
			preparedStatement.setString(5, newDeveloper.getDeveloper_phone());
			preparedStatement.setInt(6, newDeveloper.getProject_id());
			preparedStatement.setInt(7, newDeveloper.getCompany_id());
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
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select "
						+ "m2.developers.developer_id, "
						+ "m2.developers.developer_first_name, "
						+ "m2.developers.developer_last_name, "
						+ "m2.developers.developer_email, "
						+ "m2.developers.developer_phone, "
						+ "m2.projects.project_name, "
						+ "m2.companies.company_name "
						+ "from "
						+ "m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_id = ? "
						+ "order by m2.developers.developer_id asc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				developer.setDeveloper_id(resultSet.getInt("developer_id"));
				developer.setDeveloper_first_name(resultSet.getString("developer_first_name"));
				developer.setDeveloper_last_name(resultSet.getString("developer_last_name"));
				developer.setDeveloper_email(resultSet.getString("developer_email"));
				developer.setDeveloper_phone(resultSet.getString("developer_phone"));
				developer.setProject_Name(resultSet.getString("project_Name"));
				developer.setCompany_name(resultSet.getString("company_name"));
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
		return (T) developer;
	}
	
	@Override
	public void update(T t) {
		Developer d = (Developer) t;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "update m2.developers set developer_first_name=?, developer_last_name=?, developer_email=?, developer_phone=?, project_id=?, company_id=? where developer_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Valentin");
			preparedStatement.setString(2, d.getDeveloper_last_name());
			preparedStatement.setString(3, d.getDeveloper_email());
			preparedStatement.setString(4, d.getDeveloper_phone());
			preparedStatement.setInt(5, 2);
			preparedStatement.setInt(6, 1);
			preparedStatement.setInt(7, d.getDeveloper_id());
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
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByName(String name) {
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select "
						+ "m2.developers.developer_id, "
						+ "m2.developers.developer_first_name, "
						+ "m2.developers.developer_last_name, "
						+ "m2.developers.developer_email, "
						+ "m2.developers.developer_phone, "
						+ "m2.projects.project_name, "
						+ "m2.companies.company_name "
						+ "from "
						+ "m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_first_name = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				developer.setDeveloper_id(resultSet.getInt("developer_id"));
				developer.setDeveloper_first_name(resultSet.getString("developer_first_name"));
				developer.setDeveloper_last_name(resultSet.getString("developer_last_name"));
				developer.setDeveloper_email(resultSet.getString("developer_email"));
				developer.setDeveloper_phone(resultSet.getString("developer_phone"));
				developer.setProject_Name(resultSet.getString("project_Name"));
				developer.setCompany_name(resultSet.getString("company_name"));
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
		return (T) developer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByFullName(String firstName, String lastName) {
		Developer developer = new Developer();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select "
						+ "m2.developers.developer_id, "
						+ "m2.developers.developer_first_name, "
						+ "m2.developers.developer_last_name, "
						+ "m2.developers.developer_email, "
						+ "m2.developers.developer_phone, "
						+ "m2.projects.project_name, "
						+ "m2.companies.company_name "
						+ "from "
						+ "m2.developers "
						+ "inner join m2.projects on m2.developers.project_id = m2.projects.project_id "
						+ "inner join m2.companies on m2.developers.company_id = m2.companies.company_id "
						+ "where developer_first_name = ? and developer_last_name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				developer.setDeveloper_id(resultSet.getInt("developer_id"));
				developer.setDeveloper_first_name(resultSet.getString("developer_first_name"));
				developer.setDeveloper_last_name(resultSet.getString("developer_last_name"));
				developer.setDeveloper_email(resultSet.getString("developer_email"));
				developer.setDeveloper_phone(resultSet.getString("developer_phone"));
				developer.setProject_Name(resultSet.getString("project_Name"));
				developer.setCompany_name(resultSet.getString("company_name"));
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
		return (T) developer;
	}
}
