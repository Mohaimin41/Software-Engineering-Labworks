public interface Passengers {
    void whoAmI();

    void work();
}

class Crewmates implements Passengers {
    String name;

    Crewmates(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crewmates :" + name + " ";
    }

    @Override
    public void whoAmI() {
        System.out.println("I am crewmate " + name + " ");
    }

    @Override
    public void work() {
        System.out.println("Crewmate " + name + " studying the interstellar objects or doing basic maintenance. ");
    }
}

interface Monsters {
    void whoAmI();

    void sabotage();
}

class SpaceMonsters implements Monsters {
    String name;

    public SpaceMonsters(String name) {
        this.name = name;
    }

    @Override
    public void sabotage() {
        System.out.println("Monster " + name + " poisons crewmates or damages spaceship ");
    }

    @Override
    public void whoAmI() {
        System.out.println("I am monster " + name + " ");
    }

    @Override
    public String toString() {
        return name;
    }

}

class MonsterAdapter implements Passengers {
    Monsters monster;

    public MonsterAdapter(Monsters monster) {
        this.monster = monster;
    }

    @Override
    public void whoAmI() {
        System.out.println("I am crewmate " + monster + ", not suspicious at all");
    }

    @Override
    public void work() {
        monster.sabotage();
    }
}