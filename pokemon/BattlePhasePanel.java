import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattlePhasePanel extends JPanel {
    private String playerActiveCreature;
    private String enemyCreature;
    private CreaturesDescription enemyDescription;
    public BattlePhasePanel(String playerActiveCreature, String enemyCreature, Area1 area1) {
        this.playerActiveCreature = playerActiveCreature;
        this.enemyCreature = enemyCreature;
        this.enemyDescription = new CreaturesDescription();
        setLayout(new BorderLayout());

        // Display enemy creature information
        JPanel enemyInfoPanel = createEnemyInfoPanel(area1);
        add(enemyInfoPanel, BorderLayout.CENTER);

        // Action buttons
        JPanel actionPanel = createActionPanel();
        add(actionPanel, BorderLayout.SOUTH);
    }

    private JPanel createEnemyInfoPanel(Area1 area1) {
        JPanel enemyInfoPanel = new JPanel(new GridLayout(5, 1));

        // Randomize a key from A to I
        char randomKey = (char) ('A' + Math.random() * 9);
        String key = String.valueOf(randomKey);

        // Determine the evolution level and generate creature
        switch (area1.getMaxCreatures()) {
            case 1:
                enemyDescription.generateEL1WithKey(key);
                break;
            case 2:
                enemyDescription.generateEL2WithKey(key);
                break;
            case 3:
                // Randomize the evolution level from 1 to 3
                int randomLevel = 1 + (int) (Math.random() * 3);
                switch (randomLevel) {
                    case 1:
                        enemyDescription.generateEL1WithKey(key);
                        break;
                    case 2:
                        enemyDescription.generateEL2WithKey(key);
                        break;
                    case 3:
                        enemyDescription.generateEL3WithKey(key);
                        break;
                }
                break;
        }

        Creature encounteredCreature = new Creature(enemyDescription.getName(), enemyDescription.getType(), enemyDescription.getFamily(), enemyDescription.getLevel());

        JLabel nameLabel = new JLabel("Name: " + enemyDescription.getName());
        JLabel evolutionLabel = new JLabel("Evolution Level: " + enemyDescription.getLevel());
        JLabel typeLabel = new JLabel("Type: " + encounteredCreature.getType());
        JLabel familyLabel = new JLabel("Family: " + enemyDescription.getFamily());

        enemyInfoPanel.add(nameLabel);
        enemyInfoPanel.add(evolutionLabel);
        enemyInfoPanel.add(typeLabel);
        enemyInfoPanel.add(familyLabel);

        return enemyInfoPanel;
    }

    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(1, 4));

        JButton attackButton = new JButton("Attack");
        JButton swapButton = new JButton("Swap Creature");
        JButton catchButton = new JButton("Catch");
        JButton runButton = new JButton("Run");

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for attack
                JOptionPane.showMessageDialog(null, "You attacked the enemy!");
            }
        });

        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for swapping active creature
                JOptionPane.showMessageDialog(null, "You swapped the active creature.");
            }
        });

        catchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for catching the enemy creature
                JOptionPane.showMessageDialog(null, "You caught the enemy creature!");
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for running from the battle
                JOptionPane.showMessageDialog(null, "You ran from the battle!");
            }
        });

        actionPanel.add(attackButton);
        actionPanel.add(swapButton);
        actionPanel.add(catchButton);
        actionPanel.add(runButton);

        return actionPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Example usage in a standalone frame
            JFrame frame = new JFrame("Battle Phase");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new BattlePhasePanel("Charmander", "Pikachu", new Area1()));
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
