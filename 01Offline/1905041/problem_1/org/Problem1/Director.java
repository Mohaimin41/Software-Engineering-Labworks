package org.Problem1;

public class Director {
    static void Construct(PCBuilder pcBuilder) {
        pcBuilder.addBase();
        pcBuilder.addProcessor();
        pcBuilder.addCooler();
        pcBuilder.addDVDDrive();
    }
}
