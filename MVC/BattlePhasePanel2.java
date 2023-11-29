import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;

public class BattlePhasePanel2 extends JPanel {
    private JPanel cards;
    private CardLayout cardLayout;
    private Creature playerActiveCreature;
    private CreaturesDescription enemyDescription;
    private JProgressBar healthProgressBar;
    private BattlePhase battlePhase;
    private int enemyHealth = 50;
    private int actionsLeft = 3; 
    private Random random = new Random();
    private JLabel resultLabel; 
    private Inventory inventory; 
    private PokemonModel model;

    private JLabel nameLabel;
    private JLabel evolutionLabel;
    private JLabel typeLabel;
    private JLabel familyLabel;

    public BattlePhasePanel2(Creature playerActiveCreature, Area2 area2, JPanel cards, CardLayout cardLayout, Inventory inventory, PokemonModel model) {
        this.playerActiveCreature = playerActiveCreature;
        this.enemyDescription = new CreaturesDescription();
        this.cards = cards; 
        this.cardLayout = cardLayout; 
        this.inventory = inventory;
        this.model = model; 
        setLayout(new GridBagLayout());

        Character player = new Character("Player");
        Creature enemy = new Creature(enemyDescription.getName(), enemyDescription.getType(), enemyDescription.getFamily(), enemyDescription.getLevel());
        this.battlePhase = new BattlePhase(enemy, player);

        JPanel enemyInfoPanel = createEnemyInfoPanel(area2);
        enemyInfoPanel.setPreferredSize(new Dimension(300, 600));
        add(enemyInfoPanel, new GridBagConstraints());

        JPanel activeCreaturePanel = createActiveCreaturePanel();
        activeCreaturePanel.setPreferredSize(new Dimension(300, 600));
        add(activeCreaturePanel, new GridBagConstraints());

        JPanel actionPanel = createActionPanel();
        actionPanel.setPreferredSize(new Dimension(600, 200));
        add(actionPanel, new GridBagConstraints());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(enemyInfoPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(activeCreaturePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(actionPanel, gbc);
    }

    private JPanel createEnemyInfoPanel(Area2 area2) {
        JPanel enemyInfoPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        char randomKey = (char) ('A' + Math.random() * 9);
        String key = String.valueOf(randomKey);

        switch (area2.getMaxCreatures()) {
            case 1:
                enemyDescription.generateEL1WithKey(key);
                break;
            case 2:
                enemyDescription.generateEL2WithKey(key);
                break;
            case 3:
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

        JLabel enemylabel = new JLabel("Encountered Creature");
        JLabel nameLabel = new JLabel("Name: " + enemyDescription.getName());
        JLabel evolutionLabel = new JLabel("Evolution Level: " + enemyDescription.getLevel());
        JLabel typeLabel = new JLabel("Type: " + encounteredCreature.getType());
        JLabel familyLabel = new JLabel("Family: " + enemyDescription.getFamily());

        healthProgressBar = new JProgressBar(0, 50);
        healthProgressBar.setValue(50);
        healthProgressBar.setStringPainted(true);
        JLabel healthLabel = new JLabel("Health:");
        healthLabel.setLabelFor(healthProgressBar); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        enemyInfoPanel.add(enemylabel, gbc);

        gbc.gridy = 1;
        enemyInfoPanel.add(nameLabel, gbc);

        gbc.gridy = 2;
        enemyInfoPanel.add(evolutionLabel, gbc);

        gbc.gridy = 3;
        enemyInfoPanel.add(typeLabel, gbc);

        gbc.gridy = 4;
        enemyInfoPanel.add(familyLabel, gbc);

        gbc.gridy = 5;
        enemyInfoPanel.add(healthLabel, gbc);

        gbc.gridy = 6;
        gbc.weightx = 1.0; // Make the health bar expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        enemyInfoPanel.add(healthProgressBar, gbc);

        return enemyInfoPanel;
    }

    private JPanel createActiveCreaturePanel() {
        JPanel activeCreaturePanel = new JPanel(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;

        JLabel ActiveLabel = new JLabel("Active Creature ");
        nameLabel = new JLabel("Name: " + playerActiveCreature.getName());
        evolutionLabel = new JLabel("Evolution Level: " + playerActiveCreature.getEvolutionLevel());
        typeLabel = new JLabel("Type: " + playerActiveCreature.getType());
        familyLabel = new JLabel("Family: " + playerActiveCreature.getFamily());

        gbc.gridx = 0;
        gbc.gridy = 0;
        activeCreaturePanel.add(ActiveLabel, gbc);
        
        gbc.gridy = 1;
        activeCreaturePanel.add(nameLabel, gbc);

        gbc.gridy = 2;
        activeCreaturePanel.add(evolutionLabel, gbc);

        gbc.gridy = 3;
        activeCreaturePanel.add(typeLabel, gbc);

        gbc.gridy = 4;
        activeCreaturePanel.add(familyLabel, gbc);

        return activeCreaturePanel;
    }

    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(2, 1));

        // Row 1: Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton attackButton = new JButton("Attack");
        JButton swapButton = new JButton("Swap Creature");
        JButton catchButton = new JButton("Catch");
        JButton runButton = new JButton("Run");
    
        buttonPanel.add(attackButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(catchButton);
        buttonPanel.add(runButton);
        
        resultLabel = new JLabel("Result: ");
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (actionsLeft > 0) {
                int damage = calculateDamage();
                updateResultLabel("You dealt " + damage + " damage!");
        
                if (enemyHealth <= 0) {
                    enemyHealth = 0;
                    updateResultLabel("The enemy has been defeated! You won't give this enemy since its health reached 0.");
                    actionsLeft = 0;
                } else {
                    updateResultLabel("The enemy's health is now " + enemyHealth + ".");
                }

            updateEnemyHealthBar();
            }
            else {
                updateResultLabel("You have no actions left.");
                cardLayout.show(cards, "Area 2");
            }
            }
        });

        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actionsLeft > 0) {
                   swapCreature();
                   actionsLeft--;
                } else {
                    updateResultLabel("You have no actions left.");
                    cardLayout.show(cards, "Area 2");
                }
            }
        });

        catchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actionsLeft > 0) {
                    catchCreature(); 
                } else {
                    updateResultLabel("You have no actions left.");
                    cardLayout.show(cards, "Area 2");
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Area 2");
            }
        });

        actionPanel.add(buttonPanel);
        actionPanel.add(resultPanel);

        return actionPanel;
    }

    private int calculateDamage() {
        int damage = random.nextInt(10) + 1; // RAND(1,10)
        damage *= playerActiveCreature.getEvolutionLevel(); // AC_EL
    
        // Type advantage
        String playerType = playerActiveCreature.getType();
        String enemyType = enemyDescription.getType();
        if ((playerType.equals("FIRE") && enemyType.equals("GRASS")) ||
            (playerType.equals("GRASS") && enemyType.equals("WATER")) ||
            (playerType.equals("WATER") && enemyType.equals("FIRE"))) {
            damage *= 1.5;
        }
    
        enemyHealth -= damage;
        actionsLeft--; 
        return damage;
    }

    private void catchCreature() {
        int catchRate = 40 + 50 - enemyHealth; //(40 + 50 - EN_HP)%
        if (random.nextInt(100) < catchRate) {
            updateResultLabel("You have successfully caught the " + enemyDescription.getName() + "!");
            inventory.addCapturedCreature(new Creature(enemyDescription.getName(), enemyDescription.getType(), enemyDescription.getFamily(), enemyDescription.getLevel()));
            actionsLeft = 0;
        } else {
            updateResultLabel("Catch Failed!");
        }
        actionsLeft--; 
    }
    
    private void updateResultLabel(String result) {
        resultLabel.setText(result);
    }
    
    private void updateEnemyHealthBar() {
        healthProgressBar.setValue(enemyHealth);
    }

    private void swapCreature() {
        List<Creature> capturedCreatures = inventory.getCapturedCreatures();
    
        if (!capturedCreatures.isEmpty()) {
            Object[] possibilities = capturedCreatures.stream()
                    .map(Creature::getName)
                    .toArray();
            Object selectedCreatureName = JOptionPane.showInputDialog(
                    null,
                    "Choose a creature to swap:",
                    "Swap Creature",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    null);
    
            if (selectedCreatureName != null) {
                Creature selectedCreature = capturedCreatures.stream()
                        .filter(creature -> creature.getName().equals(selectedCreatureName))
                        .findFirst()
                        .orElse(null);
    
                if (selectedCreature != null) {
                    capturedCreatures.remove(selectedCreature);
                    inventory.addCapturedCreature(playerActiveCreature);
                    inventory.changeActiveCreature(selectedCreature);

                    playerActiveCreature = selectedCreature;
    
                    model.swapActiveCreature(selectedCreature);  // Update the active creature in the model

                    updateResultLabel("Creature swapped: " + selectedCreature.getName());
                    updateActiveCreaturePanel();
        }
            }
        } else {
            updateResultLabel("No creatures in the inventory to swap.");
        }
    }

    private void updateActiveCreaturePanel() {
        // Assuming nameLabel, evolutionLabel, typeLabel, and familyLabel are instance variables
        nameLabel.setText("Name: " + playerActiveCreature.getName());
        evolutionLabel.setText("Evolution Level: " + playerActiveCreature.getEvolutionLevel());
        typeLabel.setText("Type: " + playerActiveCreature.getType());
        familyLabel.setText("Family: " + playerActiveCreature.getFamily());
    }
    
}
