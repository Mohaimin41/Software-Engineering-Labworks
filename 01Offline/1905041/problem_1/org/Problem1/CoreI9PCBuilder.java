package org.Problem1;

public class CoreI9PCBuilder implements PCBuilder {
    PC pc;

    CoreI9PCBuilder() {
        pc = new PC();
        pc.setName("Core i9 PC");
    }

    @Override
    public void addBase() {
        pc.addComponents(new BasePCComponents());
    }

    @Override
    public void addProcessor() {
        pc.addComponents(new CoreI9Processor());
    }

    @Override
    public void addCooler() {

    }

    @Override
    public void addDVDDrive() {
    }

    @Override
    public PC getPC() {
        return pc;
    }
}
