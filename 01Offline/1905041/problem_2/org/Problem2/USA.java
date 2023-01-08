package org.Problem2;

public class USA implements ManufacturingCountry {
    @Override
    public String toString() {
        return "USA";
    }


    public USA() {
        System.out.println("Setting Manufacturing Country for Tesla: USA");
    }
}
