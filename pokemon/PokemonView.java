import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

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

    private Area1Panel area1Panel; // New Area1Panel instance


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

        // Initialize AreaPanel with an empty constructor
        area1Panel = new Area1Panel();
        cards.add(area1Panel, "Area 1 Exploration");

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

        Map<String, String> creatureImages = new LinkedHashMap<>();
        creatureImages.put("Strawander (Type: FIRE)", "strawander.png");
        creatureImages.put("Chocowool (Type: FIRE)", "chocowool.png");
        creatureImages.put("Parfwit (Type: FIRE)", "parfwit.png");
        creatureImages.put("Brownisaur (Type: GRASS)", "brownisaur.png");
        creatureImages.put("Frubat (Type: GRASS)", "frubat.png");
        creatureImages.put("Malts (Type: GRASS)", "malts.png");
        creatureImages.put("Squirpie (Type: WATER)", "squirpie.png");
        creatureImages.put("Chocolite (Type: WATER)", "chocolite.png");
        creatureImages.put("Oshacone (Type: WATER)", "oshacone.png");

        int currentCreatureCount = 0;

        for (Map.Entry<String, String> entry : creatureImages.entrySet()) {
            String creature = entry.getKey();
            String imagePath = entry.getValue();

            // Create a panel for each creature, containing a button and label
            JPanel creaturePanel = new JPanel(new BorderLayout());

            // Load the image for the creature
            ImageIcon creatureImage = new ImageIcon(imagePath);
            JLabel imageLabel = new JLabel(creatureImage);
            creaturePanel.add(imageLabel, BorderLayout.CENTER);

            JButton button = new JButton(creature);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.selectedStarterCreature(creature);
                    cardLayout.show(cards, "Main Menu");
                }
            });
            creaturePanel.add(button, BorderLayout.SOUTH);

            starterSelectionPanel.add(creaturePanel);
            currentCreatureCount++;

            // Check if the first row is filled
            if (currentCreatureCount % 4 == 0) {
                starterSelectionPanel.setLayout(new GridLayout(2, 5));
            }
        }

        // Add an exit button with a picture
        JButton exitButton = new JButton();
        ImageIcon exitImage = new ImageIcon("choose.png");
        exitButton.setIcon(exitImage);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the whole program
            }
        });

        starterSelectionPanel.add(exitButton);

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
                area1Panel.setChosenStarterCreature(model.getSelectedStarterCreature());
                cardLayout.show(cards, "Area 1 Exploration");
            }
        });

        area2Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             area1Panel.setChosenStarterCreature(model.getSelectedStarterCreature());
            }
    });

    area3Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             area1Panel.setChosenStarterCreature(model.getSelectedStarterCreature());
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
    public Object getModel() {
        return null;
    }
}
