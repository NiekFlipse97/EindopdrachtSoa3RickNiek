package discussionthreads;

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
        return getDeveloper().getName();
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Developer getDeveloper() {
        return developer;
    }

    @Override
    public void print() {
        System.out.print(" ^--- " + getName());
        System.out.println(" : " + getDescription());
    }
}
