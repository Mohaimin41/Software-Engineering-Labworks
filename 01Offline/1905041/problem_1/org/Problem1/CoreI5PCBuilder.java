package org.Problem1;

public class CoreI5PCBuilder implements PCBuilder {
    PC pc;

    CoreI5PCBuilder() {
        pc = new PC();
        pc.setName("Core i5 PC");
    }

    @Override
    public void addBase() {
        pc.addComponents(new BasePCComponents());
    }

    @Override
    public void addProcessor() {
        pc.addComponents(new CoreI5Processor());
    }

    @Override
    public void addCooler() {
        pc.addComponents(new LiquidCooler());
    }

    @Override
    public void addDVDDrive() {

    }

    @Override
    public PC getPC() {
        return pc;
    }
}
