package org.Problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String prompt(boolean anotherPCOrderPrompt) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (anotherPCOrderPrompt) {
            System.out.println("Would you like to order another PC? Please enter your choice or 'n' to exit: ");
        } else {
            System.out.println("Would you like to order a PC? Please enter your choice or 'n' to exit: ");
        }

        System.out.println("1. Gaming PC: AMD Ryzen 7 5700X with CPU Cooler");
        System.out.println("2. Intel Core i5 11th Gen PC with liquid Cooler");
        System.out.println("3. Intel Core i7 11th Gen PC with DVD Drive");
        System.out.println("4. Intel Core i9 11th Gen PC");
        System.out.println("Enter a number: ");
        return (br.readLine().strip());
    }

    static boolean addRam(PC pc) throws IOException {
        System.out.println("Would you like to add 8GB DDR4 ram? Choose one if you want to or enter 'n' if not: ");
        System.out.println("1. 2666 MHz\n2. 3200 MHz");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = br.readLine().strip();

        if (choice.equalsIgnoreCase("1")) {
            pc.addExtraComponents(new RAM2666MHz());
            return false;

        } else if (choice.equalsIgnoreCase("2")) {
            pc.addExtraComponents(new RAM3200MHz());
            return false;
        } else if (choice.equalsIgnoreCase("n")) {
            return false;
        } else if (choice.equalsIgnoreCase("O")) {
            System.out.println("Current Order not finalised yet, you may add items.");
            return true;
        } else {
            System.out.println("Choose valid option: ");
            return true;
        }
    }

    static boolean addGraphicsCard(PC pc) throws IOException {

        System.out.println("Would you like to add Graphics Card? Choose one if you want to or enter 'n' if not: ");
        System.out.println("1. 2 GB\n2. 4 GB");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = br.readLine().strip();

        if (choice.equalsIgnoreCase("1")) {
            pc.addExtraComponents(new GraphicsCard2GB());
            return false;
        } else if (choice.equalsIgnoreCase("2")) {
            pc.addExtraComponents(new GraphicsCard4GB());
            return false;
        } else if (choice.equalsIgnoreCase("n")) {
            return false;
        } else if (choice.equalsIgnoreCase("O")) {
            System.out.println("Current Order still being finalised, you may add another item.");
            return true;
        } else {
            System.out.println("Choose valid option: ");
            return true;
        }
    }

    static PCBuilder getPCBuilder(int userChoice) {
        PCBuilder pcBuilder = null;

        if (userChoice == 1) {
            pcBuilder = new GamingPCBuilder();

        } else if (userChoice == 2) {
            pcBuilder = new CoreI5PCBuilder();

        } else if (userChoice == 3) {
            pcBuilder = new CoreI7PCBuilder();

        } else if (userChoice == 4) {
            pcBuilder = new CoreI9PCBuilder();

        }
        return pcBuilder;
    }

    static void constructPC(PCBuilder pcBuilder) throws IOException {
        if (pcBuilder != null) {
            Director.Construct(pcBuilder);
            PC pc = pcBuilder.getPC();
            while (Main.addRam(pc)) {
            }
            while (Main.addGraphicsCard(pc)) {
            }

            pc.showPC();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String userOperationChoice;

        // outer while loop
        // 2 commands:
        // O: opens an order
        // E: exits
        while (true) {
            System.out.println("Enter a command, 'O' to open an order, 'E' for exit: ");
            userOperationChoice = rd.readLine().strip();

            if (userOperationChoice.equalsIgnoreCase("E")) {
                break;
            } else if (userOperationChoice.equalsIgnoreCase("O")) {
                // do order
                boolean continuingOrderFlag = true;
                String userOrderChoice;
                boolean anotherPCPromptFlag = false;

                // inner while loop
                // take order
                // any wrong 'O' press would get error message
                while (continuingOrderFlag) {
                    userOrderChoice = Main.prompt(anotherPCPromptFlag);

                    if (!anotherPCPromptFlag) {
                        anotherPCPromptFlag = true;
                    }

                    if (userOrderChoice.equals("O")) {
                        System.out.println("Current order still not finalised");

                    } else if (userOrderChoice.equals("1") || userOrderChoice.equals("2") || userOrderChoice.equals("3") || userOrderChoice.equals("4")) {
                        // valid order processing
                        PCBuilder pcBuilder = Main.getPCBuilder(Integer.parseInt(userOrderChoice));

                        Main.constructPC(pcBuilder);
                    } else if (userOrderChoice.equalsIgnoreCase("n")) {
                        continuingOrderFlag = false;
                        anotherPCPromptFlag = false;
                    } else {
                        anotherPCPromptFlag = false;
                    }

                }
            }
        }

    }
}
