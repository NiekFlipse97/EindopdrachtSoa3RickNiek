package projectmanagement;

import users.AbstractUser;
import users.ProductOwner;
import users.ScrumMaster;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private ProductOwner productOwner;
    private String businessName;
    private String projectName;
    private List<Sprint> sprints;

    public Project(ProductOwner productOwner, String projectName, String businessName) {
        this.sprints = new ArrayList<>();
        this.projectName = projectName;
        this.businessName = businessName;
        this.productOwner = productOwner;
    }

    public void addSprint(Sprint sprint, List<AbstractUser> users, String version, ScrumMaster scrumMaster) {
        sprint.setProjectName(projectName);
        sprint.setBusinessName(businessName);
        sprint.setUsers(users);
        sprint.setVersion(version);
        sprint.setScrumMaster(scrumMaster);
        sprint.setProject(this);

        sprints.add(sprint);
    }

    public void setSprintName(Sprint sprint, String name) {
        if (name.isBlank()) return;

        sprint.setSprintName(name);
    }

    public void setSprintStartDate(Sprint sprint, LocalDateTime dateTime) {
        sprint.setStartDate(dateTime);
    }

    public void setSprintEndDate(Sprint sprint, LocalDateTime dateTime) {
        sprint.setEndDate(dateTime);
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }
}
