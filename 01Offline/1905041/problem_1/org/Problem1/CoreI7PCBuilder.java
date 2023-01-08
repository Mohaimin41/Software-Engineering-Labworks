package org.Problem1;

public class CoreI7PCBuilder implements PCBuilder {
    PC pc;

    CoreI7PCBuilder() {
        pc = new PC();
        pc.setName("Core i7 PC");
    }

    @Override
    public void addBase() {
        pc.addComponents(new BasePCComponents());
    }

    @Override
    public void addProcessor() {
        pc.addComponents(new CoreI7Processor());
    }

    @Override
    public void addCooler() {

    }

    @Override
    public void addDVDDrive() {
        pc.addComponents(new DVDDrive1());
    }

    @Override
    public PC getPC() {
        return pc;
    }
}
