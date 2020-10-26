package com.company.GameDescription_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Description {

    JFrame window;
    Container con;
    JPanel titleNamePanel, welcomeTextPanel, readButtonPanel, exitButtonPanel, mainTextPanel, nameTextPanel;
    JLabel titleNameLabel, welcomeTextLabel, nameTextLabel;
    JButton readButton, exitButton;
    JTextArea mainTextArea;
    ImageIcon icon;

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ExitScreenHandler exHandler = new ExitScreenHandler();

    public static void main(String[] args) {

        new Description();
    }

    public Description() {
        // --------------------------------------------- FRAME ---------------------------------------------------------
        window = new JFrame();
        icon = new ImageIcon("favicon.png");
        window.setIconImage(icon.getImage());
        window.setTitle(" Warriors & Monsters description");
        window.setSize(820, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
        window.setLocation(x, 150);

        con = window.getContentPane();

        // --------------------------------------------- TITLE ---------------------------------------------------------
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 10, 600, 50);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("WARRIORS & MONSTERS");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        // --------------------------------------------- WELCOME -------------------------------------------------------
        welcomeTextPanel = new JPanel();
        welcomeTextPanel.setBounds(200, 70, 400, 25);
        welcomeTextPanel.setBackground(Color.black);

        welcomeTextLabel = new JLabel("Welcome to the Game! By: Spetzim & Dyno992");
        welcomeTextLabel.setForeground(Color.white);
        welcomeTextLabel.setFont(normalFont);

        // --------------------------------------------- READ TITLE ----------------------------------------------------
        // Text Panel
        nameTextPanel = new JPanel();
        nameTextPanel.setBounds(110, 180, 600, 40);
        nameTextPanel.setBackground(Color.black);

        // Text Label
        nameTextLabel = new JLabel("If you want to read the description click on the READ button");
        nameTextLabel.setForeground(Color.white);
        nameTextLabel.setFont(normalFont);

        /// -------------------------------------------- READ BUTTON ---------------------------------------------------
        // Panel
        readButtonPanel = new JPanel();
        readButtonPanel.setBounds(350, 230, 100, 40);
        readButtonPanel.setBackground(Color.black);

        // Button
        readButton = new JButton("READ");
        readButton.setBackground(Color.black);
        readButton.setForeground(Color.green);
        readButton.setFocusPainted(false);
        readButton.setFont(normalFont);

        //------------Button Function-------------//

        readButton.addActionListener(tsHandler);

        //----------------------------------------//

        // -------------------------------------------- EXIT BUTTON ----------------------------------------------------
        // Panel
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(690, 500, 100, 40);
        exitButtonPanel.setBackground(Color.black);

        // Button
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.red);
        exitButton.setFocusPainted(false);
        exitButton.setFont(normalFont);

        //------------Button Function-------------//

        exitButton.addActionListener(exHandler);

        //----------------------------------------//

        // ------------------------------------------------ ADDS -------------------------------------------------------
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);

        welcomeTextPanel.add(welcomeTextLabel);
        con.add(welcomeTextPanel);

        nameTextPanel.add(nameTextLabel);
        con.add(nameTextPanel);

        readButtonPanel.add(readButton);
        con.add(readButtonPanel);

        exitButtonPanel.add(exitButton);
        con.add(exitButtonPanel);
    }

    public void createDescriptionScreen() {
        readButtonPanel.setVisible(false);
        nameTextPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 150, 600, 300);
        mainTextPanel.setBackground(Color.black);

        con.add(mainTextPanel);

        mainTextArea = new JTextArea("The game is based on getting to the final level of the game to win, where\nyou have to kill Monsters but some monsters are harder to kill, so you will need to buy items in the shop to get to the last level and not get killed from Monsters. The game was made for school purposes but will be updated\nwith a user interface in the future.\n\nHope you enjoyed it, greetings!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);
    }

    public void exitGame() {
        System.exit(0);
    }

    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {

            createDescriptionScreen();
        }
    }

    public class ExitScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {

            exitGame();
        }
    }
}
