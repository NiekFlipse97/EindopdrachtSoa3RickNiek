package projectManagement;

import users.AbstractUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String businessName;
    private String projectName;
    private List<Sprint> sprints;

    public Project(String projectName, String businessName) {
        this.sprints = new ArrayList<>();
        this.projectName = projectName;
        this.businessName = businessName;
    }

    public void addSprint(Sprint sprint, List<AbstractUser> users, String version) {
        sprint.setProjectName(projectName);
        sprint.setBusinessName(businessName);
        sprint.setUsers(users);
        sprint.setVersion(version);

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
}
