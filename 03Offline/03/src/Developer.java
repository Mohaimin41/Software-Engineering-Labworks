public class Developer extends Component {
    String name;
    String role;
    Component manager;

    public Developer(Component manager) {
        role = "Developer";
        this.manager = manager;
    }

    @Override
    void details() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Project: " + manager.getProject());
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getProject() {
        return manager.getProject();
    }

    @Override
    String getRole() {
        return role;
    }

    @Override
    void hiearchy() {
        System.out.print("- " + name + "\n" );
    }

    @Override
    void removeAll() {
        System.out.println("Developer " + name + " removed");
    }

    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    void setRole(String role) {
        this.role = role;
    }
}