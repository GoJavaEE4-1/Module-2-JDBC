package model.dao;
import model.entity.Company;

class MainTestCompany {
	private CompanyDAOImpl2 companyDAOImpl2 = new CompanyDAOImpl2();

	public static void main(String[] args) {
		MainTestCompany main = new MainTestCompany();

		main.companyDAOImpl2.create(new Company(6, "ITdev"));
		main.companyDAOImpl2.delete(6);
		System.out.println(main.companyDAOImpl2.get(5));
		main.companyDAOImpl2.update((main.companyDAOImpl2.get(5)));
		System.out.println(main.companyDAOImpl2.findByName("Ivan"));
	}
}
