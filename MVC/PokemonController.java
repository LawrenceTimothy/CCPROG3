import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The {@code PokemonController} class is a controller that handles the user's input and updates the model and view.
 * It handles user interactions from the  {@code PokemonView} class and updates the {@code PokemonModel} class.
 */
public class PokemonController {
    private PokemonModel model;
    private PokemonView view;

    /**
     * Constructs a {@code PokemonController} with a reference to the model and view.
     * 
     * @param model The model of the application.
     * @param view The view of the application.
     */
    public PokemonController(PokemonModel model, PokemonView view) {
        this.model = model;
        this.view = view;


        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPlayerName();
            }
        });

        view.getStarterSelectionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Creature creature = model.getselectedStarterCreatureObject();
                selectedStarterCreature(creature);
            }
        });
    }

    /**
     * Gets the player's name from the user.
     */
    public void getPlayerName() {
        String playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName != null) {
            model.setPlayerName(playerName);
            view.createStarterSelectionPanel();
        }
    }

    /**
     * Sets the selected starter creature.
     * 
     * @param creature The selected starter creature.
     */
    public void selectedStarterCreature(Creature creature) {
        model.setSelectedStarterCreatureObject(creature);
        view.updateMainMenuLabel();
    }

    /**
     * Exits the game.
     */
    public void exitGame() {
        System.exit(0);
    }
}
