import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;


/**
 * The {@code PokemonView} class is a graphical user interface component that represents
 * the view of the application.
 */
public class PokemonView extends JFrame {
    /**
     * Reference to the model of the application.
     */
    private PokemonModel model;

    /**
     * Reference to the controller of the application.
     */
    private PokemonController controller;

    /**
     * Reference to the cards panel that manages different views or stages in the game.
     */
    private JPanel cards;

    /**
     * Reference to the card layout of the cards panel
     */
    private CardLayout cardLayout;

    /**
     * Reference to the active creature label
     */
    private JLabel activeCreatureLabel;

    private Area1 area1 = new Area1();

    private Area2 area2 = new Area2();

    private Area3 area3 = new Area3();

    /**
     * Reference to the start button
     */
    private JButton startButton;

    /**
     * Reference to the starter selection button
     */
    private JButton starterSelectionButton;

    /**
     * Reference to the background image
     */
    private ImageIcon welcomeBackground = new ImageIcon("welcome.png");

    /**
     * Reference to the background image
     */
    private ImageIcon backgroundImage = welcomeBackground;

    private ImageIcon defaultAreaTileImage = new ImageIcon("grass.png");

    private ImageIcon defaultAreaTileImage2 = new ImageIcon("grass2.png");

    private ImageIcon defaultAreaTileImage3 = new ImageIcon("grass2.png");


    /**
     * Image for the area tile where the creature is located
     */
    private ImageIcon creatureAreaTileImage = new ImageIcon("creature.png");

    private ImageIcon creatureAreaTileImage2 = new ImageIcon("creature2.png");

    private ImageIcon creatureAreaTileImage3 = new ImageIcon("creature3.png");


    private JLabel creatureLabel;

    /**
     * Reference to the coordinate label
     */
    private JLabel coordinateLabel;

    private int creaturePosition = 0;

    private int creatureRow = 0;

    private int creatureColumn = 0; 

