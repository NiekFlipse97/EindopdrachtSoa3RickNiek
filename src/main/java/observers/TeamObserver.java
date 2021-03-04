package observers;

import users.AbstractUser;

import java.util.List;

public class TeamObserver implements IObserver {
    private List<AbstractUser> users;

    public void addUser(AbstractUser user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
