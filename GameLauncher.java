/**
 * The entry point for the Pokemon version 2.0 game.
 */
public class GameLauncher {
    /**
     * Main method that launches the game.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        PlayGame gameManager = new PlayGame();
        gameManager.startGame();
    }
}