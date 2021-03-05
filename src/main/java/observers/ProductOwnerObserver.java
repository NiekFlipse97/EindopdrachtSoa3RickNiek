package observers;

import users.ProductOwner;

import java.util.ArrayList;
import java.util.List;

public class ProductOwnerObserver implements IObserver {
    private List<ProductOwner> users = new ArrayList<>();

    public void addUser(ProductOwner user) {
        users.add(user);
    }

    @Override
    public void update(String message) {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).notify(message);
        }
    }
}
