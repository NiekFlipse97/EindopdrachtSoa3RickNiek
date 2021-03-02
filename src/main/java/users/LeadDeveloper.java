package users;

import notifiers.INotifier;
import observers.LeadDeveloperObserver;

import java.util.List;

public class LeadDeveloper {
    private List<INotifier> notifiers;

    public LeadDeveloper(LeadDeveloperObserver observer) {
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
