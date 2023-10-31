/**
This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts learned. I
have constructed the functions and their respective algorithms and corresponding code by myself. The program was run, tested,
and debugged by my own efforts. I further certify that I have not copied in part or whole or otherwise plagiarized the work of other
students and/or persons.
<Lawrence Timothy P. Codorniz> and <Sophia Orencia>
**/

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