package users;

import notifiers.INotifier;
import observers.StakeholderObserver;

import java.util.ArrayList;
import java.util.List;

public class Stakeholder extends AbstractUser{
    private List<INotifier> notifiers;

    public Stakeholder(StakeholderObserver observer, String name) {
        this.notifiers = new ArrayList<>();
        this.name = name;
        observer.addUser(this);
    }

}
