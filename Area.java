public class Area {
    private final int width;
    private final int height;
    private int currentPositionX;
    private int currentPositionY;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String getCurrentPosition() {
        return "[" + currentPositionX + ", " + currentPositionY + "]";
    }

    public boolean move(int direction) {
        switch(direction) {
            case 1: // UP
                if (currentPositionY > 0) {
                    currentPositionY--;
                    return true;
                }
                break;
            case 2: // LEFT
                if (currentPositionX > 0) {
                    currentPositionY--;
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
}