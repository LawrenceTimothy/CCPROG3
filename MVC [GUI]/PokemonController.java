import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String creature = model.getSelectedStarterCreature();
                selectedStarterCreature(creature);
            }
        });
    }

    public void getPlayerName() {
        String playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName != null) {
            model.setPlayerName(playerName);
            view.updateMainMenuLabel();
        }
    }

    public void selectedStarterCreature(String creature) {
        model.setSelectedStarterCreature(creature);
        view.updateMainMenuLabel();
    }

    public void exploreArea1() {
        // Add logic for exploring Area 1
        JOptionPane.showMessageDialog(null, "Area 1  <-- under construction");
    }

    public void exploreArea2() {
        // Add logic for exploring Area 2
        JOptionPane.showMessageDialog(null, "Area 2  <-- under construction");
    }

    public void exploreArea3() {
        // Add logic for exploring Area 3
        JOptionPane.showMessageDialog(null, "Area 3  <-- under construction");
    }

    public void viewInventory() {
        // Add logic for viewing inventory
        JOptionPane.showMessageDialog(null, "Viewing Inventory  <-- under construction");
    }

    public void evolveCreature() {
        // Add logic for evolving creature
        JOptionPane.showMessageDialog(null, "Evolve Creature  <-- under construction");
    }

    public void exitGame() {
        System.exit(0);
    }
}
