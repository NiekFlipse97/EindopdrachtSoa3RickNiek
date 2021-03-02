package users;

import notifiers.INotifier;
import observers.ScrumMasterObserver;

import java.util.List;

public class ScrumMaster {
    private List<INotifier> notifiers;

    public ScrumMaster(ScrumMasterObserver observer) {
        observer.addUser(this);
    }

    public void addNotifier(INotifier notifier) {
        notifiers.add(notifier);
    }

    public void notify(String message) {
        for (int i = 0; i < notifiers.size(); i++) {
            notifiers.get(i).notify(message);
        }
    }
}
