import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents an inventory containing a list of creatures and an active creature.
 */
public class Inventory {
    /** The list of creatures in the inventory. */
    private ArrayList<Creature> creatures = new ArrayList<Creature>();

    /** The index of the active creature in the inventory. */
    private int activeCreatureIndex = 0;  // By default, the first creature is active

    /**
     * Adds a creature to the inventory. If there's no active creature, the added creature
     * becomes the active creature.
     * 
     * @param creature The creature to add.
     */
    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (activeCreatureIndex < 0) {  // If there's no active creature
            activeCreatureIndex = 0;   // Set the added creature as active
        }
    }

    /**
     * Returns the active creature in the inventory.
     * 
     * @return The active creature in the inventory.
     */
    public Creature getActiveCreature() {
        if (activeCreatureIndex >= 0 && activeCreatureIndex < creatures.size()) {
            return creatures.get(activeCreatureIndex);
        } else {
            return null;  // This should not happen if the class is used correctly
        }
    }

    /**
     * Changes the active creature.
     * 
     * @param creature The creature to set as active.
     */
    public void changeActiveCreature(Creature creature) {
        int index = creatures.indexOf(creature);
        if (index != -1) {
            activeCreatureIndex = index;
        }
    }

    public void removeCreature(Creature creature) {
        if (creatures.contains(creature)) {
            creatures.remove(creature);
            // If we removed the active creature, set the first creature in the list as active
            if (creatures.size() > 0 && creature == getActiveCreature()) {
                activeCreatureIndex = 0;
            } else if (creatures.size() == 0) {
                activeCreatureIndex = -1;
            }
        }
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
