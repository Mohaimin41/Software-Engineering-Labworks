package org.Problem2;

public class Japan implements ManufacturingCountry {
    @Override
    public String toString() {
        return "Japan";
    }


    public Japan() {
        System.out.println("Setting Manufacturing Country for Toyota: Japan");
    }
}
