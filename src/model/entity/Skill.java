package model.entity;

public class Skill implements Model{
	private int skillId;
	private String skillName;

	public Skill(int skillId, String skillName) {
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public Skill() {}

	public int getSkillId() {
		return skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {

		return "----------------------------------------------------------------------" + "\n" +
				"Skill name: " + skillName + "; " + "\n" +
				"Skill ID: " + skillId + "\n";
	}
}
