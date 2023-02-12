public abstract class Component {
    boolean isLeaf = true;

    void setRole(String role) {
        throw new UnsupportedOperationException();
    }

    String getRole() {
        throw new UnsupportedOperationException();
    }

    void setName(String name) {
        throw new UnsupportedOperationException();
    }

    String getName() {
        throw new UnsupportedOperationException();
    }

    void setProject(String project) {
        throw new UnsupportedOperationException();
    }

    String getProject() {
        throw new UnsupportedOperationException();
    }

    int getSuperviseeCount() {
        throw new UnsupportedOperationException();
    }

    void add(Component components) {
        throw new UnsupportedOperationException();
    }

    void remove(Component components) {
        throw new UnsupportedOperationException();
    }

    void removeAll() {
        throw new UnsupportedOperationException();
    }

    Component getChild() {
        throw new UnsupportedOperationException();
    }

    void details() {
        throw new UnsupportedOperationException();
    }

    void hiearchy() {
        throw new UnsupportedOperationException();
    }
}
