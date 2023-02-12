import java.util.ArrayList;
import java.util.List;

public abstract class Beverages {
    String description;

    public List<String> getDescription() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(description);
        return arrayList;
    }

    public abstract double cost();
    public abstract List<String> getElements();
}

abstract class Coffee extends Beverages {
    
    public abstract List<String> getDescription();
}

abstract class CondimentsDecorator extends Beverages {
    
    public abstract List<String> getDescription();
}

abstract class CoffeeBase extends Beverages {
    
    public abstract List<String> getDescription();
}
