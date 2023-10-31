import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
            System.out.println("2. Explore (Area 2)");
            System.out.println("3. Explore (Area 3)");
            System.out.println("4. Check inventory");
            System.out.println("5. Evolve Creatures");
            System.out.println("6. Quit");
            System.out.print("Enter the number corresponding to your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exploreArea(area1);
                    break;
                case 2:
                    exploreArea(area2);
                    break;
                case 3:
                    exploreArea(area3);
                    break;
                case 4:
                    viewInventory();
                    break;
                case 5:
                    evolveCreatures();
                    break;
                case 6:
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
    private void exploreArea(Area area) {
        boolean exploring = true;
        
        while (exploring) {

            System.out.println("\nYou are now exploring Area " + area.getClass().getSimpleName());
            System.out.println("\nYou are at position " + area.getCurrentPosition());
            System.out.println("\n        (1)UP  \n(2)LEFT        (3)RIGHT\n        (4)DOWN\n\nType '0' to go back to menu.");
            System.out.print("\nEnter the number corresponding to your choice: ");
            int direction = scanner.nextInt();
            scanner.nextLine();

            if (direction == 0) {
                exploring = false;
            } else {
                boolean moved = area.move(direction);
                if (moved) {
                    System.out.println("You moved to position " + area.getCurrentPosition());

                    // 40% chance to encounter a creature
                    if (Math.random() < 0.4) {
                        ArrayList<Creature> potentialCreatures = new ArrayList<>();
                        int maxEvolutionLevel = area.getMaxCreatures();

                        if (maxEvolutionLevel >= 1) {
                            potentialCreatures.addAll(creatureDatabase.EL1_CREATURES);
                        }
                        if (maxEvolutionLevel >= 2) {
                            potentialCreatures.addAll(creatureDatabase.EL2_CREATURES);
                        }
                        if (maxEvolutionLevel >= 3) {
                            potentialCreatures.addAll(creatureDatabase.EL3_CREATURES);
                        }

                        Creature encounteredCreature = potentialCreatures.get((int) (Math.random() * potentialCreatures.size()));
                        System.out.println("\nYou encountered a wild " + encounteredCreature.getName() + " | TYPE: "+ encounteredCreature.getType() + " | Evolution Level: " + encounteredCreature.getEvolutionLevel() + " | ");
                        BattlePhase battlePhase = new BattlePhase(encounteredCreature, character);
                        battlePhase.start();
                        }
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


    private Creature getEvolvedCreatureUsingMap (Creature currentCreature) {
        String evolvedCreatureName = EVOLUTION_MAP.get(getEvolutionKey(currentCreature));
        return new Creature(evolvedCreatureName, currentCreature.getType(), currentCreature.getFamily(), currentCreature.getEvolutionLevel() + 1);
    }

    private String getEvolutionKey (Creature creature) {
        return creature.getType() + "_" + creature.getFamily() + "_" + creature.getEvolutionLevel();
    }

    private static final Map<String, String> EVOLUTION_MAP;
    static {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put ("FIRE_A_1", "Strawleon");
        tempMap.put ("FIRE_A_2", "Strawizard");
        tempMap.put ("FIRE_B_1", "Chocofluff");
        tempMap.put ("FIRE_B_2", "Candaros");
        tempMap.put ("FIRE_C_1", "Parfure");
        tempMap.put ("FIRE_C_2", "Parfelure");
        tempMap.put ("GRASS_D_1", "Chocosaur");
        tempMap.put ("GRASS_D_2", "Fudgasaurs");
        tempMap.put ("GRASS_E_1", "Golberry");
        tempMap.put ("GRASS_E_2", "Croberry");
        tempMap.put ("GRASS_F_1", "Kirlcake");
        tempMap.put ("GRASS_F_2", "Velvevoir");
        tempMap.put ("WATER_G_1", "Tartortle");
        tempMap.put ("WATER_G_2", "Piestoise");
        tempMap.put ("WATER_H_1", "Chocolish");
        tempMap.put ("WATER_H_2", "Icesundae");
        tempMap.put ("WATER_I_1", "Dewice");
        tempMap.put ("WATER_I_2", "Samurcone");

        EVOLUTION_MAP = Collections.unmodifiableMap(tempMap);
    }

    private void evolveCreatures() {
        System.out.println("\nChoose TWO creatures from your inventory to evolve: ");

        int currentIndex = 1;
        for (Creature creature : character.getInventory() .getCreatures()) {
            System.out.println(currentIndex + ". Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: " + creature.getEvolutionLevel());
            currentIndex++;
        }
            System.out.print("\nSelect the FIRST creature (by number): ");
            int firstChoice = scanner.nextInt();
            System.out.print("\nSelect the SECCOND creature (by number): ");
            int secondChoice = scanner.nextInt();

            Creature creature1 = character.getInventory().getCreatures().get(firstChoice - 1);
            Creature creature2 = character.getInventory().getCreatures().get(secondChoice - 1);

            // Check if the creatures are eligible for evolution
            if (creature1.getFamily().equals(creature2.getFamily()) && 
                creature1.getEvolutionLevel() == creature2.getEvolutionLevel() &&
                creature1.getEvolutionLevel() < 3) {
                    // Evolve the creatures
                    Creature evolvedCreature = getEvolvedCreatureUsingMap(creature1);

                    // Remove the old creatures from the inventory
                    character.getInventory().removeCreature(creature1);
                    character.getInventory().removeCreature(creature2);
                    character.getInventory().addCreature(evolvedCreature);

                    System.out.println("\nCongatulations! Your creatures have evolved into " + evolvedCreature.getName() + "!");
                } else {
                    System.out.println("\nYour creatures are not eligible for evolution.");
                }
    }
}