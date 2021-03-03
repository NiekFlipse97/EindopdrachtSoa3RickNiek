package users;

import observers.TesterObserver;

import java.util.ArrayList;

public class Tester extends AbstractUser {
    public Tester(TesterObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
