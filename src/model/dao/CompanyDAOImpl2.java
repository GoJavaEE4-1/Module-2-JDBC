package model.dao;
import java.sql.SQLException;
import model.entity.Company;

class CompanyDAOImpl2 implements CompanyDAO2 {
	private ConnectionUtility connectionUtility = new ConnectionUtility();

	@Override
	public void create(Company t) {
		try{
			String sql = "insert into companies (company_id, company_name) values (?, ?)";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, t.getCompanyId());
			connectionUtility.getPreparedStatement().setString(2, t.getCompanyName());
			connectionUtility.getPreparedStatement().executeUpdate();
			System.out.println("Successfully added!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}

	@Override
	public Company get(int id) {
		Company c = new Company();
		try{
			String sql = "select companies.company_id, companies.company_name "
				+ "from companies "
				+ "where company_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
		while (connectionUtility.getResultSet().next()) {
			c.setCompanyId(connectionUtility.getResultSet().getInt("company_id"));
			c.setCompanyName(connectionUtility.getResultSet().getString("company_name"));
		}
	} catch (SQLException e){e.printStackTrace();
	} finally {connectionUtility.closeConnection();}
		return c;
	}

	@Override
	public void update(Company t) {
		try{
			String sql = "update companies set company_name=? where company_id=?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, "NIX Solutions Ltd.+");
			connectionUtility.getPreparedStatement().setInt(2, t.getCompanyId());
			connectionUtility.getPreparedStatement().executeUpdate();
			System.out.println("Seccessfully updated!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}

	@Override
	public void delete(int id) {
		try{
			String sql = "delete from companies where company_id = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setInt(1, id);
			connectionUtility.getPreparedStatement().executeUpdate();
			System.out.println("Successfully deleted!");
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
	}

	@Override
	public Company findByName(String name) {
		Company c = new Company();
		try{
			String sql = "select \n" +
					"developers.developer_first_name,\n" +
					"companies.company_id,\n" +
					"companies.company_name\n" +
					"from\n" +
					"developers\n" +
					"inner join companies on developers.company_id = companies.company_id\n" +
					"where developer_first_name = ?";
			connectionUtility.setPreparedStatement(connectionUtility.getConnection().prepareStatement(sql));
			connectionUtility.getPreparedStatement().setString(1, name);
			connectionUtility.setResultSet(connectionUtility.getPreparedStatement().executeQuery());
			while (connectionUtility.getResultSet().next()) {
				c.setCompanyId(connectionUtility.getResultSet().getInt("company_id"));
				c.setCompanyName(connectionUtility.getResultSet().getString("company_name"));
			}
		} catch (SQLException e){e.printStackTrace();
		} finally {connectionUtility.closeConnection();}
		return c;
	}
}
