import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Component> companies = new ArrayList<Component>();
        while (true) {
            System.out.println("\nEnter option:");
            System.out.println(
                    "1. Add Company\n" +
                            "2. Add Manager\n" +
                            "3. Add Developer\n" +
                            "4. See Company details\n" +
                            "5. See Company hiearchy\n" +
                            "6. Remove Company\n" +
                            "7. Exit\n");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("7")) {
                break;
            } else if (option.equalsIgnoreCase("1")) {
                System.out.println("\nEnter your company name: ");
                String name = scanner.nextLine();
                Component company = new Company();
                company.setName(name);
                System.out.println("Company created: ");
                company.details();

                companies.add(company);
            } else if (option.equalsIgnoreCase("2")) {
                System.out.println("\nEnter company name first: ");
                String name = scanner.nextLine();
                Component company = new Company();
                company.setName(name);
                company.details();
                companies.add(company);

                System.out.println("\nEnter Manager Name:");
                String managerName = scanner.nextLine();
                System.out.println("Enter Project Name: ");
                String projectName = scanner.nextLine();
                Component manager = new Manager();
                manager.setName(managerName);
                manager.setProject(projectName);
                System.out.println("Manager Created: ");

                manager.details();
                company.add(manager);
            } else if (option.equalsIgnoreCase("3")) {
                System.out.println("\nEnter company name first: ");
                String name = scanner.nextLine();
                Component company = new Company();
                company.setName(name);
                company.details();
                companies.add(company);

                System.out.println("\nEnter Manager Name Then: ");
                String managerName = scanner.nextLine();
                System.out.println("Enter Project Name: ");
                String projectName = scanner.nextLine();
                Component manager = new Manager();
                manager.setName(managerName);
                manager.setProject(projectName);
                System.out.println("Manager Created: ");
                manager.details();
                company.add(manager);

                System.out.println("\nEnter Developer Name: ");
                String developerName = scanner.nextLine();
                Component developer = new Developer(manager);
                developer.setName(developerName);
                System.out.println("Developer Created: ");
                developer.details();
                manager.add(developer);

            } else if (option.equalsIgnoreCase("6")) {
                System.out.println("\nListing companies: ");
                for (Component component : companies) {
                    component.details();
                }
                System.out.println("\nEnter company number to remove: 1 to " + companies.size());
                int i = Integer.parseInt(scanner.nextLine());
                if (i >= 1 && i <= companies.size()) {
                    companies.get(i-1).removeAll();
                }

            } else if (option.equalsIgnoreCase("4")) {
                System.out.println("\nPrinting all company details:");
                for (Component component : companies) {
                    component.details();
                }

            } else if (option.equalsIgnoreCase("5")) {
                System.out.println("\nPrinting all company hierarchy");
                for (Component component : companies) {
                    component.hiearchy();
                }
            }

        }

        scanner.close();
    }
}
