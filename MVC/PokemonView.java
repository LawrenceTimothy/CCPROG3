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


    private Area1Panel area1Panel; 
    private Area2Panel area2Panel;
    private Area3Panel area3Panel; 

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

        area1Panel = new Area1Panel(cards);
        cards.add(area1Panel, "Area 1 Exploration");
    
        area2Panel = new Area2Panel(cards);
        cards.add(area2Panel, "Area 2 Exploration");
    
        area3Panel = new Area3Panel(cards);
        cards.add(area3Panel, "Area 3 Exploration");

        setContentPane(cards);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setController(PokemonController controller) {
        this.controller = controller;
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
    

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStarterSelectionButton() {
        return starterSelectionButton;
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
                createInventoryPanel();
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
        if (model.getselectedStarterCreatureObject() != null) {
            return " you chose " + model.getselectedStarterCreatureObject().getName() + " as your starter creature.";
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
            area2Panel.setChosenStarterCreature(model.getselectedStarterCreatureObject());
            cardLayout.show(cards, "Area 1 Exploration");
        }
    });


        area2Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             area2Panel.setChosenStarterCreature(model.getselectedStarterCreatureObject());
            cardLayout.show(cards, "Area 2 Exploration");
        }
    });

    area3Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            area3Panel.setChosenStarterCreature(model.getselectedStarterCreatureObject());
            cardLayout.show(cards, "Area 3 Exploration");
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

// Add the following method to create the inventory panel
    public void createInventoryPanel() {
        JPanel inventoryPanel = new JPanel(new BorderLayout());

        JTextArea inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(inventoryTextArea);
        inventoryPanel.add(scrollPane, BorderLayout.CENTER);

        // Retrieve the selected starter creature object
        Creature selectedStarterCreatureObject = model.getselectedStarterCreatureObject();

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


        JScrollPane textScrollPane = new JScrollPane(inventoryTextArea);
        inventoryPanel.add(textScrollPane, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(this, inventoryPanel, "View Inventory", JOptionPane.PLAIN_MESSAGE);
    }

    private String findImageByName(String creatureName) {
        String imageFileName = creatureName.toLowerCase() + ".png";
        
        String imagePath = getClass().getResource(imageFileName).getPath();
        
        return imagePath;
    }
}

