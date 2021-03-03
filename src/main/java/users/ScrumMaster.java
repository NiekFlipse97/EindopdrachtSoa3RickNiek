package users;

import observers.ScrumMasterObserver;

public class ScrumMaster extends AbstractUser {
    public ScrumMaster(ScrumMasterObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
