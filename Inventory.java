import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Represents an inventory containing a list of creatures and an active creature.
 */
public class Inventory {
    /** The list of creatures in the inventory. */
    private ArrayList<Creature> creatures = new ArrayList<Creature>();

    /** The index of the active creature in the inventory. */
    private int activeCreatureIndex = 0;  // By default, the first creature is active

    /**
     * Adds a creature to the inventory. If there's no active creature, the added creature
     * becomes the active creature.
     * 
     * @param creature The creature to add.
     */
    public void addCreature(Creature creature) {
        creatures.add(creature);
        if (activeCreatureIndex < 0) {  // If there's no active creature
            activeCreatureIndex = 0;   // Set the added creature as active
        }
    }

    /**
     * Returns the active creature in the inventory.
     * 
     * @return The active creature in the inventory.
     */
    public Creature getActiveCreature() {
        if (activeCreatureIndex >= 0 && activeCreatureIndex < creatures.size()) {
            return creatures.get(activeCreatureIndex);
        } else {
            return null;  // This should not happen if the class is used correctly
        }
    }

    /**
     * Changes the active creature.
     * 
     * @param creature The creature to set as active.
     */
    public void changeActiveCreature(Creature creature) {
        int index = creatures.indexOf(creature);
        if (index != -1) {
            activeCreatureIndex = index;
        }
    }

    public void removeCreature(Creature creature) {
        if (creatures.contains(creature)) {
            creatures.remove(creature);
            // If we removed the active creature, set the first creature in the list as active
            if (creatures.size() > 0 && creature == getActiveCreature()) {
                activeCreatureIndex = 0;
            } else if (creatures.size() == 0) {
                activeCreatureIndex = -1;
            }
        }
    }

    /**
     * Returns the list of creatures in the inventory.
     * 
     * @return The list of creatures in the inventory.
     */
    public ArrayList<Creature> getCreatures() {
        ArrayList<Creature> sortedCreatures = new ArrayList<>(creatures);
        Collections.sort(sortedCreatures, new Comparator<Creature>() {
            public int compare(Creature c1, Creature c2) {
                int nameComparison = c1.getName().compareTo(c2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                } else {
                    return Integer.compare(c1.getEvolutionLevel(), c2.getEvolutionLevel());
                }
            }
        });
        return sortedCreatures;
    } 

    /**
     * Allows the character to view their inventory and change their active creature.
     */
    public void viewInventory(Character character, Scanner scanner, CreaturesDescription creaturesInfo) {
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
            System.out.println("2. Evolve creatures");
            System.out.println("3. Go back to main menu");
            System.out.print("Enter the number corresponding to your choice: ");
            int submenuChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
    
            switch (submenuChoice) {
                case 1:
                    changeActiveCreature(character, scanner);
                    break;
                case 2:
                    evolveCreatures(character, scanner, creaturesInfo);
                    break;
                case 3:
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
    public void changeActiveCreature(Character character, Scanner scanner) {
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

    public void evolveCreatures(Character character, Scanner scanner, CreaturesDescription creaturesInfo) {
        System.out.println("\nChoose TWO creatures from your inventory to evolve: ");

        int currentIndex = 1;
        for (Creature creature : this.getCreatures()) {
            System.out.println(currentIndex + ". Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: " + creature.getEvolutionLevel());
            currentIndex++;
        }
            System.out.print("\nSelect the FIRST creature (by number): ");
            int firstChoice = scanner.nextInt();
            System.out.print("\nSelect the SECCOND creature (by number): ");
            int secondChoice = scanner.nextInt();

            Creature creature1 = this.getCreatures().get(firstChoice - 1);
            Creature creature2 = this.getCreatures().get(secondChoice - 1);

            // Check if the creatures are eligible for evolution
            if (creature1.getFamily().equals(creature2.getFamily()) && 
                creature1.getEvolutionLevel() == creature2.getEvolutionLevel() &&
                creature1.getEvolutionLevel() < 3) {
                    // Evolve the creatures
                    Creature evolvedCreature = Creature.getEvolvedCreatureUsingMap(creature1);
                    if (evolvedCreature != null) {
                        // Remove the old creatures from the inventory
                    this.removeCreature(creature1);
                    this.removeCreature(creature2);
                    this.addCreature(evolvedCreature);
                    System.out.println("\nCongatulations! Your creatures have evolved into " + evolvedCreature.getName() + "!");
                    } else {
                        System.out.println("\nEvolution not possible for this creature.");
                    }
                } else {
                    System.out.println("\nYour creatures are not eligible for evolution.");
                }
    }
}
