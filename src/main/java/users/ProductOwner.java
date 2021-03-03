package users;

import notifiers.INotifier;
import observers.ProductOwnerObserver;

import java.util.ArrayList;
import java.util.List;

public class ProductOwner extends AbstractUser {
    private List<INotifier> notifiers;

    public ProductOwner(ProductOwnerObserver observer) {
        notifiers = new ArrayList<>();
        observer.addUser(this);
    }

}
