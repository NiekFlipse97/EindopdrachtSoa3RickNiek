package users;

import notifiers.INotifier;
import observers.DeveloperObserver;

import java.util.ArrayList;
import java.util.List;

public class Developer extends AbstractUser{
    private List<INotifier> notifiers;

    public Developer(DeveloperObserver observer) {
        notifiers = new ArrayList<>();
        observer.addUser(this);
    }
}
