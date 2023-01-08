import java.util.Random;
import java.util.Scanner;

public class RegularUser implements Observers {
    private int bill = 0;
    private String name;
    private int server = 1;// 1 = ABC server, 2 = DEF server, 3 = Both
    private Subject subject;

    public RegularUser(String name, Subject subject) {
        this.name = name;
        this.bill = 0;
        this.server = 1;
        this.subject = subject;
        subject.registerObserver(this);
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Regular User name: " + name;
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update(int previousServerState, int currentServerState) {
        System.out.println("\t\tRegular User: " + name + " user window: ");

        if (previousServerState == 0 && currentServerState == 1) {
            System.out.println(
                    "ABC server is now partially down from operational state.\nDo you wish to: \n1.Continue using with limited functionality, or \n2.Pay $20 to upgrade to Premium and migrate service to DEF server?\nEnter your option: ");

            Scanner scn = new Scanner(System.in);

            int option = Integer.parseInt(scn.nextLine());
            // int option = scn.nextInt();
            // scn.nextLine();

            if (option == 1) {
                server = 1;
                System.out.println("Continuing limited service from ABC server.");

            } else if (option == 2) {
                server = 2;
                System.out.println("Upgraded to Premium user. Shifting to DEF server.");

            } else {
                System.out.println("Please enter correct option.");
            }

            // scn.close();

        } else if (previousServerState == 0 && currentServerState == 2) {
            System.out.println(
                    "ABC Server is now fully down from operational state, do you wish to pay $20 to have service shifted to DEF server? (Y/N)");

            Scanner scn = new Scanner(System.in);
            String ans = scn.nextLine();

            if (ans.equalsIgnoreCase("Y")) {
                server = 2;
                System.out.println("Upgraded to Premium user. Shifting to DEF server.");

            } else if (ans.equalsIgnoreCase("N")) {
                System.out.println("Sorry for downtime, you will be notified of any change.");
            }
            

        } else if (previousServerState == 1 && currentServerState == 0) {

            bill = (new Random(System.currentTimeMillis())).nextInt(200);
            System.out.println(
                    "Server fully operational after partial downtime\nSince last change of server state, your total bill: "
                            + bill);

        } else if (previousServerState == 2 && currentServerState == 0) {
            bill = (new Random(System.currentTimeMillis())).nextInt(200);
            System.out.println(
                    "Server fully operational after full downtime\nSince last change of server state, your total bill: "
                            + bill);

        } else {

        }

        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }

}
