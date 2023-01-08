public class SoldProductState implements State{
    VendingMachine vendingMachine;
    
    
    public SoldProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("You have already paid, the machine is dispensing your product.");
    }

    @Override
    public void dispense() {
        System.out.println("Here is your product...");
        vendingMachine.releaseProduct();    
        
        if (vendingMachine.getCount() <= 0) {
            vendingMachine.setCurrentState(vendingMachine.getoutOfProductsState());
        } else {
            vendingMachine.setCurrentState(vendingMachine.getNoMoneyState());
        }
        vendingMachine.setMoney(0);
    }
    
}
