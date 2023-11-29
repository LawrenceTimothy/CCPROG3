import java.util.Scanner;

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

    /**
     * Allows the character to explore Area 1, with a chance to encounter creatures.
     * 
     * @param character The character to explore the area.
     * @param creaturesInfo The creatures database.
     * @param scanner The scanner to read user input.
     */
    public void exploreArea(Character character, CreaturesDescription creaturesInfo, Scanner scanner) {
        boolean exploring = true;
        
        while (exploring) {

            System.out.println("\nYou are now exploring " + this.getClass().getSimpleName());
            System.out.println("\nYou are at position " + this.getCurrentPosition());
            System.out.println("\n        (1)UP  \n(2)LEFT        (3)RIGHT\n        (4)DOWN\n\nType '0' to go back to menu.");
            System.out.print("\nEnter the number corresponding to your choice: ");
            int direction = scanner.nextInt();
            scanner.nextLine();

           // CreaturesDescription newcreatures = new CreaturesDescription(); // new creatures database

            if (direction == 0) {
                exploring = false;
            } else {
                boolean moved = this.move(direction);
                if (moved) {
                    System.out.println("You moved to position " + this.getCurrentPosition());
                    
                    // 40% chance to encounter a creature
                    if (Math.random() < 0.4) {
                        // Randomize a key from A to I
                        char randomKey = (char) ('A' + Math.random() * 9);
                        String key = String.valueOf(randomKey);

                        // Determine the evolution level and generate creature
                        switch (this.getMaxCreatures()) {
                            case 1:
                                creaturesInfo.generateEL1WithKey(key);
                                break;
                            case 2:
                                creaturesInfo.generateEL2WithKey(key);
                                break;
                            case 3:
                                // Randomize the evolution level from 1 to 3
                                int randomLevel = 1 + (int) (Math.random() * 3);
                                switch (randomLevel) {
                                    case 1:
                                        creaturesInfo.generateEL1WithKey(key);
                                        break;
                                    case 2:
                                        creaturesInfo.generateEL2WithKey(key);
                                        break;
                                    case 3:
                                        creaturesInfo.generateEL3WithKey(key);
                                        break;
                                }
                                break;
                        }

                        Creature encounteredCreature = new Creature(creaturesInfo.getName(), creaturesInfo.getType(), creaturesInfo.getFamily(), creaturesInfo.getLevel());             
                        System.out.println("\nYou encountered a wild " + encounteredCreature.getName() + " | TYPE: "+ encounteredCreature.getType() + " | Evolution Level: " + encounteredCreature.getEvolutionLevel() + " | ");
                        BattlePhase battlePhase = new BattlePhase(encounteredCreature, character);
                        battlePhase.start();
                        }
                    } 
                }   
        }
    }

    /**
     * Returns the maximum number of creatures that can be encountered in this area.
     * 
     * @return The maximum number of creatures that can be encountered in this area.
     */
    public abstract int getMaxCreatures();
}