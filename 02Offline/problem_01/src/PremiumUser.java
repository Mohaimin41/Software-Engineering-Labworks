import java.util.Scanner;

public class PremiumUser implements Observers {
    private int bill = 0;
    private String name;
    private int server = 1;// 1 = ABC server, 2 = DEF server, 3 = Both
    private Subject subject;

    public PremiumUser(String name, Subject subject) {
        this.name = name;
        this.bill = 0;
        this.server = 1;
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int previousServerState, int currentServerState) {
        System.out.println("\t\tPremium User: " + name + " user window: ");

        if (previousServerState == 0 && currentServerState == 1) {

            System.out.println(
                    "ABC server is now partially down from operational state.\nDo you wish to take service from: \n1.Both ABC and DEF servers, or \n2.Fully from DEF server?\nEnter your option: ");
            
            Scanner scn = new Scanner(System.in);
            int option = Integer.parseInt(scn.nextLine());
            // int option = scn.nextInt();
            // scn.nextLine();

            if (option == 1) {
                server = 3;
                System.out.println("Continuing service from both ABC and DEF server.");

            } else if (option == 2) {
                server = 2;
                System.out.println("Shifting to DEF server.");

            } else {
                System.out.println("Please enter correct option.");
            }

            // scn.close();

        } else if (previousServerState == 0 && currentServerState == 2) {
            System.out.println("ABC Server is now fully down from operational state, service shifted to DEF server.");

        } else if (previousServerState == 1 && currentServerState == 2) {
            System.out.println(
                "ABC server is now fully down from partially down state, service shifted to DEF server.");
    
            if (server == 3) {
                server = 2;
            }

        } else {

        }
        for (int i=0;i < 80; i++) {
            System.out.print("=");
        }
        System.out.println("");
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
        return "Premium User name: " + name;
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

}
