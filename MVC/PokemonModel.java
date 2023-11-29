/**
 * The {@code PokemonModel} class represents the model of the application.
 * It contains the player's name and the selected starter creature.
 */
public class PokemonModel {
    private String playerName;
    private Creature selectedStarterCreatureObject;
    private Inventory inventory;

    /**
     * Sets the player's name.
     * 
     * @param playerName The player's name.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Sets the selected starter creature.
     * 
     * @param creature The selected starter creature.
     */
    public void setSelectedStarterCreatureObject(Creature creature) {
        this.selectedStarterCreatureObject = creature;
        addToInventory(creature);
    }

    private void addToInventory(Creature creature) {
        if (inventory == null) {
            inventory = new Inventory();
        }
        inventory.addCapturedCreature(creature);
    }

    /**
     * Returns the player's name.
     * 
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the selected starter creature.
     * 
     * @return The selected starter creature.
     */
    public Creature getselectedStarterCreatureObject() {
        return selectedStarterCreatureObject;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void swapActiveCreature(Creature newActiveCreature) {
        if (inventory != null) {
            inventory.changeActiveCreature(newActiveCreature);
        }
    }
}
