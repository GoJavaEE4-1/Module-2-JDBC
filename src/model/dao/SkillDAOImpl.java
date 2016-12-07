package java_ee_module_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class SkillDAOImpl implements SkillDAO {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/goit";
	static final String USER = "postgres";
	static final String PASSWORD = "superuser";
	
	@Override
	public void create(Skill t) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "insert into m2.skills (skill_id, skill_name) values (?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getSkillId());
			preparedStatement.setString(2, t.getSkillName());
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
	public Skill get(int id) {
		Skill s = new Skill();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select m2.skills.skill_id, m2.skills.skill_name "
						+ "from m2.skills "
						+ "where skill_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				s.setSkillId(resultSet.getInt("skill_id"));
				s.setSkillName(resultSet.getString("skill_name"));
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
		return s;
	}
	
	@Override
	public void update(Skill t) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "update m2.skills set skill_name=? where skill_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "pHp");
			preparedStatement.setInt(2, t.getSkillId());
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
			String sql = "delete from m2.skills where skill_id = ?";
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
	public ArrayList<Skill> findByName(String name) {
		Skill s;
		ArrayList<Skill> list = new ArrayList<>();
		list.clear();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			String sql = "select m2.developers.developer_first_name, m2.skills.skill_id, m2.skills.skill_name "
						+ "from m2.developers "
						+ "inner join m2.developers_skills on m2.developers_skills.dev_id = m2.developers.developer_id "
						+ "inner join m2.skills on m2.developers_skills.ski_id = m2.skills.skill_id "
						+ "where developer_first_name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				s = new Skill();
				s.setSkillId(resultSet.getInt("skill_id"));
				s.setSkillName(resultSet.getString("skill_name"));
				list.add(s);
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
		return list;
	}
}
