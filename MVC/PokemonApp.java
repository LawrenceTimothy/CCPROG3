/**
 * The {@code PokemonApp} class represents the main class of the application.
 * It creates the model, view, and controller objects and sets up the initial view.
 */
public class PokemonApp {
    /**
     * The main method of the application.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
            PokemonModel model = new PokemonModel();
            PokemonView view = new PokemonView(model);
            PokemonController controller = new PokemonController(model, view);

            view.setController(controller);

            // Set up the initial view
            view.createWelcomePanel();
    }
}
