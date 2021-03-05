package observers;

import users.Tester;

import java.util.ArrayList;
import java.util.List;

public class TesterObserver implements IObserver {
    private List<Tester> users = new ArrayList<>();

    public void addUser(Tester user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
