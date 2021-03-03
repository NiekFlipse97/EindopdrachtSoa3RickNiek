package users;

import observers.StakeholderObserver;

public class Stakeholder extends AbstractUser{
    public Stakeholder(StakeholderObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
