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

	public Developer(){}

	public Developer(int developerId, String developerFirstName, String developerLastName, String developerEmail, String developerPhone, Project project, Company company) {
		this.developerId = developerId;
		this.developerFirstName = developerFirstName;
		this.developerLastName = developerLastName;
		this.developerEmail = developerEmail;
		this.developerPhone = developerPhone;
		this.project = project;
		this.company = company;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public String getDeveloperFirstName() {
		return developerFirstName;
	}

	public String getDeveloperLastName() {
		return developerLastName;
	}

	public String getDeveloperEmail() {
		return developerEmail;
	}

	public String getDeveloperPhone() {
		return developerPhone;
	}

	public Project getProject() {
		return project;
	}

	public Company getCompany() {
		return company;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public void setDeveloperFirstName(String developerFirstName) {
		this.developerFirstName = developerFirstName;
	}

	public void setDeveloperLastName(String developerLastName) {
		this.developerLastName = developerLastName;
	}

	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	public void setDeveloperPhone(String developerPhone) {
		this.developerPhone = developerPhone;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
