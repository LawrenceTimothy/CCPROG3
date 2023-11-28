import javax.swing.*;
import java.awt.*;

public class Area1Panel extends JPanel {
    private ImageIcon defaultAreaTileImage = new ImageIcon("grass.png");
    private ImageIcon creatureAreaTileImage = new ImageIcon("creature.png");

    private Area1 area1 = new Area1();

    private Creature chosenStarterCreature;  // Add this field

    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel creatureLabel;
    private JLabel coordinateLabel;
    private JButton leftButton;
    private JButton rightButton;
    private JButton exitButton;

    private int creaturePosition = 0; // Initial position

    private JPanel areaTilesPanel;  // Reference to the area tiles panel
    
    public Area1Panel(JPanel cards) {
        this.cards = cards; // Initialize the cards field
        setLayout(new BorderLayout());
        cardLayout = new CardLayout();

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
        exitButton = new JButton("Exit");
        
        leftButton.addActionListener(e -> moveCreatureLeft());
        rightButton.addActionListener(e -> moveCreatureRight());
        exitButton.addActionListener(e -> exitExploration());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        buttonPanel.add(exitButton);

        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(exitButton, BorderLayout.SOUTH);
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
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move left.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveCreatureRight() {
        updateAreaTileImage(creaturePosition, defaultAreaTileImage);
        if (creaturePosition < 4) {
            creaturePosition++;
            updateCreaturePosition();
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move right.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exitExploration() {
        if (cards.getLayout() instanceof CardLayout) {
            ((CardLayout) cards.getLayout()).show(cards, "Exploration");
        } else {
            System.err.println("Unexpected layout type for cards panel.");
        }
    }

    private void handleEncounter() {
        // 40% chance of encountering a creature
        if (Math.random() < 0.4) {
            showBattlePhasePanel();
        }
    }

    private void showBattlePhasePanel() {
        // Assuming area1 is an instance of Area1
        BattlePhasePanel1 battlePhasePanel1 = new BattlePhasePanel1(chosenStarterCreature, area1);
    
        // Create a new frame for the battle phase
        JFrame battleFrame = new JFrame("Battle Phase");
        battleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        battleFrame.getContentPane().add(battlePhasePanel1);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setVisible(true);
    
        // Dispose of the current frame (assuming this method is in a JPanel or JFrame)
        Window currentWindow = SwingUtilities.windowForComponent(this);
        if (currentWindow instanceof JFrame) {
            ((JFrame) currentWindow).dispose();
        } else if (currentWindow instanceof JDialog) {
            ((JDialog) currentWindow).dispose();
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

    public void setChosenStarterCreature(Creature chosenStarterCreature) {
        creatureLabel.setText("Creature: " + chosenStarterCreature.getName());
        updateAreaTileImage(creaturePosition, creatureAreaTileImage);  // Update the initial area tile image
    }

    private String getCreatureName() {
        return creatureLabel.getText().replace("Creature: ", "");
    }
}
