package java_ee_module_2;

class MainTestDev {
	private DeveloperDAOImpl developersDAOImpl = new DeveloperDAOImpl();
	
	DeveloperDAOImpl getDevelopersDAOImpl() {
		return developersDAOImpl;
	}
	
	public static void main(String[] args) {
		MainTestDev main = new MainTestDev();

		main.getDevelopersDAOImpl().create(new Developer(10, "Sergey", "Pupkin", "email@mail.ua", "0500500505", new Project(6, "Project100"), new Company(3, "GlobalLogic")));
		main.getDevelopersDAOImpl().delete(10);
		System.out.println(main.getDevelopersDAOImpl().get(9));
		main.getDevelopersDAOImpl().update((main.getDevelopersDAOImpl().get(9)));
		System.out.println(main.getDevelopersDAOImpl().findByName("Artyom"));
		System.out.println(main.getDevelopersDAOImpl().findByFullName("Elena", "LastName7"));
	}
}
