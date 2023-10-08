
/**
 * Represents the area with specified width and height. The current position
 * within the are can be modified by moving up, down, left, or right.
 */
public class Area {
    /** The width of the area.*/
    private final int width;

    /** The height of the area.*/
    private final int height;

    /** The current position of the character in the area.*/
    private int currentPositionX;

    /** The current position of the character in the area.*/
    private int currentPositionY;


    /**
     * Creates a new area with the given width and height.
     * 
     * @param width The width of the area.
     * @param height The height of the area.
     */
    public Area(int width, int height) {
        this.width = width;
        this.height = height;
        currentPositionX = 0;
        currentPositionY = 0;
    }

    /**
     * Returns the height of the area.
     * 
     * @return The height of the area.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the current position in the format "[X, Y]".
     * Note: The position is 1-based, not 0-based.
     * 
     * @return The height of the area.
     */
    public String getCurrentPosition() {
        return "[" + (currentPositionX + 1) + ", " + (currentPositionY + 1) + "]";
    }


    /**
     * Moves the current position based on the specified direction.
     * 1 = UP, 2 = LEFT, 3 = RIGHT, 4 = DOWN
     * 
     * @param direction The direction to move to.
     * @return true if the character successfully moved, false otherwise (e.g., out-of-bounds).
     */
    public boolean move(int direction) {
        switch(direction) {
            case 1: // UP
                System.out.println("out-of-bounds!"); // For Area 1 
                    return false;
            case 2: // LEFT
                if (currentPositionX > 0) {
                    currentPositionX--;
                    return true;
                }
                break;
            case 3: // RIGHT
                if (currentPositionX < width - 1) {
                    currentPositionX++;
                    return true;
                }
                break;
            case 4: // DOWN
                System.out.println("out-of-bounds!"); // For Area 1 
        }
        return false;
    }
}