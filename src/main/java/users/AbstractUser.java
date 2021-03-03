package users;

import notifiers.INotifier;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUser {

    private String name;
    private List<INotifier> notifiers = new ArrayList<>();

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

    public void setName(String name) {
        this.name = name;
    }
}
