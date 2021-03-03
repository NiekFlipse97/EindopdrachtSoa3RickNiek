package users;

import observers.DeveloperObserver;

import java.util.ArrayList;

public class Developer extends AbstractUser{
    public Developer(DeveloperObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
