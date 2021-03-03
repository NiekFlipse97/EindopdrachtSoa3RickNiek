package users;

import observers.ScrumMasterObserver;

import java.util.ArrayList;

public class ScrumMaster extends AbstractUser {
    public ScrumMaster(ScrumMasterObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
