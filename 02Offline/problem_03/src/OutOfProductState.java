public class OutOfProductState implements State{
    VendingMachine vendingMachine;
    

    public OutOfProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Sorry, machine is out of products for now, you cannot pay now.");   
    }

    @Override
    public void dispense() {
        System.out.println("Sorry, machine is out of products for now, it cannot dispense products.");
    }
    
}
