package users;

import notifiers.INotifier;

import java.util.List;

public abstract class AbstractUser {

    private String name;
    private List<INotifier> notifiers;

    public void addNotifier(INotifier notifier) {
        notifiers.add(notifier);
    }

    public void notify(String message) {
        for (int i = 0; i < notifiers.size(); i++) {
            notifiers.get(i).notify(message);
        }
    }

    public String getName() {
        return name;
    }
}
