package users;

import observers.DeveloperObserver;

import java.util.ArrayList;

public class Developer extends AbstractUser{
    public Developer(DeveloperObserver observer, String name) {
        this.notifiers = new ArrayList<>();
        this.name = name;
        observer.addUser(this);
    }
}
