import java.util.Random; 
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Represents a battle phase between the player and an enemy creature in a game.
 * This class manages the battle mechanics, including attack, swap, catch, and run away.
 */
public class BattlePhase {
    private final Creature enemy;
    private final Character player;
    private int enemyHealth;
    private int actionsLeft;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    /**
     * Creates a new battle phase with the given enemy creature and player.
     * 
     * @param enemy The enemy creature.
     * @param player The player.
     */
    public BattlePhase(Creature enemy, Character player) {
        this.enemy = enemy;
        this.player = player;
        this.enemyHealth = 50;
        this.actionsLeft = 3;
    }

    /**
     * Starts the battle phase.
     */
    public void start() {
        while (actionsLeft > 0 && enemyHealth > 0) {
            System.out.println("You have " + actionsLeft + " actions left.");
            System.out.println("\nChoose your action: [1] ATTACK, [2] SWAP, [3] CATCH, [4] RUN");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.actionsLeft--;
                    attack();
                    break;
                case 2:
                    this.actionsLeft--;
                    swap();
                    break;
                case 3:
                    this.actionsLeft--;
                    catchCreature();
                    if (actionsLeft == 0) return;
                    break;
                case 4:
                    this.actionsLeft = 0;
                    runAway();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        if (actionsLeft == 0) {
            System.out.println("\nYou have no actions left.");
        }
    }

/**
 * Executes the attack action during the battle.
 */
    private void attack() {
        int damage = random.nextInt(10) + 1; //RAND(1,10)
        damage *= player.getInventory().getActiveCreature().getEvolutionLevel(); //AC_EL

        //Type advantage
        String playerType = player.getInventory().getActiveCreature().getType();
        String enemyType = enemy.getType();
        if ((playerType.equals("FIRE") && enemyType.equals("GRASS")) ||
            (playerType.equals("GRASS") && enemyType.equals("WATER")) ||
            (playerType.equals("WATER") && enemyType.equals("FIRE"))) {
            damage *= 1.5;
        }
        enemyHealth -= damage;
        if (enemyHealth < 0) {
            enemyHealth = 0;
            JOptionPane.showMessageDialog(null, "You dealt " + damage + "damage! The enemy has been defeated!");
            JOptionPane.showMessageDialog(null,"You will not give this enemy since its health reached 0.");
            actionsLeft = 0;
        } else {
            JOptionPane.showMessageDialog(null,"\nYou dealt " + damage + " damage! The enemy's health is now " + enemyHealth + ".");
        }
        
    }

/**
 * Allows the player to swap their active creature.
 */
    private void swap() {
        if (player.getInventory().getCreatures().size() > 1) {
            System.out.println("\nChoose a creature to swap with: ");

            int currentIndex = 1;
            int active = 0;
            Creature activeCreature = player.getInventory().getActiveCreature();
            for (Creature creature : player.getInventory().getCreatures()) {
                String activeIndicator = "";
                if (creature == activeCreature && active != 1) {
                    activeIndicator = " (Active)";
                    active = 1;
                }
                System.out.println(currentIndex + ". Name: " + creature.getName() + ", Type: " + creature.getType() + ", Family: " + creature.getFamily() + ", Evolution Level: "+ creature.getEvolutionLevel() + activeIndicator);
                currentIndex++;
                activeIndicator = "";
            }

            boolean validChoice = false;
            while (!validChoice) {
                System.out.print("Enter your choice: ");
                int selectedCreatureIndex = scanner.nextInt();
                scanner.nextLine();

                if (selectedCreatureIndex > 0 && selectedCreatureIndex <= player.getInventory().getCreatures().size()) {
                    Creature selectedCreature = player.getInventory().getCreatures().get(selectedCreatureIndex - 1);
                    if (!selectedCreature.equals(player.getInventory().getActiveCreature())) {
                        player.getInventory().changeActiveCreature(selectedCreature);
                        System.out.println("\nYou have swapped your active creature to " + selectedCreature.getName() + ".");
                        validChoice = true;
                    } else {
                        System.out.println("\nYou cannot swap to the currently active creature. PLease Choose another.");
                    }
                } else {
                    System.out.println("\nInvalid number choice.");
                }
            }
        } else {
            System.out.println("\nYou only have one creature. You cannot swap.");
        }
    }

/**
 * Executes the catch action during the battle.
 */
    private void catchCreature() {
        int catchRate = 40 + 50 - enemyHealth; //(40 + 50 - EN_HP)%
        if (random.nextInt(100) < catchRate) {
            System.out.println("\nYou have successfully caught the " + enemy.getName() + "!");
            player.getInventory().addCreature(enemy);
            actionsLeft = 0;
        } else {
            System.out.println("\nCatch Failed!");
        }
    }

/**
 * Executes the run away action during the battle.
 */
    private void runAway() {
        System.out.println("You ran away from the battle.");
    }

    /**
     * Performs the attack action.
     */
    public void performAttack() {
        attack();
    }

    /**
     * Performs the swap action.
     */
    public void performSwap() {
        swap();
    }

    /**
     * Performs the catch action.
     */
    public void performCatchCreature() {
        catchCreature();
    }

    /**
     * Performs the run away action.
     */
    public void performRunAway() {
        runAway();
    }
}