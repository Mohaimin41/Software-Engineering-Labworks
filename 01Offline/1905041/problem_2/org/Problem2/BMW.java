package org.Problem2;

public class BMW extends Car{
    public BMW(String name) {
        super(name);
        System.out.println("Making your BMW: ");

        manufacturingCountry = new Germany();
        driveTrain = new RearWheelDriveTrain();
        engine = new ElectricEngine();
        color = new Black();

        System.out.println("Completed manufacturing your BMW");
    }
}
