package org.Problem1;

public class Ryzen7Processor extends AMDProcessor {
    @Override
    int price() {
        return 28000;
    }

    @Override
    String name() {
        return "AMD Ryzen 7 5700X processor";
    }
}
