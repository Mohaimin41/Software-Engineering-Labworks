package org.Problem1;

public class BasePCComponents extends Items{
    @Override
    int price() {
        return 70000;
    }

    @Override
    String name() {
        return "Motherboard and 1TB HDD";
    }
}