    /**
     * Size of the grid
     */
    private JPanel areaTilesPanel;
    /**
     * Constructs a {@code PokemonView} with a reference to the model.
     * 
     * @param model The model of the application.
     */
    public PokemonView(PokemonModel model) {
        this.model = model;
        setTitle("Pokemon Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel welcomePanel = createWelcomePanel();
        cards.add(welcomePanel, "Welcome");

        JPanel createStarterSelection = createStarterSelectionPanel();
        cards.add(createStarterSelection, "Starter Selection");

        JPanel mainMenuPanel = createMainMenuPanel();
        cards.add(mainMenuPanel, "Main Menu");

        JPanel explorationPanel = createExplorationPanel();
        cards.add(explorationPanel, "Exploration");

        setContentPane(cards);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Sets the controller of the application.
     * 
     * @param controller The controller of the application.
     */
    public void setController(PokemonController controller) {
        this.controller = controller;
    }
    
    /**
     * Creates the welcome panel.
     * 
     * @return A {@code JPanel} that represents the welcome panel.
     */
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
    

    /**
     * Creates the starter selection panel.
     * 
     * @return A {@code JPanel} that represents the starter selection panel.
     */
    public JPanel createStarterSelectionPanel() {
        JPanel createStarterSelectionPanel = new JPanel(new GridLayout(2, 5)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JButton StrawanderButton = new JButton();
        ImageIcon Image1 = new ImageIcon ("strawander.png"); 
        StrawanderButton.setIcon(Image1);
        StrawanderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("STRAWANDER", "FIRE", "A", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });
            
        JButton ChocowoolButton = new JButton();
        ImageIcon Image2 = new ImageIcon ("chocowool.png"); 
        ChocowoolButton.setIcon(Image2);
            ChocowoolButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("CHOCOWOOL", "FIRE","B", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton ParfwitButton = new JButton();
        ImageIcon Image3 = new ImageIcon ("parfwit.png"); 
        ParfwitButton.setIcon(Image3);
            ParfwitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("PARFWIT", "FIRE", "C", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton BrownisaurButton = new JButton();
        ImageIcon Image4 = new ImageIcon ("brownisaur.png"); 
        BrownisaurButton.setIcon(Image4);
            BrownisaurButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("BROWNISAUR", "GRASS", "D", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton FrubatButton = new JButton();
        ImageIcon Image5 = new ImageIcon ("frubat.png"); 
        FrubatButton.setIcon(Image5);
            FrubatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("FRUBAT", "GRASS", "E", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton MaltsButton = new JButton(); 
        ImageIcon Image6 = new ImageIcon ("malts.png");
        MaltsButton.setIcon(Image6); 
            MaltsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("MALTS", "GRASS", "F", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton SquirpieButton = new JButton();
        ImageIcon Image7 = new ImageIcon ("squirpie.png"); 
        SquirpieButton.setIcon(Image7);
            SquirpieButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("SQUIRPIE", "WATER", "G", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });
        
        JButton ChocoliteButton = new JButton();
        ImageIcon Image8 = new ImageIcon ("chocolite.png");
        ChocoliteButton.setIcon(Image8);
            ChocoliteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("CHOCOLITE", "WATER", "H", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            });

        JButton OshaconeButton = new JButton();
        ImageIcon Image9 = new ImageIcon ("oshacone.png");
        OshaconeButton.setIcon(Image9);
            OshaconeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Creature selectedStarterCreatureObject = new Creature("OSHACONE", "WATER", "I", 1);
                    controller.selectedStarterCreature(selectedStarterCreatureObject);
                    cardLayout.show(cards, "Main Menu");
                }
            }); 

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

        createStarterSelectionPanel.add(StrawanderButton);
        createStarterSelectionPanel.add(ChocowoolButton);
        createStarterSelectionPanel.add(ParfwitButton);
        createStarterSelectionPanel.add(BrownisaurButton);
        createStarterSelectionPanel.add(FrubatButton);
	    createStarterSelectionPanel.add(MaltsButton);
        createStarterSelectionPanel.add(SquirpieButton);
        createStarterSelectionPanel.add(ChocoliteButton);
        createStarterSelectionPanel.add(OshaconeButton);
        createStarterSelectionPanel.add(exitButton);

        starterSelectionButton = new JButton("Starter Selection");

        createStarterSelectionPanel.setVisible(true);

        return createStarterSelectionPanel;
    }

    /**
     * Updates the main menu label.
     */
    public void updateMainMenuLabel() {
        String playerName = model.getPlayerName();
        Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();

        StringBuilder labelMessage = new StringBuilder("Hello ").append(playerName).append("!");
    
        if (selectedStarterCreatureObject != null) {
            labelMessage.append(" You chose ").append(selectedStarterCreatureObject.getName()).append(" as your starter creature.");
        } else {
            labelMessage.append(" You haven't chosen a starter creature yet.");
        }
    
        labelMessage.append(" You are now ready to explore the world of Pokemon!");
    
        activeCreatureLabel.setText(labelMessage.toString());
    }

    /**
     * Returns the start button.
     * 
     * @return The start button.
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * Returns the starter selection button.
     * 
     * @return The starter selection button.
     */
    public JButton getStarterSelectionButton() {
        return starterSelectionButton;
    }

    /**
     * Creates the main menu panel.
     * 
     * @return A {@code JPanel} that represents the main menu panel.
     */
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
                createInventoryPanel();
            }
        });
    
        evolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add evolve
                JOptionPane.showMessageDialog(null, "Evolve Creature");
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

    /**
     * Returns the starter creature message.
     * 
     * @return The starter creature message.
     */
    private String getStarterCreatureMessage() {
        if (model.getselectedStarterCreatureObject() != null) {
            return " you chose " + model.getselectedStarterCreatureObject().getName() + " as your starter creature.";
        } else {
            return " you haven't chosen a starter creature yet.";
        }
    }

    /**
     * Creates the exploration panel.
     * 
     * @return A {@code JPanel} that represents the exploration panel.
     */
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
            cardLayout.show(cards, "Area 1");
            }
    });


        area2Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cards, "Area 2");
            }
    });

    area3Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cards, "Area 3");
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

    JPanel area1Panel = createArea1Panel();
    cards.add(area1Panel, "Area 1");

   JPanel area2Panel = createArea2Panel();
   cards.add(area2Panel, "Area 2");

   JPanel area3Panel = createArea3Panel();
   cards.add(area3Panel, "Area 3");


    return explorationPanel;
    }

    /**
     * Creates a panel that displays the player's active creature information.
     */
    public void createInventoryPanel() {
        JPanel inventoryPanel = new JPanel(new BorderLayout());
    
        JTextArea inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable(false);
    
        JScrollPane scrollPane = new JScrollPane(inventoryTextArea);
        inventoryPanel.add(scrollPane, BorderLayout.CENTER);
    
        Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();
    
        Inventory inventory = model.getInventory();
    
        List<Creature> capturedCreatures = inventory.getCapturedCreatures();
    
        if (selectedStarterCreatureObject != null) {
            inventoryTextArea.append("Selected Starter Creature Information:\n");
            inventoryTextArea.append("Name: " + selectedStarterCreatureObject.getName() + "\n");
            inventoryTextArea.append("Type: " + selectedStarterCreatureObject.getType() + "\n");
            inventoryTextArea.append("Family: " + selectedStarterCreatureObject.getFamily() + "\n");
            inventoryTextArea.append("Evolution Level: " + selectedStarterCreatureObject.getEvolutionLevel() + "\n");
    
            // Locate the image file based on the creature's name (case-insensitive)
            String imageName = findImageByName(selectedStarterCreatureObject.getName());
            if (imageName != null) {
                ImageIcon creatureImage = new ImageIcon(imageName);
    
                // Display 
                JLabel imageLabel = new JLabel(creatureImage);
                inventoryPanel.add(imageLabel, BorderLayout.NORTH);
            } else {
                inventoryTextArea.append("Image not found for the selected creature.\n");
            }
        } else {
            inventoryTextArea.append("No selected starter creature.\n");
        }
    
    
        if (!capturedCreatures.isEmpty()) {
            inventoryTextArea.append("\n\nCaptured Creatures:\n");
            for (Creature capturedCreature : capturedCreatures) {
                inventoryTextArea.append("Name: " + capturedCreature.getName() + "\n");
                inventoryTextArea.append("Type: " + capturedCreature.getType() + "\n");
                inventoryTextArea.append("Family: " + capturedCreature.getFamily() + "\n");
                inventoryTextArea.append("Evolution Level: " + capturedCreature.getEvolutionLevel() + "\n");
                // Add other information as needed
                inventoryTextArea.append("\n");
            }
        } else {
            inventoryTextArea.append("No captured creatures.\n");
        }
    
        JScrollPane textScrollPane = new JScrollPane(inventoryTextArea);
        inventoryPanel.add(textScrollPane, BorderLayout.CENTER);
    
        JOptionPane.showMessageDialog(this, inventoryPanel, "View Inventory", JOptionPane.PLAIN_MESSAGE);
    }
    
    

    /**
     * Finds the image file based on the creature's name (case-insensitive).
     * 
     * @param creatureName The creature's name.
     * @return The image file name.
     */
    private String findImageByName(String creatureName) {
        String imageFileName = creatureName.toLowerCase() + ".png";
        
        String imagePath = getClass().getResource(imageFileName).getPath();
        
        return imagePath;
    }

     /**
 * Creates the Area 1 panel.
 * 
 * @return A {@code JPanel} that represents the Area 1 panel.
 */
