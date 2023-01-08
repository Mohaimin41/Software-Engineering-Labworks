package org.Problem2;

public class FactoryCreator {
    static AbstractCarFactory getFactory(String ContinentName) {
        if (ContinentName == null) {
            return null;
        } else if (ContinentName.strip().equalsIgnoreCase("Asia")) {
            System.out.println("Selecting Toyota for Asia: ");
            return new ToyotaFactory();
        } else if (ContinentName.strip().equalsIgnoreCase("Europe")) {
            System.out.println("Selecting BMW for Europe: ");
            return new BMWFactory();
        } else if (ContinentName.strip().equalsIgnoreCase("America")) {
            System.out.println("Selecting Tesla for America");
            return new TeslaFactory();
        }

        return null;
    }
}
