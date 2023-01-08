package org.Problem2;

public class Car {
    protected String name;
    protected Color color;
    protected DriveTrain driveTrain;
    protected ManufacturingCountry manufacturingCountry;
    protected Engine engine;

    Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " Specifications: " +
                "\nManufacturing Country :" + manufacturingCountry +
                "\nColor: " + color +
                "\nDrive Train: " + driveTrain +
                "\nEngine: " + engine;
    }
}
