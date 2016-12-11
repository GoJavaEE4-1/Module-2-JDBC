package model.entity;

public class Developer {
	private int developerId;
	private String developerFirstName;
	private String developerLastName;
	private String developerEmail;
	private String developerPhone;
	private Project project;
	private Company company;
	
	@Override
	public String toString() {
		return "Developer [" + developerId + ", " + developerFirstName + ", " + developerLastName + ", " + developerEmail + ", " + developerPhone + ", " + project + ", " + company + "]";
	}

	Developer(){}

	Developer(int developerId, String developerFirstName, String developerLastName, String developerEmail, String developerPhone, Project project, Company company) {
		this.developerId = developerId;
		this.developerFirstName = developerFirstName;
		this.developerLastName = developerLastName;
		this.developerEmail = developerEmail;
		this.developerPhone = developerPhone;
		this.project = project;
		this.company = company;
	}

	int getDeveloperId() {
		return developerId;
	}

	String getDeveloperFirstName() {
		return developerFirstName;
	}

	String getDeveloperLastName() {
		return developerLastName;
	}

	String getDeveloperEmail() {
		return developerEmail;
	}

	String getDeveloperPhone() {
		return developerPhone;
	}

	Project getProject() {
		return project;
	}

	Company getCompany() {
		return company;
	}

	void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	void setDeveloperFirstName(String developerFirstName) {
		this.developerFirstName = developerFirstName;
	}

	void setDeveloperLastName(String developerLastName) {
		this.developerLastName = developerLastName;
	}

	void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	void setDeveloperPhone(String developerPhone) {
		this.developerPhone = developerPhone;
	}

	void setProject(Project project) {
		this.project = project;
	}

	void setCompany(Company company) {
		this.company = company;
	}
}
