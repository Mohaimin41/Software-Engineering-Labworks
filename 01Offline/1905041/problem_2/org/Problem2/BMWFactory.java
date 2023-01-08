package org.Problem2;

public class BMWFactory extends AbstractCarFactory {

    @Override
    Car manufacture() {
        return new BMW("BMW");
    }
}
