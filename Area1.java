public class Area1 extends Area {
    private final int MAX_CREATURES = 1;

    public Area1() {
        super(5, 1);
    }

    public int getMaxCreatures(){
        return MAX_CREATURES;
    }

    public boolean move(int direction) {
        if (direction == 1 || direction == 4) {
            System.out.println("out-of-bounds!");
            return false;
        }
        return super.move(direction);
    }
}
