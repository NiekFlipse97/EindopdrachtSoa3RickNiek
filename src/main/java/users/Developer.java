package users;

import observers.DeveloperObserver;

public class Developer extends AbstractUser{
    public Developer(DeveloperObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
