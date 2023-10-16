import java.util.ArrayList;

/**
 * Represents a database of creatures, specifically for evolution level 1 (EL1) creatures.
 */
public class CreatureDatabase {
    /** The list of EL1 creatures in the database. */
    public final ArrayList<Creature> EL1_CREATURES;

    /**
     * Creates a new creature database with the list of EL1 creatures.
     */
    public CreatureDatabase() {
        EL1_CREATURES = new ArrayList<Creature>();

        EL1_CREATURES.add(new Creature("Strawander", "FIRE", "A", 1));
        EL1_CREATURES.add(new Creature("Chocowool", "FIRE", "B", 1));
        EL1_CREATURES.add(new Creature("Parfit", "FIRE", "C", 1));
        EL1_CREATURES.add(new Creature("Brownisaur", "GRASS", "D", 1));
        EL1_CREATURES.add(new Creature("Frubat", "GRASS", "E", 1));
        EL1_CREATURES.add(new Creature("Malts", "GRASS", "F", 1));
        EL1_CREATURES.add(new Creature("Squirpie", "WATER", "G", 1));
        EL1_CREATURES.add(new Creature("Chocolite", "WATER", "H", 1));
        EL1_CREATURES.add(new Creature("Oshacone", "WATER", "I", 1));
    }
}