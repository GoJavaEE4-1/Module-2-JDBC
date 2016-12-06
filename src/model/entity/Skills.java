package java_ee_module_2;

class Skills{
	private int skillId;
	private String skillName;
	
	Skills(int skillId, String skillName) {
		this.skillId = skillId;
		this.skillName = skillName;
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
