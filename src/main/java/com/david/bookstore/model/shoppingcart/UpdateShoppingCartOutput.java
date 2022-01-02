package com.david.bookstore.model.shoppingcart;

import com.david.bookstore.domain.shoppingcart.ShoppingCart;

public class UpdateShoppingCartOutput {

    private ShoppingCart shoppingCart;

    public UpdateShoppingCartOutput() {
    }

    public UpdateShoppingCartOutput(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
