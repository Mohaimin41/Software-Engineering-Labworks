package org.Problem1;

public abstract class Items {
    @Override
    public String toString() {
        return this.name() + ", price: " + this.price() + " BDT";
    }

    abstract int price();
    abstract String name();
}