public JPanel createArea1Panel() {
    JPanel area1Panel = new JPanel(new BorderLayout());

    // Add the selected starter creature object to the first block
    Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();
    if (selectedStarterCreatureObject != null) {
        JLabel creatureLabel = new JLabel(selectedStarterCreatureObject.toString());
        area1Panel.add(creatureLabel);
    } else {
    }

        // Create coordinate label
    coordinateLabel = new JLabel("Position: 1, 1");
    add(coordinateLabel, BorderLayout.NORTH);

        // Create panel for tiles and buttons
    JPanel tilesAndButtonsPanel = new JPanel(new BorderLayout());

    // Create area tiles panel
    areaTilesPanel = createAreaTilesPanel();
    tilesAndButtonsPanel.add(areaTilesPanel, BorderLayout.CENTER);

    creatureLabel = new JLabel("");  // Initialize creatureLabel
    tilesAndButtonsPanel.add(creatureLabel, BorderLayout.NORTH);

    // Create left, right, and exit buttons
    JButton leftButton = new JButton("Left");
    JButton rightButton = new JButton("Right");
    JButton exitButton = new JButton("Exit");

    leftButton.addActionListener(e -> moveCreatureLeft());
    rightButton.addActionListener(e -> moveCreatureRight());

    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement the logic to exit the Area 1 panel and go back to the Exploration panel
            cardLayout.show(cards, "Exploration");
        }
    });

     // Create panel for buttons
     JPanel buttonsPanel = new JPanel(new GridLayout(1, 3));
     buttonsPanel.add(leftButton);
     buttonsPanel.add(rightButton);
     buttonsPanel.add(exitButton);
 
     // Add buttons panel to the tiles and buttons panel
     tilesAndButtonsPanel.add(buttonsPanel, BorderLayout.SOUTH);
 
     // Add tiles and buttons panel to the main area1Panel
     area1Panel.add(tilesAndButtonsPanel, BorderLayout.CENTER);
 
     return area1Panel;
}

