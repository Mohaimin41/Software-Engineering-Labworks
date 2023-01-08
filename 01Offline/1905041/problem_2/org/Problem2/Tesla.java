package org.Problem2;

public class Tesla extends Car {

    public Tesla(String name) {
        super(name);
        System.out.println("Making your Tesla: ");

        manufacturingCountry = new USA();
        driveTrain = new AllWheelDriveTrain();
        color = new White();
        engine = new ElectricEngine();

        System.out.println("Completed manufacturing your Tesla");
    }
}
