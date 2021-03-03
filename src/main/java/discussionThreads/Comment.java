package discussionThreads;

import users.Developer;

public class Comment extends FormComponent {
    private Developer developer;
    private String description;

    public Comment(Developer developer, String description) {
        this.developer = developer;
        this.description = description;
    }

    @Override
    public String getName() {
        return developer.getName();
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void print() {
        System.out.println("Message by: " + getName());
        System.out.println("Description: " + getDescription());
    }
}