private JPanel createAreaTilesPanel() {
    JPanel areaTilesPanel = new JPanel(new GridLayout(1, 5));
    for (int i = 0; i < 5; i++) {
        JButton areaTileButton = new JButton(defaultAreaTileImage);
        areaTilesPanel.add(areaTileButton);
    }
    return areaTilesPanel;
}

/**
     * Moves the creature to the left.
     * If the creature is already at the leftmost position, an error message is displayed.
     */
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

    /**
     * Moves the creature to the right.
     * If the creature is already at the rightmost position, an error message is displayed.
     */
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

    private void handleEncounter() {
        // 40% chance of encountering a creature
        if (Math.random() < 0.4) {
            showBattlePhasePanel();
        }
    }

    /**
     * Shows the battle phase panel.
     */
    private void showBattlePhasePanel() {
        Inventory inventory = model.getInventory();
        BattlePhasePanel1 battlePhasePanel1 = new BattlePhasePanel1( model.getselectedStarterCreatureObject(), area1, cards, cardLayout, inventory, model);
    
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

    /**
     * Updates the creature position and the area tile images.
     */
    private void updateCreaturePosition() {
        creatureLabel.setText("Creature: " + model.getselectedStarterCreatureObject().getName());

        coordinateLabel.setText("Position: " + "1, " + (creaturePosition + 1));
        updateAreaTileImage(creaturePosition, creatureAreaTileImage);  // Update the current area tile image
        updateAreaTileImage(creaturePosition - 1, defaultAreaTileImage);  // Revert the image of the previous area tile
    }

    /**
     * Updates the image of the area tile at the specified position.
     * 
     * @param position The position of the area tile to update.
     * @param image The image to set.
     */
    private void updateAreaTileImage(int position, ImageIcon image) {
        Component[] components = areaTilesPanel.getComponents();
        if (position >= 0 && position < components.length && components[position] instanceof JButton) {
            ((JButton) components[position]).setIcon(image);
        }
    }
        public JPanel createArea2Panel() {
        JPanel area2Panel = new JPanel(new BorderLayout());
    
        // Add the selected starter creature object to the first block
        Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();
        if (selectedStarterCreatureObject != null) {
            JLabel creatureLabel = new JLabel(selectedStarterCreatureObject.toString());
            area2Panel.add(creatureLabel);
        } else {
        }
    
            // Create coordinate label
        coordinateLabel = new JLabel("Position: 1, 1");
        add(coordinateLabel, BorderLayout.NORTH);
    
            // Create panel for tiles and buttons
        JPanel tilesAndButtonsPanel = new JPanel(new BorderLayout());
    
        // Create area tiles panel
        areaTilesPanel = createAreaTilesPanel2();
        tilesAndButtonsPanel.add(areaTilesPanel, BorderLayout.CENTER);
    
        creatureLabel = new JLabel("");  // Initialize creatureLabel
        tilesAndButtonsPanel.add(creatureLabel, BorderLayout.NORTH);
    
        // Create left, right, and exit buttons
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        JButton exitButton = new JButton("Exit");
    
        leftButton.addActionListener(e -> moveCreatureLeft2());
        rightButton.addActionListener(e -> moveCreatureRight2());
        upButton.addActionListener(e -> moveCreatureUp2());
        downButton.addActionListener(e -> moveCreatureDown2());
    
         // Create panel for buttons
         JPanel buttonsPanel = new JPanel(new GridLayout(2, 3));
         buttonsPanel.add(leftButton);
         buttonsPanel.add(rightButton);
         buttonsPanel.add(exitButton);
         buttonsPanel.add(upButton);
         buttonsPanel.add(downButton);
    
         exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Exploration");
            }
        });
     
         // Add buttons panel to the tiles and buttons panel
         tilesAndButtonsPanel.add(buttonsPanel, BorderLayout.SOUTH);
     
         area2Panel.add(tilesAndButtonsPanel, BorderLayout.CENTER);
     
         return area2Panel;
    }
    
    private JPanel createAreaTilesPanel2() {
        JPanel areaTilesPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3 * 3; i++) {
            JButton areaTileButton = new JButton(defaultAreaTileImage2);
            areaTilesPanel.add(areaTileButton);
        }
        return areaTilesPanel;
    }
    
    /**
         * Moves the creature to the left.
         * If the creature is already at the leftmost position, an error message is displayed.
         */
        private void moveCreatureLeft2() {
            updateAreaTileImage2(creatureRow, creatureColumn, defaultAreaTileImage2);
            if (creatureColumn > 0) {
                creatureColumn--;
                updateCreaturePosition2();
                handleEncounter2();
            } else {
                JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move left.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        /**
         * Moves the creature to the right.
         * If the creature is already at the rightmost position, an error message is displayed.
         */
        private void moveCreatureRight2() {
            updateAreaTileImage2(creatureRow, creatureColumn, defaultAreaTileImage2);
            if (creatureColumn < 3 - 1) {
                creatureColumn++;
                updateCreaturePosition2();
                handleEncounter2();
            } else {
                JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move right.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        private void moveCreatureUp2() {
            updateAreaTileImage2(creatureRow, creatureColumn, defaultAreaTileImage2);
            if (creatureRow > 0) {
                creatureRow--;
                updateCreaturePosition2();
                handleEncounter2();
            } else {
                JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move up.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        private void moveCreatureDown2() {
            updateAreaTileImage2(creatureRow, creatureColumn, defaultAreaTileImage2);
            if (creatureRow < 3 - 1) {
                creatureRow++;
                updateCreaturePosition2();
                handleEncounter2();
            } else {
                JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move down.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        private void handleEncounter2() {
        // 40% chance of encountering a creature
        if (Math.random() < 0.4) {
            showBattlePhasePanel2();
        }
    }
    
    
    private void showBattlePhasePanel2() {
        Inventory inventory = model.getInventory();
        BattlePhasePanel2 battlePhasePanel2 = new BattlePhasePanel2( model.getselectedStarterCreatureObject(), area2, cards, cardLayout, inventory, model);
    
        // Create a new frame for the battle phase
        JFrame battleFrame = new JFrame("Battle Phase");
        battleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        battleFrame.getContentPane().add(battlePhasePanel2);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setVisible(true);
    }
    
        /**
         * Updates the creature position and the area tile images.
         */
        private void updateCreaturePosition2() {
            creatureLabel.setText("Creature: " + model.getselectedStarterCreatureObject().getName());
            coordinateLabel.setText("Position: " + (creatureRow + 1) + ", " + (creatureColumn + 1));
            updateAreaTileImage2(creatureRow, creatureColumn, creatureAreaTileImage2);
        }
    
        private void updateAreaTileImage2(int row, int column, ImageIcon image) {
            int position = row * 3 + column;
            Component[] components = areaTilesPanel.getComponents();
            if (position >= 0 && position < components.length && components[position] instanceof JButton) {
                ((JButton) components[position]).setIcon(image);
            }
        }
    

        public JPanel createArea3Panel() {
            JPanel area3Panel = new JPanel(new BorderLayout());
        
            // Add the selected starter creature object to the first block
            Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();
            if (selectedStarterCreatureObject != null) {
                JLabel creatureLabel = new JLabel(selectedStarterCreatureObject.toString());
                area3Panel.add(creatureLabel);
            } else {
            }
        
                // Create coordinate label
            coordinateLabel = new JLabel("Position: 1, 1");
            add(coordinateLabel, BorderLayout.NORTH);
        
                // Create panel for tiles and buttons
            JPanel tilesAndButtonsPanel = new JPanel(new BorderLayout());
        
            // Create area tiles panel
            areaTilesPanel = createAreaTilesPanel3();
            tilesAndButtonsPanel.add(areaTilesPanel, BorderLayout.CENTER);
        
            creatureLabel = new JLabel("");  // Initialize creatureLabel
            tilesAndButtonsPanel.add(creatureLabel, BorderLayout.NORTH);
        
            // Create left, right, and exit buttons
            JButton leftButton = new JButton("Left");
            JButton rightButton = new JButton("Right");
            JButton upButton = new JButton("Up");
            JButton downButton = new JButton("Down");
            JButton exitButton = new JButton("Exit");
        
            leftButton.addActionListener(e -> moveCreatureLeft3());
            rightButton.addActionListener(e -> moveCreatureRight3());
            upButton.addActionListener(e -> moveCreatureUp3());
            downButton.addActionListener(e -> moveCreatureDown3());
        
             // Create panel for buttons
             JPanel buttonsPanel = new JPanel(new GridLayout(2, 3));
             buttonsPanel.add(leftButton);
             buttonsPanel.add(rightButton);
             buttonsPanel.add(exitButton);
             buttonsPanel.add(upButton);
             buttonsPanel.add(downButton);
        
             exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(cards, "Exploration");
                }
            });
         
             // Add buttons panel to the tiles and buttons panel
             tilesAndButtonsPanel.add(buttonsPanel, BorderLayout.SOUTH);
         
             area3Panel.add(tilesAndButtonsPanel, BorderLayout.CENTER);
         
             return area3Panel;
        }
        
         private JPanel createAreaTilesPanel3() {
                JPanel areaTilesPanel = new JPanel(new GridLayout(4, 4));
                for (int i = 0; i < 4 * 4; i++) {
                    JButton areaTileButton = new JButton(defaultAreaTileImage3);
                    areaTilesPanel.add(areaTileButton);
                }
                return areaTilesPanel;
            }
        
        /**
             * Moves the creature to the left.
             * If the creature is already at the leftmost position, an error message is displayed.
             */
            private void moveCreatureLeft3() {
                updateAreaTileImage3(creatureRow, creatureColumn, defaultAreaTileImage3);
                if (creatureColumn > 0) {
                    creatureColumn--;
                    updateCreaturePosition3();
                    handleEncounter3();
                } else {
                    JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move left.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            /**
             * Moves the creature to the right.
             * If the creature is already at the rightmost position, an error message is displayed.
             */
            private void moveCreatureRight3() {
                updateAreaTileImage3(creatureRow, creatureColumn, defaultAreaTileImage3);
                if (creatureColumn < 4 - 1) {
                    creatureColumn++;
                    updateCreaturePosition3();
                    handleEncounter3();
                } else {
                    JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move right.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            private void moveCreatureUp3() {
                updateAreaTileImage3(creatureRow, creatureColumn, defaultAreaTileImage3);
                if (creatureRow > 0) {
                    creatureRow--;
                    updateCreaturePosition3();
                    handleEncounter3();
                } else {
                    JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move up.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            private void moveCreatureDown3() {
                updateAreaTileImage3(creatureRow, creatureColumn, defaultAreaTileImage3);
                if (creatureRow < 4 - 1) {
                    creatureRow++;
                    updateCreaturePosition3();
                    handleEncounter3();
                } else {
                    JOptionPane.showMessageDialog(this, "Out of Bounds! Cannot move down.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
            private void handleEncounter3() {
            // 40% chance of encountering a creature
            if (Math.random() < 0.4) {
                showBattlePhasePanel3();
            }
        }
        
            /**
             * Shows the battle phase panel.
             */
            private void showBattlePhasePanel3() {
                Inventory inventory = model.getInventory();
                BattlePhasePanel3 battlePhasePanel3 = new BattlePhasePanel3( model.getselectedStarterCreatureObject(), area3, cards, cardLayout, inventory, model);
            
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
        
            /**
             * Updates the creature position and the area tile images.
             */
            private void updateCreaturePosition3() {
                creatureLabel.setText("Creature: " + model.getselectedStarterCreatureObject().getName());

                coordinateLabel.setText("Position: " + (creatureRow + 1) + ", " + (creatureColumn + 1));
                updateAreaTileImage3(creatureRow, creatureColumn, creatureAreaTileImage3);
            }

            private void updateAreaTileImage3(int row, int column, ImageIcon image) {
                int position = row * 4 + column;
                Component[] components = areaTilesPanel.getComponents();
                if (position >= 0 && position < components.length && components[position] instanceof JButton) {
                    ((JButton) components[position]).setIcon(image);
                }
            }
}