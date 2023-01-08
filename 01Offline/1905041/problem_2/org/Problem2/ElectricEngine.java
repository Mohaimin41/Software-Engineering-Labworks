package org.Problem2;

public class ElectricEngine implements Engine {
    @Override
    public String toString() {
        return "Electric Engine";
    }


    public ElectricEngine() {
        System.out.println("Making Engine\nEngine Type: Electric");
    }
}
