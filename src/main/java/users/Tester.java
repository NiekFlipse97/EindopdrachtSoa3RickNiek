package users;

import notifiers.INotifier;
import observers.TesterObserver;

import java.util.ArrayList;
import java.util.List;

public class Tester extends AbstractUser {
    private List<INotifier> notifiers;

    public Tester(TesterObserver observer) {
        notifiers = new ArrayList<>();
        observer.addUser(this);
    }
}
