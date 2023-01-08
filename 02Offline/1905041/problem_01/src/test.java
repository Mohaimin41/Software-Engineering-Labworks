import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Server server = new Server(0);

        PremiumUser premiumUser = new PremiumUser("Premium User #1", server);
        RegularUser regularUser = new RegularUser("Regular User #1", server);

        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println(server);
            System.out.println("Enter state number to change state or 4 to exit:");
            // int option = scanner.nextInt();
            
            String s = scanner.nextLine();

            int option = Integer.parseInt(s);

            for (int i=0;i < 80; i++) {
                System.out.print("=");
            }
            System.out.println("");
            
            if (option == 0 || option == 1 || option == 2) {
                server.setState(option);
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Please enter a valid option.");
                continue;
            }
        }
        scanner.close();
    }
}
