package com.david.bookstore.model.shoppingcart;

public class UpdateShoppingCartInput {

   private String bookId;
   private int quantity;

    public UpdateShoppingCartInput() {
    }

    public UpdateShoppingCartInput(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
