package com.david.bookstore.model.shoppingcart;

import com.david.bookstore.domain.shoppingcart.ShoppingCart;

public class CreateShoppingCartOutput {

    private ShoppingCart shoppingCart;

    public CreateShoppingCartOutput() {
    }

    public CreateShoppingCartOutput(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
