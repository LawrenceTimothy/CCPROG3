import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattlePhasePanel2 extends JPanel {
    private JPanel cards;
    private CardLayout cardLayout;
    private Creature playerActiveCreature;
    private CreaturesDescription enemyDescription;
    private BattlePhase battlePhase;
    private JProgressBar healthProgressBar;

    public BattlePhasePanel2(Creature playerActiveCreature, Area2 area2) {
        this.playerActiveCreature = playerActiveCreature;
        this.enemyDescription = new CreaturesDescription();
        setLayout(new BorderLayout());
        setSize(800, 600);
        
        // Initialize battle phase instance
        Character player = new Character("Player");
        Creature enemy = new Creature(enemyDescription.getName(), enemyDescription.getType(), enemyDescription.getFamily(), enemyDescription.getLevel());
        this.battlePhase = new BattlePhase(enemy, player);

        // Display enemy creature information
        JPanel enemyInfoPanel = createEnemyInfoPanel(area2);
        add(enemyInfoPanel, BorderLayout.CENTER);

        // Active creature information
        JPanel activeCreaturePanel = createActiveCreaturePanel();
        add(activeCreaturePanel, BorderLayout.WEST);

        // Action buttons
        JPanel actionPanel = createActionPanel();
        add(actionPanel, BorderLayout.SOUTH);
    }

    private JPanel createEnemyInfoPanel(Area2 area2) {
        JPanel enemyInfoPanel = new JPanel(new GridLayout(3, 3));

        // Randomize a key from A to I
        char randomKey = (char) ('A' + Math.random() * 9);
        String key = String.valueOf(randomKey);

        // Determine the evolution level and generate creature
        switch (area2.getMaxCreatures()) {
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

         // Add a JProgressBar for enemy health
         healthProgressBar = new JProgressBar(0, 50);
         healthProgressBar.setValue(50);  // Set the initial health value
         healthProgressBar.setStringPainted(true);  // Display the health value
         JLabel healthLabel = new JLabel("Health:");
         healthLabel.setLabelFor(healthProgressBar);
 
         enemyInfoPanel.add(nameLabel);
         enemyInfoPanel.add(evolutionLabel);
         enemyInfoPanel.add(typeLabel);
         enemyInfoPanel.add(familyLabel);
         enemyInfoPanel.add(healthLabel);
         enemyInfoPanel.add(healthProgressBar);
 
         return enemyInfoPanel;
    }

    private JPanel createActiveCreaturePanel() {
        JPanel activeCreaturePanel = new JPanel(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Name: " + playerActiveCreature);
        activeCreaturePanel.add(nameLabel);
        return activeCreaturePanel;
    }

    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(4, 1));

        JButton attackButton = new JButton("Attack");
        JButton swapButton = new JButton("Swap Creature");
        JButton catchButton = new JButton("Catch");
        JButton runButton = new JButton("Run");

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battlePhase.performAttack();
                JOptionPane.showMessageDialog(null, "attack");
            }
        });

        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battlePhase.performSwap();
                JOptionPane.showMessageDialog(null, "swap");
            }
        });

        catchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battlePhase.performCatchCreature();
                JOptionPane.showMessageDialog(null, "caught");
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battlePhase.performRunAway();
                JOptionPane.showMessageDialog(null, "ran");
                if (cards.getLayout() instanceof CardLayout) {
                    ((CardLayout) cards.getLayout()).show(cards, "Area 2 Exploration");
                } else {
                    System.err.println("Unexpected layout type for cards panel.");
                }
            }
        });

        actionPanel.add(attackButton);
        actionPanel.add(swapButton);
        actionPanel.add(catchButton);
        actionPanel.add(runButton);

        return actionPanel;
    }
}
