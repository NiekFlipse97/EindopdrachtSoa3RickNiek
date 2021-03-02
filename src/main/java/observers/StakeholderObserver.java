package observers;

import users.Stakeholder;

import java.util.List;

public class StakeholderObserver implements IObserver {
    private List<Stakeholder> users;

    public void addUser(Stakeholder user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
