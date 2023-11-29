/**
 * The {@code Area1} class represents a specific area, extending from a base {@code Area} class.
 * This area is characterized by a maximum number of creatures it can contain, which is defined as 1.
 * The area also has unique movement behavior
 */

public class Area1 extends Area {
    /**
    * The maximum number of creatures that can be present in this area.
    *  It is set to 1 and is a constant value for all {@code Area1} instances.
    */
    private final int MAX_CREATURES = 1;


    /**
    * Constructs an {@code Area1} object with predefined dimensions and creature capacity.
    * The dimensions and creature capacity are passed to the superclass {@code Area} constructor.
    */
    public Area1() {
        super(5, 1); // Calls the superclass constructor with specific dimensions and capcity
    }

    /**
     * Retirieves the maximum number of creatures that this are can contain.
     * 
     * @return The maximum number of creatures that this are can contain.
     */
    public int getMaxCreatures(){
        return MAX_CREATURES;
    }


    /**
     * Moves the character in the specified direction.
     * Certain directions (1 and 4) are considered out-of-bounds and will return {@code false}.
     * 
     * @param direction The direction to move the character in.
     * @return {@code true} if the character was moved successfully, {@code false} otherwise.
     */
    public boolean move(int direction) {
        if (direction == 1 || direction == 4) {
            System.out.println("out-of-bounds!");
            return false;
        }
        return super.move(direction);
    }
}
