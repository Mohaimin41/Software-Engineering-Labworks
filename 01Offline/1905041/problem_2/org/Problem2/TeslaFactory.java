package org.Problem2;

public class TeslaFactory extends AbstractCarFactory {


    @Override
    Car manufacture() {
        return new Tesla("Tesla");
    }
}
