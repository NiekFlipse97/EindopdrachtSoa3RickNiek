package observers;

import users.LeadDeveloper;

import java.util.ArrayList;
import java.util.List;

public class LeadDeveloperObserver implements IObserver {
    private List<LeadDeveloper> users = new ArrayList<>();

    public void addUser(LeadDeveloper user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
