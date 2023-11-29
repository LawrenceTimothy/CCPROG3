import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Creature> capturedCreatures;
    private Creature activeCreature;
    private static Inventory instance;

    public Inventory() {
        this.capturedCreatures = new ArrayList<>();
        this.activeCreature = null; 
    }

    public void addCapturedCreature(Creature creature) {
        capturedCreatures.add(creature);
    }

    public List<Creature> getCapturedCreatures() {
        return capturedCreatures;
    }

    public Creature getActiveCreature() {
        return activeCreature;
    }

    public void replaceCapturedCreature(Creature oldCreature, Creature newCreature) {
        capturedCreatures.remove(oldCreature);
        capturedCreatures.add(newCreature);
    }

    public void changeActiveCreature(Creature creature) {
        activeCreature = creature;
    }

    public List<Creature> getCreatures() {
        return capturedCreatures;
    }

    public void addCreature(Creature creature) {
        capturedCreatures.add(creature);
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance; 
}
}
