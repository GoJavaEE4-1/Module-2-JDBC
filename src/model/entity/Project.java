package model.entity;

public class Project {

    private int ProjectId;
    private String ProjectName;
    private String ProjectDescription;
    private int CompanyId;
    private int CustomerId;

    public Project(int projectId, String projectName, String projectDescription, int companyId, int customerId) {
        ProjectId = projectId;
        ProjectName = projectName;
        ProjectDescription = projectDescription;
        CompanyId = companyId;
        CustomerId = customerId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public String getProjectDescription() {
        return ProjectDescription;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public void setProjectDescription(String projectDescription) {
        ProjectDescription = projectDescription;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
}
