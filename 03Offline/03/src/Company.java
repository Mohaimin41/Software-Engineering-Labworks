import java.util.ArrayList;
import java.util.List;

class Company extends Component {
    List<Component> managers;
    String name;
    String role;

    public Company() {
        managers = new ArrayList<Component>();
        isLeaf = false;
        role = "Company";
    }

    @Override
    void add(Component component) {
        if (component instanceof Manager) {
            if (managers.contains(component) == false) {
                managers.add(component);
            } else {
                System.out.println("This manager already on a project in this company");
            }
        } else {
            System.out.println("Only managers can be added to company");
        }
    }

    @Override
    void details() {
        System.out.println("Name: " + name);
        System.out.println("Total Projects Underway: " + managers.size());
        int totalDevelopers = 0;
        for (Component component : managers) {
            totalDevelopers += component.getSuperviseeCount();
        }
        System.out.println("Total Developers: " + totalDevelopers);
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void hiearchy() {
        System.out.println("- " + name);
        for (Component component : managers) {
            System.out.print("\t");
            component.hiearchy();
        }
    }

    @Override
    void remove(Component component) {
        if (component instanceof Manager && managers.contains(component) == true) {
            managers.remove(managers.indexOf(component));
        } else {
            System.out.println("Given component not a manager or not in this company");
        }
    }

    @Override
    void removeAll() {
        for (Component component : managers) {
            component.removeAll();
            // managers.remove(component);
        }
        System.out.println("Company " + name + " removed" );
    }

    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    String getRole() {
        return role;
    }

    @Override
    void setRole(String role) {
        this.role = role;
    }

}
