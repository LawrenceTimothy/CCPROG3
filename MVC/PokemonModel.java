public class PokemonModel {
    private String playerName;
    private Creature selectedStarterCreatureObject;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSelectedStarterCreatureObject(Creature creature) {
        this.selectedStarterCreatureObject = creature;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Creature getselectedStarterCreatureObject() {
        return selectedStarterCreatureObject;
    }
    
}
