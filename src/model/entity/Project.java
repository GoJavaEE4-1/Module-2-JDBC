package model.entity;

import java.util.Date;

public class Project {

    private int projectId;
    private String projectName;
    private Date projectDate;
    private Company companyId;
    private Customer customerId;

    public Project(int projectId, String projectName, Date projectDate, Company companyId, Customer customerId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.companyId = companyId;
        this.customerId = customerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
