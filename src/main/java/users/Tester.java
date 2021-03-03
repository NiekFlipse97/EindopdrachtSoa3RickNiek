package users;

import observers.TesterObserver;

public class Tester extends AbstractUser {
    public Tester(TesterObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
