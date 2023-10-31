
/**
 * Represents the area with specified width and height. The current position
 * within the are can be modified by moving up, down, left, or right.
 */
public abstract class Area {
    /** The width of the area.*/
    protected int width;

    /** The height of the area.*/
    protected int height;

    /** The current position of the character in the area.*/
    protected int currentPositionX;

    /** The current position of the character in the area.*/
    protected int currentPositionY;


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
                if (currentPositionY > 0) {
                    currentPositionY--;
                    return true;
                }
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
                if (currentPositionY < height - 1) {
                    currentPositionY++;
                    return true;
                }
                break;
        }
        return false;
    }

    public abstract int getMaxCreatures();
}