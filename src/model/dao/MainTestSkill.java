package model.dao;

class MainTestSkill {
	private SkillDAOImpl skillDAOImpl = new SkillDAOImpl();
	
	SkillDAOImpl getSkillDAOImpl() {
		return skillDAOImpl;
	}

	public static void main(String[] args) {
		MainTestSkill main = new MainTestSkill();

		main.getSkillDAOImpl().create(new Skill(5, "C#"));
		main.getSkillDAOImpl().delete(5);
		System.out.println(main.getSkillDAOImpl().get(4));
		main.getSkillDAOImpl().update((main.getSkillDAOImpl().get(4)));
		System.out.println(main.getSkillDAOImpl().findByName("Elena"));
	}
}
