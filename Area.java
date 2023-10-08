public class Area {
    private final int width;
    private final int height;
    private int currentPositionX;
    private int currentPositionY;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
        currentPositionX = 0;
        currentPositionY = 0;
    }

    public int getWidth() {
        return width;
    }

    public String getCurrentPosition() {
        return "[" + (currentPositionX + 1) + ", " + (currentPositionY + 1) + "]";
    }

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
