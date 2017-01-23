package model.entity;

public class Developer implements Model{

	private int developerId;
	private String developerName;
	private Project developerProjectId;
	private Company developerCompanyId;

    public Developer(int developerId,
                     String developerName,
                     Project developerProjectId,
                     Company developerCompanyId) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.developerProjectId = developerProjectId;
        this.developerCompanyId = developerCompanyId;
    }

    public Developer() {}

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Project getDeveloperProjectId() {
        return developerProjectId;
    }

    public void setDeveloperProjectId(Project developerProjectId) {
        this.developerProjectId = developerProjectId;
    }

    public Company getDeveloperCompanyId() {
        return developerCompanyId;
    }

    public void setDeveloperCompanyId(Company developerCompanyId) {
        this.developerCompanyId = developerCompanyId;
    }

    @Override
	public String toString() {
		return "----------------------------------------------------------" + "\n" +
				"Разработчик: " + developerName
				 + "\n" +
				"ID разработчика: " + developerId + "\n" +
				"ID команды разработчика: " + developerCompanyId + "\n" +
				"ID проекта, над которым работает разработчик: " + developerProjectId;
	}
}
