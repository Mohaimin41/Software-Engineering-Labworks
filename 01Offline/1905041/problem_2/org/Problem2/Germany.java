package org.Problem2;

public class Germany implements ManufacturingCountry {
    @Override
    public String toString() {
        return "Germany";
    }


    public Germany() {
        System.out.println("Setting Manufacturing Country for BMW: Germany");
    }
}
