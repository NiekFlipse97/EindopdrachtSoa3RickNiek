package observers;

import users.Developer;

import java.util.List;

public class DeveloperObserver implements IObserver {
    private List<Developer> users;

    public void addUser(Developer user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
