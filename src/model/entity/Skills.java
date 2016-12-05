package java_ee_module_2;

class Skills {
	private int skill_id;
	private String skill_name;
	
	Skills(int skill_id, String skill_name) {
		this.skill_id = skill_id;
		this.skill_name = skill_name;
	}

	int getSkill_id() {
		return skill_id;
	}

	String getSkill_name() {
		return skill_name;
	}

	void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
}
