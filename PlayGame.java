import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Handles the game flow and character interactions for "Pokemon version 2.0".
 */
public class PlayGame {
    /** The character of the player. */
    private Character character;

    /** The area where the character is currently in. */
    private final Area area1 = new Area1();

    private final Area area2 = new Area2();

    private final Area area3 = new Area3();

    /** The scanner used to read user input. */
    private final Scanner scanner = new Scanner(System.in);

    /** The database of creatures. */
    private final CreaturesDescription creaturesInfo = new CreaturesDescription();

    /**
     * Starts the game, guides the user through the character setup,
     * and allows exploration.
     */
    public void startGame() {
        boolean gameRunning = false;
        char choice = '\0';
        int choice2 = -1;

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
        creaturesInfo.generateEL1WithKey("A");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("B");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("C");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("D");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("E");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("F");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("G");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("H");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());
        creaturesInfo.generateEL1WithKey("I");
        System.out.println(creaturesInfo.getFamily()+ ": " + creaturesInfo.getCreatureDetails());

        while (choice == '\0' ) {
            System.out.print("Enter the Letter corresponding to your choice: ");
            try{
            choice = scanner.next().charAt(0);

            if (choice < 'A' || choice > 'I') {
                System.out.println("Wrong Input! Please enter a letter only from A-I");
                choice = '\0';
            } 
            else {
                creaturesInfo.generateEL1WithKey(String.valueOf(choice));
                Creature starterCreature = 
                new Creature(creaturesInfo.getName(), creaturesInfo.getType(), creaturesInfo.getFamily(), creaturesInfo.getLevel());
                character.getInventory().addCreature(starterCreature);
                character.getInventory().changeActiveCreature(starterCreature);
                System.out.println("\nYou chose " + starterCreature.getName() + " as your starter creature!");
                
                System.out.println("\nYou are now ready to explore the world of Pokemon!");
                gameRunning = true;
            }

        } catch (InputMismatchException e) {
            System.out.println("Wrong Input! Please enter a letter only from A-I");
            choice = '\0';
        }
    }

        while(gameRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore (Area 1)");
            System.out.println("2. Explore (Area 2)");
            System.out.println("3. Explore (Area 3)");
            System.out.println("4. Check inventory");
            System.out.println("5. Evolve Creatures");
            System.out.println("6. Quit");
            System.out.print("Enter the number corresponding to your choice: ");

            try{
                choice2 = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                switch (choice2) {
                    case 1:
                        area1.exploreArea(character, creaturesInfo, scanner);
                        break;
                    case 2:
                        area2.exploreArea(character, creaturesInfo, scanner);
                        break;
                    case 3:
                        area3.exploreArea(character, creaturesInfo, scanner);
                        break;
                    case 4:
                        character.getInventory().viewInventory(character, scanner, creaturesInfo);
                        break;
                    case 5:
                        gameRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input! Please enter a number between 1 and 6");
                scanner.nextLine();
            }
        }
        System.out.println("Thank you for playing!");
    }
}