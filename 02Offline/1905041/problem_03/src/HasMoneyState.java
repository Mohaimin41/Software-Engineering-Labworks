public class HasMoneyState implements State {
    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("You have paid " + amount + " taka\n");
        vendingMachine.setMoney(vendingMachine.getMoney() + amount);

        int price = vendingMachine.getPrice();
        int newAmount = vendingMachine.getMoney();

        if (newAmount < price) {
            System.out.println("You have paid total " + vendingMachine.getMoney() + " taka, you need to pay "
                    + (price - vendingMachine.getMoney()) + " taka more please: ");

        } else if (newAmount == price) {
            System.out.println("Payment complete!\nPlease enter command to dispense your product\n");

            vendingMachine.setCurrentState(vendingMachine.getsoldProductState());

        } else if (newAmount > price) {
            System.out.println("Payment complete! Here is your change: " + (vendingMachine.getMoney() - price)
                    + " taka\nPlease enter command to dispense your product\n");
            vendingMachine.setMoney(price);
            vendingMachine.setCurrentState(vendingMachine.getsoldProductState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("The machine is will dispense product shortly after payment is complete.");
        System.out.println("You have paid total " + vendingMachine.getMoney() + " taka, you need to pay "
                + (vendingMachine.getPrice() - vendingMachine.getMoney()) + " taka more please. ");

    }

}
