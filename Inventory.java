import java.util.ArrayList;

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

    /**
     * Returns the list of creatures in the inventory.
     * 
     * @return The list of creatures in the inventory.
     */
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }
}
