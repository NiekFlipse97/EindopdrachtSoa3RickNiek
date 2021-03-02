package users;

import notifiers.INotifier;
import observers.DeveloperObserver;

import java.util.List;

public class Developer {
    private List<INotifier> notifiers;

    public Developer(DeveloperObserver observer) {
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
