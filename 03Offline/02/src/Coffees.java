import java.util.ArrayList;
import java.util.List;

class Milk extends CoffeeBase {
    double price = 50;
    String description = "Milk";

    @Override
    public List<String> getDescription() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price;
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(description);
        return arrayList;
    }
}

class Water extends CoffeeBase {
    double price = 0;
    String description = "Water";

    @Override
    public List<String> getDescription() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price;
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(description);
        return arrayList;
    }

}

class BlackCoffee extends Coffee {
    CoffeeBase coffeeBase;
    String description = "Black Coffee";

    public BlackCoffee() {
        coffeeBase = new Water();
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffeeBase.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return coffeeBase.cost() + 30;
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffeeBase.getElements();
        arrayList.add("Ground Coffee Beans");
        return arrayList;
    }

}

class MilkCoffee extends Coffee {
    CoffeeBase coffeeBase;
    String description = "Milk Coffee";

    public MilkCoffee() {
        coffeeBase = new Milk();
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffeeBase.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return coffeeBase.cost() + 30;
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffeeBase.getElements();
        arrayList.add("Ground Coffee Beans");
        return arrayList;
    }
}

class CoffeeMug extends Beverages {
    Beverages decoratedCoffee;
    double price = 100;

    public CoffeeMug(Beverages decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public List<String> getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return price + decoratedCoffee.cost();
    }

    @Override
    public String toString() {
        String coffeeName = "";
        String coffeeDescription = "";
        
        List<String> coffeeIngredients = decoratedCoffee.getElements();
        List<String> coffeeElements = decoratedCoffee.getDescription();
        // check last item that is condiment to set name;
        String lastCondiment = coffeeElements.get(coffeeElements.size() - 1);
        if (lastCondiment.equalsIgnoreCase("Ground Coffee Beans")) {
            coffeeName = "Americano";
        } else if (lastCondiment.equalsIgnoreCase("Cream")) {
            coffeeName = "Espresso";
        } else if (lastCondiment.equalsIgnoreCase("Chocolate Syrup")) {
            coffeeName = "Mocha";
        } else if (lastCondiment.equalsIgnoreCase("Cinnamon Powder")) {
            coffeeName = "Capuccino";
        } else if (lastCondiment.equalsIgnoreCase("Milk Coffee") || lastCondiment.equalsIgnoreCase("Black Coffee")) {
            coffeeName = lastCondiment;
        }

        coffeeDescription = coffeeName + " $" + (decoratedCoffee.cost() + price) + ": ";

        int sz = coffeeIngredients.size();
        for (int i = 0; i < sz; i++) {
            coffeeDescription += coffeeIngredients.get(i);
            if (i < sz - 1) {
                coffeeDescription += ", ";
            }
        }

        return coffeeDescription;
    }

    @Override
    public List<String> getElements() {
        return decoratedCoffee.getElements();
    }

}