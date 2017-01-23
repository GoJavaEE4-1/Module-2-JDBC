package model.dao;
import model.entity.Customer;
import model.entity.Skill;
import utilities.ConnectionUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillsDaoImpl implements SkillsDao<Skill> {

	@Override
	public void create(Skill skill) {
		try {
			ConnectionUtility.PreparedStatementcreate(
					"INSERT INTO SKILLS (skill_name) VALUES (?)", skill);
			ConnectionUtility.closePreparedStatement();
			ConnectionUtility.closeConnection();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Skill get(int id) {
		String resultName = "";
		Skill skill = new Skill(id, null);

		try {

			ResultSet resultSet = ConnectionUtility.PreparedStatementGet(
					"SELECT * FROM SKILLS WHERE skill_id = ?", id);
			while (resultSet.next()) {
				id = resultSet.getInt("skill_id");
				resultName = resultSet.getString("skill_name");
			}
			skill.setSkillId(id);
			skill.setSkillName(resultName);
			ConnectionUtility.closePreparedStatement();
			ConnectionUtility.closeConnection();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skill;
	}

	@Override
	public void update(Skill skill) {

		try {
			ConnectionUtility.PreparedStatementcreate
					("UPDATE SKILLS SET skill_name = ?", skill);
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
					"DELETE FROM SKILLS WHERE skill_id = ?", id);
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
					"SELECT skill_name FROM SKILLS WHERE skill_name = ?", name);
			while (resultSet.next()) {
				resultName = resultSet.getString("skill_name");
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
	public List<Skill> getAll() {
		List<Skill> skills = new ArrayList<>();
		Skill skill = new Skill();
		int id = 0;
		String name = "";
		try {
			ResultSet resultSet = ConnectionUtility.performStatement("SELECT * FROM SKILLS");
			while (resultSet.next()) {
				id = resultSet.getInt("skill_id");
				name = resultSet.getString("skill_name");
				skill.setSkillId(id);
				skill.setSkillName(name);
				skills.add(skill);
			}
			ConnectionUtility.closeStatement();
			ConnectionUtility.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return skills;
	}
}

