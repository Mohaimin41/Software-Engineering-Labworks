package org.Problem2;

public class HydrogenFuelCellEngine implements Engine {
    @Override
    public String toString() {
        return "Hydrogen Fuel Cell Engine";
    }

    public HydrogenFuelCellEngine() {
        System.out.println("Making engine\nEngine Type: Hydrogen Fuel Cell");
    }
}
