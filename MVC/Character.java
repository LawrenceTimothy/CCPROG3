/**
 * Reperesents a character in the game with a name and an inventory of creatures.
 */
public class Character {
    /** The name of the character. */
    String name;

    /** The inventory of the character. */
    private Inventory inventory;

    /**
     * Creates a new character with the given name.
     * 
     * @param name The name of the character.
     */
    public Character(String name) {
        this.name = name;
        inventory = new Inventory();
    }

    /**
     * Returns the name of the character.
     * 
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the inventory of the character.
     * 
     * @return The inventory of the character.
     */
    public Inventory getInventory() {
        return inventory;
    }
}