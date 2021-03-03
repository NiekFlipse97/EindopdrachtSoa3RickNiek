package users;

import notifiers.INotifier;
import observers.LeadDeveloperObserver;

import java.util.ArrayList;
import java.util.List;

public class LeadDeveloper extends AbstractUser{
    private List<INotifier> notifiers;

    public LeadDeveloper(LeadDeveloperObserver observer) {
        notifiers = new ArrayList<>();
        observer.addUser(this);
    }

}
