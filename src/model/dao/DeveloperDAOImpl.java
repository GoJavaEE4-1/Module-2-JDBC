package model.dao;
import java.sql.SQLException;

import model.entity.Company;
import model.entity.Developer;
import model.entity.Project;

public class DeveloperDAOImpl implements DeveloperDAO<Developer> {
	private ConnectionUtility connectionUtility = new ConnectionUtility();

	@Override
	public void create(Developer t) {
		try{
			String sql = "insert into developers (developer_id, developer_first_name, developer_last_name, developer_email, developer_phone, project_id, company_id) "
						+ "values (?, ?, ?, ?, ?, ?, ?)";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, t.getDeveloperId());
			connectionUtility.getPreparedStatement().setString(2, t.getDeveloperFirstName());
			connectionUtility.getPreparedStatement().setString(3, t.getDeveloperLastName());
			connectionUtility.getPreparedStatement().setString(4, t.getDeveloperEmail());
			connectionUtility.getPreparedStatement().setString(5, t.getDeveloperPhone());
			connectionUtility.getPreparedStatement().setInt(6, t.getProject().getProjectId());
			connectionUtility.getPreparedStatement().setInt(7, t.getCompany().getCompanyId());
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Successfully added!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}
	
	@Override
	public Developer get(int id) {
		Developer d = new Developer();
		try{
			String sql = "select developers.developer_id, developers.developer_first_name, developers.developer_last_name, developers.developer_email, "
						+ "developers.developer_phone, developers.project_id, projects.project_name, developers.company_id, companies.company_name "
						+ "from developers "
						+ "inner join projects on developers.project_id = projects.project_id "
						+ "inner join companies on developers.company_id = companies.company_id "
						+ "where developer_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				d.setDeveloperId(connectionUtility.getResultSet().getInt("developer_id"));
				d.setDeveloperFirstName(connectionUtility.getResultSet().getString("developer_first_name"));
				d.setDeveloperLastName(connectionUtility.getResultSet().getString("developer_last_name"));
				d.setDeveloperEmail(connectionUtility.getResultSet().getString("developer_email"));
				d.setDeveloperPhone(connectionUtility.getResultSet().getString("developer_phone"));
				d.setProject(new Project(connectionUtility.getResultSet().getInt("project_id"), connectionUtility.getResultSet().getString("project_name")));
				d.setCompany(new Company(connectionUtility.getResultSet().getInt("company_id"), connectionUtility.getResultSet().getString("company_name")));
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return d;
	}
	
	@Override
	public void update(Developer t) {
		try{
			String sql = "update developers set developer_first_name=?, developer_last_name=?, developer_email=?, developer_phone=?, project_id=?, company_id=? where developer_id=?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, "Valentin");
			connectionUtility.getPreparedStatement().setString(2, t.getDeveloperLastName());
			connectionUtility.getPreparedStatement().setString(3, t.getDeveloperEmail());
			connectionUtility.getPreparedStatement().setString(4, t.getDeveloperPhone());
			connectionUtility.getPreparedStatement().setInt(5, t.getProject().getProjectId());
			connectionUtility.getPreparedStatement().setInt(6, t.getCompany().getCompanyId());
			connectionUtility.getPreparedStatement().setInt(7, t.getDeveloperId());
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Seccessfully updated!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}
	
	@Override
	public void delete(int id) {
		try{
			String sql = "delete from developers where developer_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.getPreparedStatement().executeUpdate();
            System.out.println("Successfully deleted!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}
	
	@Override
	public Developer findByName(String name) {
		Developer d = new Developer();
		try{
			String sql = "select developers.developer_id, developers.developer_first_name, developers.developer_last_name, developers.developer_email, "
						+ "developers.developer_phone, developers.project_id, projects.project_name, developers.company_id, companies.company_name "
						+ "from developers "
						+ "inner join projects on developers.project_id = projects.project_id "
						+ "inner join companies on developers.company_id = companies.company_id "
						+ "where developer_first_name = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, name);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				d.setDeveloperId(connectionUtility.getResultSet().getInt("developer_id"));
				d.setDeveloperFirstName(connectionUtility.getResultSet().getString("developer_first_name"));
				d.setDeveloperLastName(connectionUtility.getResultSet().getString("developer_last_name"));
				d.setDeveloperEmail(connectionUtility.getResultSet().getString("developer_email"));
				d.setDeveloperPhone(connectionUtility.getResultSet().getString("developer_phone"));
				d.setProject(new Project(connectionUtility.getResultSet().getInt("project_id"), connectionUtility.getResultSet().getString("project_name")));
				d.setCompany(new Company(connectionUtility.getResultSet().getInt("company_id"), connectionUtility.getResultSet().getString("company_name")));
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return d;
	}
	
	@Override
	public Developer findByFullName(String firstName, String lastName) {
		Developer d = new Developer();
		try{
			String sql = "select developers.developer_id, developers.developer_first_name, developers.developer_last_name, developers.developer_email, "
						+ "developers.developer_phone, developers.project_id, projects.project_name, developers.company_id, companies.company_name "
						+ "from developers "
						+ "inner join projects on developers.project_id = projects.project_id "
						+ "inner join companies on developers.company_id = companies.company_id "
						+ "where developer_first_name = ? and developer_last_name = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, firstName);
			connectionUtility.getPreparedStatement().setString(2, lastName);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				d.setDeveloperId(connectionUtility.getResultSet().getInt("developer_id"));
				d.setDeveloperFirstName(connectionUtility.getResultSet().getString("developer_first_name"));
				d.setDeveloperLastName(connectionUtility.getResultSet().getString("developer_last_name"));
				d.setDeveloperEmail(connectionUtility.getResultSet().getString("developer_email"));
				d.setDeveloperPhone(connectionUtility.getResultSet().getString("developer_phone"));
				d.setProject(new Project(connectionUtility.getResultSet().getInt("project_id"), connectionUtility.getResultSet().getString("project_name")));
				d.setCompany(new Company(connectionUtility.getResultSet().getInt("company_id"), connectionUtility.getResultSet().getString("company_name")));
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return d;
	}
}
