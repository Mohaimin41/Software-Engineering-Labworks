package org.Problem2;

public class ToyotaFactory extends AbstractCarFactory {

    @Override
    Car manufacture() {

        return new Toyota("Toyota");
    }
}
