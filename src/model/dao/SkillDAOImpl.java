package java_ee_module_2;
import java.sql.SQLException;
import java.util.ArrayList;

class SkillDAOImpl implements SkillDAO {
	private ConnectionUtility connectionUtility = new ConnectionUtility();
	
	@Override
	public void create(Skill t) {
		try{
			String sql = "insert into skills (skill_id, skill_name) values (?, ?)";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, t.getSkillId());
			connectionUtility.getPreparedStatement().setString(2, t.getSkillName());
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Successfully added!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}
	
	@Override
	public Skill get(int id) {
		Skill s = new Skill();
		try{
			String sql = "select skills.skill_id, skills.skill_name "
						+ "from skills "
						+ "where skill_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				s.setSkillId(connectionUtility.getResultSet().getInt("skill_id"));
				s.setSkillName(connectionUtility.getResultSet().getString("skill_name"));
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return s;
	}
	
	@Override
	public void update(Skill t) {
		try{
			String sql = "update skills set skill_name=? where skill_id=?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, "pHp_");
			connectionUtility.getPreparedStatement().setInt(2, t.getSkillId());
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Seccessfully updated!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}		
	}
	
	@Override
	public void delete(int id) {
		try{
			String sql = "delete from skills where skill_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Successfully deleted!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}	
	}
	
	@Override
	public ArrayList<Skill> findByName(String name) {
		Skill s;
		ArrayList<Skill> list = new ArrayList<>();
		list.clear();
		try{
			String sql = "select developers.developer_first_name, skills.skill_id, skills.skill_name "
						+ "from developers "
						+ "inner join developers_skills on developers_skills.dev_id = developers.developer_id "
						+ "inner join skills on developers_skills.ski_id = skills.skill_id "
						+ "where developer_first_name = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, name);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				s = new Skill();
				s.setSkillId(connectionUtility.getResultSet().getInt("skill_id"));
				s.setSkillName(connectionUtility.getResultSet().getString("skill_name"));
				list.add(s);
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return list;
	}
}
