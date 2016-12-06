package java_ee_module_2;

import java.util.Date;

public class Project {

    private int projectId;
    private String projectName;
    private Date projectDate;
    private Company company;
    private Customer customer;

    public Project(int projectId, String projectName, Date projectDate, Company company, Customer customer) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.company = company;
        this.customer = customer;
    }
    
    public Project(int projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}
    
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
