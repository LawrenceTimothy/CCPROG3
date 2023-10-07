import java.util.ArrayList;

public class Inventory {
    private ArrayList<Creature> creatures = new ArrayList<Creature>();
    private Creature activeCreature;

    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (activeCreature == null) {
            activeCreature = creature;
        }
    }

    public Creature getActiveCreature() {
        return activeCreature;
    }

    public void changeActiveCreature(Creature creature) {
        if (creatures.contains(creature)) {
            activeCreature = creature;
        }
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }
}
