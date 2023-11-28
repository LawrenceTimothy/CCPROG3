import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PokemonController {
    private PokemonModel model;
    private PokemonView view;


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

    public void getPlayerName() {
        String playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName != null) {
            model.setPlayerName(playerName);
            view.createStarterSelectionPanel();
        }
    }

    public void selectedStarterCreature(Creature creature) {
        model.setSelectedStarterCreatureObject(creature);
        view.updateMainMenuLabel();
    }

    public void exitGame() {
        System.exit(0);
    }
}
