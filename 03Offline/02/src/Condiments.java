import java.util.List;

class GroundCoffeeBeans extends CondimentsDecorator {
    String description = "Ground Coffee Beans";
    double price = 30;
    Coffee coffee;

    public GroundCoffeeBeans(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffee.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price + coffee.cost();
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffee.getElements();
        arrayList.add(description);
        return arrayList;
    }
}

class CinnamonPowder extends CondimentsDecorator {
    String description = "Cinnamon Powder";
    double price = 50;
    Coffee coffee;

    public CinnamonPowder(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffee.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price + coffee.cost();
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffee.getElements();
        arrayList.add(description);
        return arrayList;
    }
}

class DairyCream extends CondimentsDecorator {
    String description = "Cream";
    double price = 40;
    Coffee coffee;

    public DairyCream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffee.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price + coffee.cost();
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffee.getElements();
        arrayList.add(description);
        return arrayList;
    }
}

class ChocolateSyrup extends CondimentsDecorator {
    String description = "Chocolate Syrup";
    double price = 60;
    Coffee coffee;

    public ChocolateSyrup(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public List<String> getDescription() {
        List<String> arrayList = coffee.getDescription();
        arrayList.add(description);
        return arrayList;
    }

    @Override
    public double cost() {
        return price + coffee.cost();
    }

    @Override
    public List<String> getElements() {
        List<String> arrayList = coffee.getElements();
        arrayList.add(description);
        return arrayList;
    }
}