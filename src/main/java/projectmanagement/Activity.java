package projectmanagement;

import users.Developer;

public class Activity {
    private String name;
    private String description;
    private Developer developer;
    private Boolean completed;

    public Activity(String name, String description, Developer developer) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.completed = false;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Developer getDeveloper() {
        return developer;
    }
}
