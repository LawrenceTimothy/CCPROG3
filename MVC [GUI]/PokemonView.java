import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonView extends JFrame {
    private PokemonModel model;
    private PokemonController controller;

    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel activeCreatureLabel;
    private JButton startButton;
    private JButton starterSelectionButton;

    private ImageIcon welcomeBackground = new ImageIcon("welcome.png");

    private ImageIcon backgroundImage = welcomeBackground; 

    public PokemonView(PokemonModel model) {
        this.model = model;
        setTitle("Pokemon Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel welcomePanel = createWelcomePanel();
        cards.add(welcomePanel, "Welcome");

        JPanel starterSelectionPanel = createStarterSelectionPanel();
        cards.add(starterSelectionPanel, "Starter Selection");

        JPanel mainMenuPanel = createMainMenuPanel();
        cards.add(mainMenuPanel, "Main Menu");

        JPanel explorationPanel = createExplorationPanel();
        cards.add(explorationPanel, "Exploration");

        setContentPane(cards);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setController(PokemonController controller) {
        this.controller = controller;
    }

    public void updateMainMenuLabel() {
        String playerName = model.getPlayerName();
        String selectedStarterCreature = model.getSelectedStarterCreature();
    
        StringBuilder labelMessage = new StringBuilder("Hello ").append(playerName).append("!");
    
        if (selectedStarterCreature != null) {
            labelMessage.append(" You chose ").append(selectedStarterCreature).append(" as your starter creature.");
        } else {
            labelMessage.append(" You haven't chosen a starter creature yet.");
        }
    
        labelMessage.append(" You are now ready to explore the world of Pokemon!");
    
        activeCreatureLabel.setText(labelMessage.toString());
    }
    

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStarterSelectionButton() {
        return starterSelectionButton;
    }

    public JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
    
        startButton = new JButton("Start Game");
    
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Starter Selection");
            }
        });
        welcomePanel.add(startButton, BorderLayout.SOUTH);
    
        return welcomePanel;
    }
    
    

    public JPanel createStarterSelectionPanel() {
        JPanel starterSelectionPanel = new JPanel(new GridLayout(9, 1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        String[] starterCreatures = {
            "Strawander (Type: FIRE)",
            "Chocowool (Type: FIRE)",
            "Parfit (Type: FIRE)",
            "Brownisaur (Type: GRASS)",
            "Frubat (Type: GRASS)",
            "Malts (Type: GRASS)",
            "Squirpie (Type: WATER)",
            "Chocolite (Type: WATER)",
            "Oshacone (Type: WATER)"
        };

        for (String creature : starterCreatures) {
            JButton button = new JButton(creature);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.selectedStarterCreature(creature);
                    cardLayout.show(cards, "Main Menu");
                }
            });
            starterSelectionPanel.add(button);
        }
    
        starterSelectionButton = new JButton("Starter Selection");
    
        return starterSelectionPanel;
    }

    public JPanel createMainMenuPanel() {
        JPanel mainMenuPanel = new JPanel(new GridLayout(5, 1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
    
        activeCreatureLabel = new JLabel("Hello " + model.getPlayerName() + "!" + getStarterCreatureMessage());
    
        JButton exploreButton = new JButton("Explore Area 1, 2, or 3");
        JButton inventoryButton = new JButton("View Inventory");
        JButton evolveButton = new JButton("Evolve Creature");
        JButton exitButton = new JButton("Exit");
    
        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Exploration");
            }
        });
    
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add view inventory
                JOptionPane.showMessageDialog(null, "Viewing Inventory  <-- under construction");
            }
        });
    
        evolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add evolve
                JOptionPane.showMessageDialog(null, "Evolve Creature <-- under construction");
            }
        });
    
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    
        mainMenuPanel.add(activeCreatureLabel);
        mainMenuPanel.add(exploreButton);
        mainMenuPanel.add(inventoryButton);
        mainMenuPanel.add(evolveButton);
        mainMenuPanel.add(exitButton);
    
        return mainMenuPanel;
    }
    
    private String getStarterCreatureMessage() {
        if (model.getSelectedStarterCreature() != null) {
            return " you chose " + model.getSelectedStarterCreature() + " as your starter creature.";
        } else {
            return " you haven't chosen a starter creature yet.";
        }
    }
    

    public JPanel createExplorationPanel() {
        JPanel explorationPanel = new JPanel(new GridLayout(4, 1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JButton area1Button = new JButton("Explore Area 1");
        JButton area2Button = new JButton("Explore Area 2");
        JButton area3Button = new JButton("Explore Area 3");
        JButton backButton = new JButton("Back to Main Menu");

        area1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exploreArea1();
            }
        });

        area2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exploreArea2();
            }
        });

        area3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exploreArea3();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Main Menu");
            }
        });

        explorationPanel.add(area1Button);
        explorationPanel.add(area2Button);
        explorationPanel.add(area3Button);
        explorationPanel.add(backButton);

        return explorationPanel;
    }
}
