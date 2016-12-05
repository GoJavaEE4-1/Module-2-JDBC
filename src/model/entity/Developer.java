package java_ee_module_2;

class Developer {
	private int developer_id;
	private String developer_first_name;
	private String developer_last_name;
	private String developer_email;
	private String developer_phone;
	private int project_id;
	private int company_id;
	
	Developer(int developer_id, String developer_first_name, String developer_last_name, String developer_email, String developer_phone, int project_id, int company_id) {
		this.developer_id = developer_id;
		this.developer_first_name = developer_first_name;
		this.developer_last_name = developer_last_name;
		this.developer_email = developer_email;
		this.developer_phone = developer_phone;
		this.project_id = project_id;
		this.company_id = company_id;
	}

	int getDeveloper_id() {
		return developer_id;
	}

	String getDeveloper_first_name() {
		return developer_first_name;
	}

	String getDeveloper_last_name() {
		return developer_last_name;
	}

	String getDeveloper_email() {
		return developer_email;
	}

	String getDeveloper_phone() {
		return developer_phone;
	}

	int getProject_id() {
		return project_id;
	}

	int getCompany_id() {
		return company_id;
	}

	void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}

	void setDeveloper_first_name(String developer_first_name) {
		this.developer_first_name = developer_first_name;
	}

	void setDeveloper_last_name(String developer_last_name) {
		this.developer_last_name = developer_last_name;
	}

	void setDeveloper_email(String developer_email) {
		this.developer_email = developer_email;
	}

	void setDeveloper_phone(String developer_phone) {
		this.developer_phone = developer_phone;
	}

	void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
}
