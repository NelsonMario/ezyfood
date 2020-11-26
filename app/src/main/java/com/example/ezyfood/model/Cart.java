package com.example.ezyfood.model;



public class Cart {

    private Stuff stuff;
    private Integer quantity;

    public Cart(Stuff stuff, int quantity) {
        this.stuff = stuff;
        this.quantity = quantity;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
