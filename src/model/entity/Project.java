package model.entity;

import java.util.Date;

public class Project implements Model {

    private int projectId;
    private String projectName;
    private Date productionDate;
    private Company projectCompanyId;
    private Customer projectCustomerId;

    public Project(int projectId, String projectName, Date productionDate, Company projectCompanyId, Customer projectCustomerId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.productionDate = productionDate;
        this.projectCompanyId = projectCompanyId;
        this.projectCustomerId = projectCustomerId;
    }

    public Project() {}

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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Company getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Company projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public Customer getProjectCustomerId() {
        return projectCustomerId;
    }

    public void setProjectCustomerId(Customer projectCustomerId) {
        this.projectCustomerId = projectCustomerId;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------" + "\n" +
                "Проект: " + projectName + "\n" +
                "ID проекта: " + projectId + "\n" +
                "ID компании, выполняющей проект: " + projectCompanyId + "\n" +
                "ID заказчика: " + projectCustomerId;
    }
}
