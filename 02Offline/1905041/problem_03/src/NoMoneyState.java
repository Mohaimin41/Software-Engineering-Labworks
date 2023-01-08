public class NoMoneyState implements State {
    VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("You've paid " + amount + " taka\n");
        vendingMachine.setMoney(vendingMachine.getMoney() + amount);
        
        if (vendingMachine.getMoney() < vendingMachine.getPrice()) {
            System.out.println("You have paid total " + vendingMachine.getMoney() + " taka, you need to pay "
                    + (vendingMachine.getPrice() - vendingMachine.getMoney()) + " taka more please: ");

            vendingMachine.setCurrentState(vendingMachine.getHasMoneyState());
        
        } else if (vendingMachine.getMoney() == vendingMachine.getPrice()) {
            System.out.println("Payment complete!\nPlease enter command to dispense your product\n");
            vendingMachine.setCurrentState(vendingMachine.getsoldProductState());
        
        } else {
            System.out.println("Payment complete! Here is your change: " + (vendingMachine.getMoney() - vendingMachine.getPrice())
                    + " taka\nPlease enter command to dispense your product\n");
            vendingMachine.setMoney(vendingMachine.getPrice());
            vendingMachine.setCurrentState(vendingMachine.getsoldProductState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first, please pay " + vendingMachine.getPrice() + " taka.");
    }

}
