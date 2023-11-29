/**
 * The {@code Area3} class represents a specific area, extending from a base {@code Area} class.
 * This area is characterized by a maximum number of creatures it can contain, which is defined as 3.
 * It has specific dimensions defined in the constructor.
 */
public class Area3 extends Area {
    /**
     * The maximum number of creatures that can be present in this area.
     * It is set to 3 and is a constant value for all {@code Area3} instances.
     */
    private final int MAX_CREATURES = 3;

    /**
     * Constructs an {@code Area3} object with predefined dimensions and creature capacity.
     * The dimensions and creature capacity are passed to the superclass {@code Area} constructor.
     */
    public Area3() {
        super(4, 4); // Calls the superclass constructor with specific dimensions and capcity
    }

    /**
     * Retirieves the maximum number of creatures that this are can contain.
     * 
     * @return The maximum number of creatures that this are can contain.
     */
    public int getMaxCreatures(){
        return MAX_CREATURES;
    }
}
