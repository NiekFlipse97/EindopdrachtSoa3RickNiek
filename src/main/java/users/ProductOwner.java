package users;

import observers.ProductOwnerObserver;

import java.util.ArrayList;

public class ProductOwner extends AbstractUser {
    public ProductOwner(ProductOwnerObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
