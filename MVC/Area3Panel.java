import javax.swing.*;
import java.awt.*;

public class Area3Panel extends JPanel {
    private ImageIcon defaultAreaTileImage = new ImageIcon("grass.png");
    private ImageIcon creatureAreaTileImage = new ImageIcon("creature.png");

    private Area3 area3 = new Area3();

    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel creatureLabel;
    private JLabel coordinateLabel;
    private JButton upButton, downButton, leftButton, rightButton, exitButton;

    private int creatureRow = 0; // Row position of the creature
    private int creatureColumn = 0; // Column position of the creature

    private Creature chosenStarterCreature; 

    private final int gridSize = 4; // Size of the grid (4x4)
    private JPanel areaTilesPanel; // Reference to the area tiles panel

    public Area3Panel(JPanel cards) {
        this.cards = cards; // Initialize the cards field
        setLayout(new BorderLayout());
        cardLayout = new CardLayout();

        // Create creature label
        creatureLabel = new JLabel("No Creature Selected");
        creatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(creatureLabel, BorderLayout.NORTH);

        // Create coordinate label
        coordinateLabel = new JLabel("Position: 1, 1");
        coordinateLabel.setHorizontalAlignment(JLabel.RIGHT);
        coordinateLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        add(coordinateLabel, BorderLayout.NORTH);

        // Create area tiles
        areaTilesPanel = createAreaTilesPanel();
        add(areaTilesPanel, BorderLayout.CENTER);

        // Create movement buttons
        upButton = new JButton("Up");
        downButton = new JButton("Down");
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");
        exitButton = new JButton("Exit");

        // Add action listeners to the buttons
        upButton.addActionListener(e -> moveCreatureUp());
        downButton.addActionListener(e -> moveCreatureDown());
        leftButton.addActionListener(e -> moveCreatureLeft());
        rightButton.addActionListener(e -> moveCreatureRight());
        exitButton.addActionListener(e -> exitExploration());

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        buttonPanel.add(upButton);
        buttonPanel.add(downButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createAreaTilesPanel() {
        JPanel areaTilesPanel = new JPanel(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize * gridSize; i++) {
            JButton areaTileButton = new JButton(defaultAreaTileImage);
            areaTilesPanel.add(areaTileButton);
        }
        return areaTilesPanel;
    }

    private void moveCreatureLeft() {
        if (creatureColumn > 0) {
            updateAreaTileImage(creatureRow, creatureColumn, defaultAreaTileImage);
            creatureColumn--;
            updateCreaturePosition();
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move left.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveCreatureRight() {
        if (creatureColumn < gridSize - 1) {
            updateAreaTileImage(creatureRow, creatureColumn, defaultAreaTileImage);
            creatureColumn++;
            updateCreaturePosition();
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move right.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveCreatureUp() {
        if (creatureRow > 0) {
            updateAreaTileImage(creatureRow, creatureColumn, defaultAreaTileImage);
            creatureRow--;
            updateCreaturePosition();
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move up.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveCreatureDown() {
        if (creatureRow < gridSize - 1) {
            updateAreaTileImage(creatureRow, creatureColumn, defaultAreaTileImage);
            creatureRow++;
            updateCreaturePosition();
            handleEncounter();
        } else {
            JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move down.", "Error", JOptionPane.ERROR_MESSAGE);
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
        BattlePhasePanel3 battlePhasePanel3 = new BattlePhasePanel3(chosenStarterCreature, area3);
    
        // Create a new frame for the battle phase
        JFrame battleFrame = new JFrame("Battle Phase");
        battleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        battleFrame.getContentPane().add(battlePhasePanel3);
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
        coordinateLabel.setText("Position: " + (creatureRow + 1) + ", " + (creatureColumn + 1));
        updateAreaTileImage(creatureRow, creatureColumn, creatureAreaTileImage);
    }

    private void updateAreaTileImage(int row, int column, ImageIcon image) {
        int position = row * gridSize + column;
        Component[] components = areaTilesPanel.getComponents();
        if (position >= 0 && position < components.length && components[position] instanceof JButton) {
            ((JButton) components[position]).setIcon(image);
        }
    }

    public void setChosenStarterCreature(Creature chosenStarterCreature) {
        creatureLabel.setText("Creature: " + chosenStarterCreature.getName());
        updateAreaTileImage(creatureRow,creatureColumn, creatureAreaTileImage);  // Update the initial area tile image
    }

private String getCreatureName() {
    return creatureLabel.getText().replace("Creature: ", "");
}
}