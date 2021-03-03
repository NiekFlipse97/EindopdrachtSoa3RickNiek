package users;

import observers.StakeholderObserver;

import java.util.ArrayList;

public class Stakeholder extends AbstractUser{
    public Stakeholder(StakeholderObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
