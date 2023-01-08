package org.Problem1;

import java.util.ArrayList;
import java.util.List;

public class PC {
    private String name;
    private int price = 0;
    private List<Items> components = new ArrayList<Items>();
    private List<Items> addedComponents = new ArrayList<Items>();

    private int addedComponentPrice() {
        int total_price = 0;
        for (Items it : addedComponents) {
            total_price += it.price();
        }
        return total_price;
    }

    private int componentsPrice() {
        int total_price = 0;
        for (Items it : components) {
            total_price += it.price();
        }
        return total_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        price = 0;
        price = this.addedComponentPrice() + this.componentsPrice();
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addComponents(Items item) {
        components.add(item);
    }

    public void addExtraComponents(Items item) {
        addedComponents.add(item);
    }

    public void showPC() {
        for (int k = 0; k < 81; k++) {
            System.out.print("=");
        }
        System.out.print("\n");

        System.out.println("Here is your pc: " + name + ", price: " + this.getPrice() + " BDT");
        System.out.println("Base components: ");

        int i = 0;
        for (Items it : components) {
            System.out.println(++i + ". " + it);
        }

        System.out.println("Base price:\t\t\t " + this.componentsPrice() + " BDT");

        if (addedComponents.size() != 0) {
            System.out.println("Added Components: ");

            int j = 0;
            for (Items it : addedComponents) {
                System.out.println(++j + ". " + it);
            }
        }

        System.out.println("Total price:\t\t\t " + this.getPrice() + " BDT");

        if (this.getPrice() > this.componentsPrice()) {
            System.out.println("Price increased from base price of " + this.componentsPrice() +" BDT because following components were added: ");
            int j = 0;
            for (Items it : addedComponents) {
                System.out.print(++j + ". " + it.name() + "\n");
            }
        }

        for (int k = 0; k < 81; k++) {
            System.out.print("=");
        }
        System.out.print("\n");
    }

}
