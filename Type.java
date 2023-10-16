/**
 * Represents a type of creature, such as FIRE, WATER, or GRASS.
 */
public class Type {
    /** Represents the FIRE type. */
    private final String FIRE = new String("FIRE");

    /** Represents the WATER type. */
    private final String WATER = new String("WATER");

    /** Represents the GRASS type. */
    private final String GRASS = new String("GRASS");

    /** The name of the type. */
    private String Type;

    /**
     * Private constructor to ensure are only created within this class.
     * @param Type The name of the type.
     */
    private Type (String Type) {
        this.Type = Type;
    }

    /**
     * Checks if the given ibject is equal to this type.
     * Two types are equal if they have the same name.
     * 
     * @param obj The object to compare to.
     * @return true if the objects are the same or have the same name, false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        String type = (String) obj;
        return Type.equals(type);
    }
    

    /**
     * Returns the name of the type as a string.
     * @return The name of the type.
     */
    public String toString() {
        return Type;
    }
}