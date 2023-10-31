import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents an inventory containing a list of creatures and an active creature.
 */
public class Inventory {
    /** The list of creatures in the inventory. */
    private ArrayList<Creature> creatures = new ArrayList<Creature>();

    /** The active creature in the inventory. */
    private Creature activeCreature;

    /**
     * Adds a creature to the inventory, If there's no active creature, the added creature
     * becomes the active creature.
     * 
     * @param creature The creature to add.
     */
    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (activeCreature == null) {
            activeCreature = creature;
        }
    }

    /**
     * Returns the active creature in the inventory.
     * 
     * @return The active creature in the inventory.
     */
    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    /**
     * Removes a creature from the inventory. If the removed creature is the active creature,
     * the first creature in the list becomes the active creature.
     * 
     * @param creature The creature to remove.
     */
    public void changeActiveCreature(Creature creature) {
        if (creatures.contains(creature)) {
            activeCreature = creature;
        }
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    /**
     * Returns the list of creatures in the inventory.
     * 
     * @return The list of creatures in the inventory.
     */
    public ArrayList<Creature> getCreatures() {
        ArrayList<Creature> sortedCreatures = new ArrayList<>(creatures);
        Collections.sort(sortedCreatures, new Comparator<Creature>() {
            public int compare(Creature c1, Creature c2) {
                int nameComparison = c1.getName().compareTo(c2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                } else {
                    return Integer.compare(c1.getEvolutionLevel(), c2.getEvolutionLevel());
                }
            }
        });
        return sortedCreatures;
    }
}