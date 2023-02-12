import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter option:");
            System.out.println("1. Order Coffee\n2. Exit");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("1")) {
                double totalCost = 0;
                List<Beverages> orderList = new ArrayList<Beverages>();

                while (true) {

                    System.out.println("\nPlease choose your type of coffee: ");
                    System.out.println("1. Americano\n2. Espresso\n3. Capuccino\n4. Mocha\n5. End Order");

                    String coffeChoice = scanner.nextLine();
                    if (coffeChoice.equalsIgnoreCase("1")) {
                        orderList.add(new CoffeeMug(new GroundCoffeeBeans(new BlackCoffee())));

                    } else if (coffeChoice.equalsIgnoreCase("2")) {
                        orderList.add(new CoffeeMug(new DairyCream(new BlackCoffee())));

                    } else if (coffeChoice.equalsIgnoreCase("3")) {
                        orderList.add(new CoffeeMug(new CinnamonPowder(new MilkCoffee())));

                    } else if (coffeChoice.equalsIgnoreCase("4")) {
                        orderList.add(new CoffeeMug(new ChocolateSyrup(new MilkCoffee())));

                    } else if (coffeChoice.equalsIgnoreCase("5")) {
                        break;
                    } else {
                        System.out.println("Please choose a correct option.");
                    }
                    
                    System.out.println("Your current order: ");
                    for (Beverages beverages : orderList) {
                        System.out.println(beverages);
                    }
                }

                System.out.println("Here is your order:");
                for (Beverages beverages : orderList) {
                    totalCost += beverages.cost();
                    System.out.println(beverages);
                }
                System.out.println("Your total bill: $" + totalCost);

            } else if (option.equalsIgnoreCase("2")) {
                break;
           
            } else {
                System.out.println("Please choose correct option.");
           
            }
        }

        scanner.close();

    }
}
