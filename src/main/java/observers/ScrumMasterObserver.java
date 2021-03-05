package observers;

import users.ScrumMaster;

import java.util.ArrayList;
import java.util.List;

public class ScrumMasterObserver implements IObserver {
    private List<ScrumMaster> users = new ArrayList<>();

    public void addUser(ScrumMaster user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
