package model.entity;

class Skill {
	private int skillId;
	private String skillName;
	
	Skill(int skillId, String skillName) {
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	Skill(){}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	int getSkillId() {
		return skillId;
	}

	String getSkillName() {
		return skillName;
	}

	void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
