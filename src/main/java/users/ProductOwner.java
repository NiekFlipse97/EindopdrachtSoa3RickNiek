package users;

import observers.ProductOwnerObserver;

public class ProductOwner extends AbstractUser {
    public ProductOwner(ProductOwnerObserver observer, String name) {
        setName(name);
        observer.addUser(this);
    }
}
