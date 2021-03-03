package users;

import observers.LeadDeveloperObserver;

import java.util.ArrayList;

public class LeadDeveloper extends AbstractUser{

    public LeadDeveloper(LeadDeveloperObserver observer, String name) {
        this.notifiers = new ArrayList<>();
        this.name = name;
        observer.addUser(this);
    }

}
