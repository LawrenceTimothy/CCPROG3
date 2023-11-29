/**
 * The {@code Area2} class represents a specific area, extending from a base {@code Area} class.
 * This area is characterized by a maximum number of creatures it can contain, which is defined as 2.
 * It has specific dimensions defined in the constructor.
 */
public class Area2 extends Area {
    
    /**
     * The maximum number of creatures that can be present in this area.
     *  It is set to 2 and is a constant value for all {@code Area2} instances.
     */
    private final int MAX_CREATURES = 2;

    /**
     * Constructs an {@code Area2} object with predefined dimensions and creature capacity.
     * The dimensions and creature capacity are passed to the superclass {@code Area} constructor.
     */
    public Area2() {
        super(3, 3); // Call the superclass constructor with specific dimensions and capcity
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
