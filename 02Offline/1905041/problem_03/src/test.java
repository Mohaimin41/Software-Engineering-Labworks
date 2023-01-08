import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(4);

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println(vendingMachine);
            System.out
                    .println("Please enter one option: \n1. Enter payment \n2. Dispense product\n3. Refill\n4. Exit\nYour option:");

            String s = scn.nextLine();

            if (s.equalsIgnoreCase("4")) {
                break;
            
            } else if (s.equalsIgnoreCase("1")) {
                System.out.println("Please enter payment: ");
                vendingMachine.insertMoney(Integer.parseInt(scn.nextLine()));
            
            } else if (s.equalsIgnoreCase("2")) {
                vendingMachine.dispense();
            
            } else if (s.equalsIgnoreCase("3")) {
                System.out.println("Enter amount of products to refill: ");
                vendingMachine.setCount(vendingMachine.getCount() +
                        Integer.parseInt(scn.nextLine()));
            
                    } else {
                System.out.println("Please enter valid option.");
            }
            for (int i = 0; i < 80; i++) {
                System.out.print("=");
            }
            System.out.println("");
        }

        scn.close();
    }
}
