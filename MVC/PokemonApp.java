public class PokemonApp {
    public static void main(String[] args) {
            PokemonModel model = new PokemonModel();
            PokemonView view = new PokemonView(model);
            PokemonController controller = new PokemonController(model, view);

            view.setController(controller);

            // Set up the initial view
            view.createWelcomePanel();
    }
}
