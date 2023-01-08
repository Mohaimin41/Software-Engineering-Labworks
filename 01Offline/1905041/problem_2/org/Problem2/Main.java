package org.Problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String continent;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your continent.\nAvailable continents are America, Europe, Asia: ");

        continent = br.readLine();
        AbstractCarFactory factory = FactoryCreator.getFactory(continent);

        if (factory != null) {
            for (int k = 0; k < 81; k++) {
                System.out.print("=");
            }
            System.out.print("\n");

            Car car = factory.manufacture();

            for (int k = 0; k < 81; k++) {
                System.out.print("=");
            }
            System.out.print("\n");

            System.out.println(car);
        } else {
            System.out.println("Invalid continent given.");
        }
    }
}
