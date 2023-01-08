package org.Problem1;

public class GamingPCBuilder implements PCBuilder {
    PC pc;

    GamingPCBuilder() {
        pc = new PC();
        pc.setName("Gaming PC with AMD Ryzen 7 5500X Processor");
    }

    @Override
    public void addBase() {
        pc.addComponents(new BasePCComponents());
    }

    @Override
    public void addProcessor() {
        pc.addComponents(new Ryzen7Processor());
    }

    @Override
    public void addCooler() {
        pc.addComponents(new CPUCooler());
    }

    @Override
    public void addDVDDrive() {

    }

    @Override
    public PC getPC() {
        return pc;
    }
}
