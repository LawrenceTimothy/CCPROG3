import java.util.Scanner;

/**
 * Handles the game flow and character interactions for "Pokemon version 2.0".
 */
public class PlayGame {
    /** The character of the player. */
    private Character character;

    /** The area where the character is currently in. */
    private final Area area1 = new Area(5, 1);

    /** The scanner used to read user input. */
    private final Scanner scanner = new Scanner(System.in);

    /** The database of creatures. */
    private final CreatureDatabase creatureDatabase = new CreatureDatabase();

    /**
     * Starts the game, guides the user through the character setup,
     * and allows exploration.
     */
    public void startGame() {
        int creatureIndex = 1;
        int choice = -1;

        System.out.println("\nWelcome to Pokemon version 2.0!");

        System.out.print("Enter your character name: ");
        String characterName = scanner.nextLine();
        character = new Character(characterName);

        System.out.println("\nHello " + character.getName() + "! Welcome to the world of Pokemon!");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();

        System.out.println("\nYou are about to embark on a journey to become the best Pokemon trainer in the world!");
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        System.out.println("\nFirst, you will start by choosing your active creature.");

        System.out.println("\nChoose your starter creature:");
        for (Creature creature : creatureDatabase.EL1_CREATURES) {
            System.out.println(creatureIndex + ". " + creature.getName() + "(Type: " + creature.getType() + ")");
            creatureIndex++;
        }

        while (choice < 1 || choice > creatureDatabase.EL1_CREATURES.size()) {
            System.out.print("Enter the number corresponding to your choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > creatureDatabase.EL1_CREATURES.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        Creature starterCreature = creatureDatabase.EL1_CREATURES.get(choice - 1);
        character.getInventory().addCreature(starterCreature);
        character.getInventory().changeActiveCreature(starterCreature);
        System.out.println("\nYou chose " + starterCreature.getName() + " as your starter creature!");

        System.out.println("\nYou are now ready to explore the world of Pokemon!");

        boolean gameRunning = true;

        while(gameRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore (Area 1)");
            System.out.println("2. Check inventory");
            System.out.println("3. Quit");
            System.out.print("Enter the number corresponding to your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exploreArea1();
                    break;
                case 2:
                    viewInventory();
                    break;
                case 3:
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for playing!");
    }

    /**
     * Allows the character to explore Area 1, with a chance to encounter creatures.
     */
    private void exploreArea1() {
        boolean exploring = true;
        
        while (exploring) {

            System.out.println("\nYou are now exploring Area 1.");
            System.out.println("\nYou are at position " + area1.getCurrentPosition());
            System.out.println("\n        (1)UP  \n(2)LEFT        (3)RIGHT\n        (4)DOWN\n\nType '0' to go back to menu.");
            System.out.print("\nEnter the number corresponding to your choice: ");
            int direction = scanner.nextInt();
            scanner.nextLine();

            if (direction == 0) {
                exploring = false;
            } else if (area1.move(direction)) {
                System.out.println("\nYou moved to position " + area1.getCurrentPosition());

                // 40% chance of encountering a creature
                if (Math.random() < 0.4) {
                    Creature encounteredCreature = creatureDatabase.EL1_CREATURES.get((int) (Math.random() * creatureDatabase.EL1_CREATURES.size()));
                    System.out.println("\nYou encountered a " + encounteredCreature.getName() + " Type: " + encounteredCreature.getType());
                    BattlePhase battle = new BattlePhase(encounteredCreature, character);
                    battle.start();
                    continue;
                }
            }
        }
    }

    /**
     * Allows the character to view their inventory and change their active creature.
     */
    private void viewInventory() {
        boolean viewing = true;
    
        while (viewing) {
            System.out.println("\nCharacter name: " + character.getName());
            System.out.println("\nActive creature: " + character.getInventory().getActiveCreature().getName());
            System.out.println("\nYour inventory contains:");
    
            int currentIndex = 1;
            for (Creature creature : character.getInventory().getCreatures()) {
                System.out.println(currentIndex + ". Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: " + creature.getEvolutionLevel());
                currentIndex++;
            }
    
            
    
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Change active creature");
            System.out.println("2. Go back to main menu");
            System.out.print("Enter the number corresponding to your choice: ");
            int submenuChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
    
            switch (submenuChoice) {
                case 1:
                    changeActiveCreature();
                    break;
                case 2:
                    viewing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Allows the character to change their active creature.
     */
    private void changeActiveCreature() {
        System.out.println("\nChoose a creature to set as active:");
    
        int currentIndex = 1;
        for (Creature creature : character.getInventory().getCreatures()) {
            System.out.println(currentIndex + ". Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: " + creature.getEvolutionLevel());
            currentIndex++;
        }
    
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("\nEnter the number corresponding to your choice: ");
            int selectedCreatureIndex = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
    
            if (selectedCreatureIndex > 0 && selectedCreatureIndex <= character.getInventory().getCreatures().size()) {
                character.getInventory().changeActiveCreature(character.getInventory().getCreatures().get(selectedCreatureIndex - 1));
                System.out.println("\nYour active creature has been changed to " + character.getInventory().getActiveCreature().getName()+ "!");
                validChoice = true;
            } else {
                System.out.println("Invalid number choice. Please try again.");
            }
        }
    } 
}





