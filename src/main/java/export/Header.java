package export;

public class Header {

    private String logo;
    private String businessName;
    private String projectName;

    public Header(String businessName, String projectName) {
        this.businessName = businessName;
        this.projectName = projectName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return String.format("| %s - %s - %s |", businessName, projectName, logo);
    }
}
