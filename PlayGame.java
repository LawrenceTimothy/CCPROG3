import java.util.Scanner;

public class PlayGame {
    private final Character character = new Character();
    private final Area area1 = new Area(5, 1);
    private final Scanner scanner = new Scanner(System.in);
    private final CreatureDatabase creatureDatabase = new CreatureDatabase();

    public void startGame() {
        int creatureIndex = 1;
        int choice = -1;

        System.out.println("Welcome to Pokémon version 2.0!");
        System.out.println("Choose your starter creature:");

        for (Creature creature : creatureDatabase.EL1_CREATURES) {
            System.out.println(creatureIndex + ". " + creature.getName() + "(Type: " + creature.getType() + ")");
            creatureIndex++;
        }

        while (choice < 1 || choice > creatureDatabase.EL1_CREATURES.size()) {
            System.out.println("Enter the number corresponding to your choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > creatureDatabase.EL1_CREATURES.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        Creature starterCreature = creatureDatabase.EL1_CREATURES.get(choice - 1);
        character.getInventory().addCreature(starterCreature);
        character.getInventory().changeActiveCreature(starterCreature);
        System.out.println("You chose " + starterCreature.getName() + " as your starter creature!");

        boolean gameRunning = true;

        while(gameRunning) {
            System.out.println("What would you like to do?");
            System.out.println("1. Explore (Area 1)");
            System.out.println("2. Check inventory");
            System.out.println("3. Quit");

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

    private void exploreArea1() {
        boolean exploring = true;
        
        while (exploring) {
            System.out.println("You are now exploring Area 1.");
            System.out.println("\n        (1)UP  \n(2)LEFT        (3)RIGHT\n        (4)DOWN\nType '0' to go back to menu.");
            int direction = scanner.nextInt();
            scanner.nextLine();

            if (direction == 0) {
                exploring = false;
            } else if (area1.move(direction)) {
                System.out.println("You moved to position" + area1.getCurrentPosition());

                // 40% chance of encountering a creature
                if (Math.random() < 0.4) {
                    Creature encounteredCreature = creatureDatabase.EL1_CREATURES.get((int) (Math.random() * creatureDatabase.EL1_CREATURES.size()));
                    System.out.println("You have encountered: " + encounteredCreature.getName() + " of type " + encounteredCreature.getType());
                    System.out.println("Would you like to add it to your inventory? (Y/N)");
                    String encChoice = scanner.nextLine();

                    if (encChoice.equalsIgnoreCase("Y")) {
                        character.getInventory().addCreature(encounteredCreature);
                        System.out.println(encounteredCreature.getName() + " has been added to your inventory!");
                    } else {
                        System.out.println("You chose not to add " + encounteredCreature.getName() + " to your inventory.");
                    }
                }
            }
        }
    }


    private void viewInventory() {
        System.out.println("Your inventory contains: ");

        for (Creature creature : character.getInventory().getCreatures()) {
            System.out.println("Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: " + creature.getEvolutionLevel());
        }
        System.out.println("Active creature: " + character.getInventory().getActiveCreature().getName());
        System.out.println("Would you like to change your active creature? (Y/N)");
        String changeChoice = scanner.nextLine();

        if (changeChoice.equalsIgnoreCase("Y")) {
            System.out.println("Enter the name of the creature you want to set as active: ");
            String newActiveCreatureName = scanner.nextLine();
            
            Creature newActiveCreature = null;
            for (Creature creature : character.getInventory().getCreatures()) {
                if (creature.getName().equalsIgnoreCase(newActiveCreatureName)) {
                    newActiveCreature = creature;
                    break;
                }
            }
            if (newActiveCreature != null) {
                character.getInventory().changeActiveCreature(newActiveCreature);
                System.out.println("Your active creature has been changed to " + newActiveCreature.getName());
            } else {
                System.out.println("No creature with the name " + newActiveCreatureName + " was found in your inventory.");
            }
        }
    }
}
