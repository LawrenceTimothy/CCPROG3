import java.util.ArrayList;

/**
 * Represents a database of creatures, specifically for evolution level 1 (EL1) creatures.
 */
public class CreatureDatabase {
    /** The list of EL1 creatures in the database. */
    public final ArrayList<Creature> EL1_CREATURES;
    public final ArrayList<Creature> EL2_CREATURES;
    public final ArrayList<Creature> EL3_CREATURES;

    /**
     * Creates a new creature database with the list of EL1 creatures.
     */
    public CreatureDatabase() {
        EL1_CREATURES = new ArrayList<Creature>();
        EL1_CREATURES.add(new Creature("Strawmander", "FIRE", "A", 1));
        EL1_CREATURES.add(new Creature("Chocowool", "FIRE", "B", 1));
        EL1_CREATURES.add(new Creature("Parfit", "FIRE", "C", 1));
        EL1_CREATURES.add(new Creature("Brownisaur", "GRASS", "D", 1));
        EL1_CREATURES.add(new Creature("Frubat", "GRASS", "E", 1));
        EL1_CREATURES.add(new Creature("Malts", "GRASS", "F", 1));
        EL1_CREATURES.add(new Creature("Squirpie", "WATER", "G", 1));
        EL1_CREATURES.add(new Creature("Chocolite", "WATER", "H", 1));
        EL1_CREATURES.add(new Creature("Oshacone", "WATER", "I", 1));

        EL2_CREATURES = new ArrayList<Creature>();
        EL2_CREATURES.add(new Creature("Strawleon", "FIRE", "A",2));
        EL2_CREATURES.add(new Creature("Chocofluff", "FIRE", "B", 2));
        EL2_CREATURES.add(new Creature("Parfure", "FIRE", "C", 2));
        EL2_CREATURES.add(new Creature("Chocosaur", "GRASS", "D", 2));
        EL2_CREATURES.add(new Creature("Golberry", "GRASS", "E", 2));
        EL2_CREATURES.add(new Creature("Kirlcake", "GRASS", "F", 2));   
        EL2_CREATURES.add(new Creature("Tartortle", "WATER", "G", 2));
        EL2_CREATURES.add(new Creature("Chocolish", "WATER", "H", 2));
        EL2_CREATURES.add(new Creature("Dewice", "WATER", "I", 2));

        EL3_CREATURES = new ArrayList<Creature>();
        EL3_CREATURES.add(new Creature("Strawizard", "FIRE", "A", 3));
        EL3_CREATURES.add(new Creature("Candaros", "FIRE", "B", 3));
        EL3_CREATURES.add(new Creature("Parfelure", "FIRE", "C", 3));
        EL3_CREATURES.add(new Creature("Fudgasaurs", "GRASS", "D", 3));
        EL3_CREATURES.add(new Creature("Croberry", "GRASS", "E", 3));
        EL3_CREATURES.add(new Creature("Velvevoir", "GRASS", "F", 3));
        EL3_CREATURES.add(new Creature("Piestoise", "WATER", "G", 3));
        EL3_CREATURES.add(new Creature("Icesundae", "WATER", "H", 3));
        EL3_CREATURES.add(new Creature("Samurcone", "WATER", "I", 3));

    }
}