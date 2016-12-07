package model;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

class ConnectionUtility {
	private String JDBC_DRIVER;
	private String DATABASE_URL;
	private String USER;
	private String PASSWORD;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	ConnectionUtility() {
		getConnectionParameters();
	}
	
	private void getConnectionParameters() {
		try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
			DATABASE_URL = properties.getProperty("DATABASE_URL");
			USER = properties.getProperty("USER");
			PASSWORD = properties.getProperty("PASSWORD");
		} catch (Exception e) {e.printStackTrace();}
	}
	
	Connection getConnection(){
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	void closeConnection() {
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

	PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	ResultSet getResultSet() {
		return resultSet;
	}

	void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
