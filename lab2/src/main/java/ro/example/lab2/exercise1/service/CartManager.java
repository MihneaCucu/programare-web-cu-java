package ro.example.lab2.exercise1.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import ro.example.lab2.exercise1.model.ShoppingCart;

@Service
public class CartManager {

    private final ShoppingCart injectedCart;
    private final ObjectProvider<ShoppingCart> cartProvider;

    public CartManager(
            ShoppingCart injectedCart,
            ObjectProvider<ShoppingCart> cartProvider) {
        this.injectedCart = injectedCart;
        this.cartProvider = cartProvider;
    }

    public ShoppingCart getInjectedCart() {
        return injectedCart;
    }

    public ShoppingCart createCart() {
        return cartProvider.getObject();
    }
}
