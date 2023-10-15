/**
 * Represents a creature with a name, type, family, and evolution level.
 */
public class Creature {
    /** The name of the creature. */
    private String name;

    /** The type of the creature. */
    private Type type;

    /** The family of the creature. */
    private String family;

    /** The evolution level of the creature. */
    private int evolutionLevel;


    /**
     * Creates a new creature with the given name, type, family, and evolution level.
     * 
     * @param name The name of the creature.
     * @param type The type of the creature.
     * @param family The family of the creature.
     * @param evolutionLevel The evolution level of the creature.
     */
    public Creature(String name, Type type, String family, int evolutionLevel) {
        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLevel = evolutionLevel;
    }

    /**
     * Returns the name of the creature.
     * 
     * @return The name of the creature.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the type of the creature.
     * 
     * @return The type of the creature.
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the family of the creature.
     * 
     * @return The family of the creature.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Returns the evolution level of the creature.
     * 
     * @return The evolution level of the creature.
     */
    public int getEvolutionLevel() {
        return evolutionLevel;
    }
}