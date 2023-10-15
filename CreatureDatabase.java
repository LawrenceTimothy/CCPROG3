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

        EL1_CREATURES.add(new Creature("Strawander", Type.FIRE, "A", 1));
        EL1_CREATURES.add(new Creature("Chocowool", Type.FIRE, "B", 1));
        EL1_CREATURES.add(new Creature("Parfit", Type.FIRE, "C", 1));
        EL1_CREATURES.add(new Creature("Brownisaur", Type.GRASS, "D", 1));
        EL1_CREATURES.add(new Creature("Frubat", Type.GRASS, "E", 1));
        EL1_CREATURES.add(new Creature("Malts", Type.GRASS, "F", 1));
        EL1_CREATURES.add(new Creature("Squirpie", Type.WATER, "G", 1));
        EL1_CREATURES.add(new Creature("Chocolite", Type.WATER, "H", 1));
        EL1_CREATURES.add(new Creature("Oshacone", Type.WATER, "I", 1));
    }
}