import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Area1Panel extends JPanel {
    private ImageIcon defaultAreaTileImage = new ImageIcon("grass.png");
    private ImageIcon creatureAreaTileImage = new ImageIcon("creature.png");

    private Area1 area1 = new Area1();

    private JLabel creatureLabel;
    private JLabel coordinateLabel;
    private JButton leftButton;
    private JButton rightButton;

    private int creaturePosition = 0; // Initial position

    private JPanel areaTilesPanel;  // Reference to the area tiles panel
    
    public Area1Panel() {
        setLayout(new BorderLayout());

        // Create creature label
        creatureLabel = new JLabel("No Creature Selected");
        creatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(creatureLabel,BorderLayout.NORTH);

        // Create coordinate label
        coordinateLabel = new JLabel("Position: 1, 1");
        coordinateLabel.setHorizontalAlignment(JLabel.RIGHT);
        coordinateLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        add(coordinateLabel,BorderLayout.NORTH);  // Place the coordinate label in the NORTH position


        // Create area tiles
        areaTilesPanel = createAreaTilesPanel();
        add(areaTilesPanel,BorderLayout.CENTER);

        // Create left and right buttons
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");

        leftButton.addActionListener(e -> moveCreatureLeft());
        rightButton.addActionListener(e -> moveCreatureRight());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        add(buttonPanel,BorderLayout.SOUTH);
    }

    private JPanel createAreaTilesPanel() {
        JPanel areaTilesPanel = new JPanel(new GridLayout(1, 5));
        for (int i = 0; i < 5; i++) {
            JButton areaTileButton = new JButton(defaultAreaTileImage);
            areaTilesPanel.add(areaTileButton);
        }
        return areaTilesPanel;
    }

    private void moveCreatureLeft() {
        updateAreaTileImage(creaturePosition, defaultAreaTileImage);
        if (creaturePosition > 0) {
            creaturePosition--;
            updateCreaturePosition();
            if (Math.random() < 0.4) {
                BattlePhasePanel battlePhasePanel = new BattlePhasePanel("PlayerActiveCreature","EnemyCreature",area1);
                battlePhasePanel.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move left.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveCreatureRight() {
        updateAreaTileImage(creaturePosition, defaultAreaTileImage);
        if (creaturePosition < 4) {
            creaturePosition++;
            updateCreaturePosition();
            if (Math.random() < 0.4) {
                BattlePhasePanel battlePhasePanel = new BattlePhasePanel("PlayerActiveCreature","EnemyCreature",area1);
                battlePhasePanel.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move right.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCreaturePosition() {
        creatureLabel.setText("Creature: " + getCreatureName());
        coordinateLabel.setText("Position: " + "1, " + (creaturePosition + 1));
        updateAreaTileImage(creaturePosition, creatureAreaTileImage);  // Update the current area tile image
        updateAreaTileImage(creaturePosition - 1, defaultAreaTileImage);  // Revert the image of the previous area tile
    }

    private void updateAreaTileImage(int position, ImageIcon image) {
        Component[] components = areaTilesPanel.getComponents();
        if (position >= 0 && position < components.length && components[position] instanceof JButton) {
            ((JButton) components[position]).setIcon(image);
        }
    }

    public void setChosenStarterCreature(String chosenStarterCreature) {
        creatureLabel.setText("Creature: " + chosenStarterCreature);
        updateAreaTileImage(creaturePosition, creatureAreaTileImage);  // Update the initial area tile image
    }

    private String getCreatureName() {
        return creatureLabel.getText().replace("Creature: ", "");
    } 
}
