package users;

import notifiers.INotifier;
import observers.ScrumMasterObserver;

import java.util.ArrayList;
import java.util.List;

public class ScrumMaster extends AbstractUser {
    private List<INotifier> notifiers;

    public ScrumMaster(ScrumMasterObserver observer, String name) {
        this.notifiers = new ArrayList<>();
        this.name = name;
        observer.addUser(this);
    }
}
