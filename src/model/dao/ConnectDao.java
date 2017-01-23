package model.dao;

import java.sql.*;

public class ConnectDao {

	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/GroupDB";

	public static final String USER = "postgres";
	public static final String PASSWORD = "darren";

	public static Connection connection = null;
	public static Statement statement = null;
	public static PreparedStatement preparedStatement = null;

	public static void ConnectDB() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
	}

	public static ResultSet selectRecord(String sql) throws SQLException {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	public static void changeRecord(String sql, int...id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		int i = 1;
		for (int x : id){
			preparedStatement.setInt(i, x);
			++i;
		}
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public static void changeRecord(int id, String sql, String name) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public static void addRecord(String sql, String firstName, String secondName, int...id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id[0]);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(2, secondName);
		if (id.length == 2){
			preparedStatement.setInt(3, id[1]);
		}
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public static void closeConnect() throws SQLException {
		connection.close();
	}
}
