package org.Problem2;

public class Toyota extends Car{
    public Toyota(String name) {
        super(name);
        System.out.println("Making your Toyota: ");

        manufacturingCountry = new Japan();
        driveTrain = new RearWheelDriveTrain();
        engine = new HydrogenFuelCellEngine();
        color = new Red();

        System.out.println("Completed manufacturing your Toyota");
    }
}
