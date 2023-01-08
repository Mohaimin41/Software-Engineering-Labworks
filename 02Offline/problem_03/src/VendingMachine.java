public class VendingMachine {
    State currentState;

    State noMoneyState;
    State hasMoneyState;
    State soldProductState;
    State outOfProductsState;
    int count;
    int money;
    final int price = 50;

    public VendingMachine(int count) {
        this.count = count;
        this.money = 0;
        this.noMoneyState = new NoMoneyState(this);
        this.hasMoneyState = new HasMoneyState(this);
        this.soldProductState = new SoldProductState(this);
        this.outOfProductsState = new OutOfProductState(this);
        this.currentState = this.noMoneyState;
    }

    public int getPrice() {
        return price;
    }

    public State getcurrenState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getsoldProductState() {
        return soldProductState;
    }

    public State getoutOfProductsState() {
        return outOfProductsState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void insertMoney(int amount) {
        currentState.insertMoney(amount);
    }

    void dispense() {
        currentState.dispense();
    }

    void releaseProduct() {
        System.out.println("A product comes out...");
        if (count != 0) {
            --count;
        }
    }

    @Override
    public String toString() {
        return "Vending Machine: product count = " + count + ", money paid to machine = " + money + ", product price = " + price + "\n";
    }
    
}
