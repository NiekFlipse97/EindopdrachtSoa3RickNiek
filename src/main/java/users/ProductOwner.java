package users;

import notifiers.INotifier;
import observers.ProductOwnerObserver;

import java.util.ArrayList;
import java.util.List;

public class ProductOwner extends AbstractUser {
    private List<INotifier> notifiers;

    public ProductOwner(ProductOwnerObserver observer, String name) {
        this.notifiers = new ArrayList<>();
        this.name = name;
        observer.addUser(this);
    }

}
