import java.util.ArrayList;
import java.util.List;

public class Manager extends Component {
    String name;
    String role;
    String currentProject;
    List<Component> supervisees;

    Manager() {
        supervisees = new ArrayList<Component>();
        isLeaf = false;
        role = "Project Manager";
    }

    @Override
    void add(Component component) {
        if (component instanceof Developer && supervisees.contains(component) == false) {
            supervisees.add(component);
        } else {
            System.out.println("Given component not a developer or already under this manager's supervision.");
        }
    }

    @Override
    void details() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Current Project: " + currentProject);
        System.out.println("Number of Supervisees: " + supervisees.size());
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getProject() {
        return currentProject;
    }

    @Override
    String getRole() {
        return role;
    }

    @Override
    int getSuperviseeCount() {
        return supervisees.size();
    }

    @Override
    void hiearchy() {
        System.out.print("- " + name + "(" + currentProject + ")" + "\n");
        for (Component component : supervisees) {
            System.out.print("\t\t");
            component.hiearchy();
        }
    }

    @Override
    void remove(Component component) {
        if (component instanceof Developer && supervisees.contains(component) == true) {
            component.removeAll();
            supervisees.remove(component);
        } else {
            System.out.println("Given developer not supervised by this manager");
        }
    }

    @Override
    void removeAll() {
        for (Component component : supervisees) {
            component.removeAll();
            // supervisees.remove(component);

        }
        System.out.println("Manager " + name + " removed");
    }

    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    void setProject(String project) {
        this.currentProject = project;
    }

    @Override
    void setRole(String role) {
        this.role = role;
    }

}
