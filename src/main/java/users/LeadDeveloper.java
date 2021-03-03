package users;

import observers.LeadDeveloperObserver;

public class LeadDeveloper extends AbstractUser{
    public LeadDeveloper(LeadDeveloperObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
