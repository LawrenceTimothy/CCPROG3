public class Character {
    String name;
    private Inventory inventory;

    public Character(String name) {
        this.name = name;
        inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
