package users;

import notifiers.INotifier;
import observers.ScrumMasterObserver;

import java.util.ArrayList;
import java.util.List;

public class ScrumMaster extends AbstractUser {
    private List<INotifier> notifiers;

    public ScrumMaster(ScrumMasterObserver observer) {
        notifiers = new ArrayList<>();
        observer.addUser(this);
    }
}
