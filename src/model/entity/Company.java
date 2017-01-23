package model.entity;

public class Company implements Model{

    private int companyId;
    private String companyName;

    public Company(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Company() {}

	public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {

        return "----------------------------------------------------------------------" + "\n" +
                "Company name: " + companyName + "; " + "\n" +
                "Company ID: " + companyId + "\n";
    }
}
