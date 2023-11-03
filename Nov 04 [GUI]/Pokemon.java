import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pokemon extends JFrame {
    private String playerName;
    private String selectedStarterCreature = "";
    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel activeCreatureLabel;


    public Pokemon() {
        setTitle("Pokemon Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //a panel to manage multiple screens
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

    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());

        JButton startButton = new JButton("Start Game");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPlayerName();
            }
        });

        welcomePanel.add(startButton, BorderLayout.SOUTH);

        return welcomePanel;
    }

    private JPanel createStarterSelectionPanel() {
        JPanel starterSelectionPanel = new JPanel(new GridLayout(9, 1));
        
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
                    selectedStarterCreature = creature;
                    cardLayout.show(cards, "Main Menu");
                    updateMainMenuLabel();
                }
            });
            starterSelectionPanel.add(button);
        }
        
        return starterSelectionPanel;
    }
    

    private JPanel createMainMenuPanel() {
        JPanel mainMenuPanel = new JPanel(new GridLayout(5, 1));

        activeCreatureLabel = new JLabel("Hello " + playerName + "!  you chose " + selectedStarterCreature + " as your starter creature." + " You are now ready to explore the world of Pokemon!");

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

    private JPanel createExplorationPanel() {
        JPanel explorationPanel = new JPanel(new GridLayout(4, 1));

        JButton area1Button = new JButton("Explore Area 1");
        JButton area2Button = new JButton("Explore Area 2");
        JButton area3Button = new JButton("Explore Area 3");
        JButton backButton = new JButton("Back to Main Menu");

        area1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add area 1
                JOptionPane.showMessageDialog(null, "Area 1  <-- under construction");
            }
        });

        area2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add area 2
                JOptionPane.showMessageDialog(null, "Area 2  <-- under construction");
            }
        });

        area3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add area 3
                JOptionPane.showMessageDialog(null, "Area 3  <-- under construction");
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

    private void getPlayerName() {
        playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName != null) {
            String welcomeMessage = "Hello " + playerName + "! Welcome to the world of Pokemon!\n\n";
            String introductionMessage = "You are about to embark on a journey to become the best Pokemon trainer in the world!";
            JOptionPane.showMessageDialog(this, welcomeMessage, "Welcome", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, introductionMessage, "Introduction", JOptionPane.INFORMATION_MESSAGE);

            cardLayout.show(cards, "Starter Selection");
        }
    }

    private void updateMainMenuLabel() {
        activeCreatureLabel.setText("Hello " + playerName + "!  you chose " + selectedStarterCreature + " as your starter creature. You are now ready to explore the world of Pokemon!");
        
    }
}
