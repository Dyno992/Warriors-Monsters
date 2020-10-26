package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {
    /**
     * Adding essentials for the game to work
     * Player
     * Monsters
     * Colors
     * List
     * Storyline
     */
    // text colors
    public static final String tbColor_RESET = "\u001B[0m";
    public static final String tColor_RED = "\u001B[31m";
    public static final String tColor_GREEN = "\u001B[32m";
    public static final String tColor_YELLOW = "\u001B[33m";
    public static final String tColor_BLUE = "\u001B[34m";
    public static final String tColor_PURPLE = "\u001B[35m";
    public static final String tColor_CYAN = "\u001B[36m";
    // bold text colors
    public static final String tColor_BOLDWHITE = "\u001B[30m";
    public static final String tColor_BOLDYELLOW = "\033[1;33m";
    public static final String tColor_BOLDRED = "\033[1;31m";
    // text background color
    public static final String bColor_BLACK = "\u001B[40m";

    Scanner sc = new Scanner(System.in);
    List<Monster> allMonsters = new ArrayList<>();
    Random r = new Random();
    Story story = new Story();
    Monster monster1 = new Monster(tColor_PURPLE + "➤ Orc" + tbColor_RESET, 50, 100);
    Monster monster2 = new Monster(tColor_PURPLE + "➤ Dyno992" + tbColor_RESET, 50, 100);
    Monster monster3 = new Monster(tColor_PURPLE + "➤ Spetzim" + tbColor_RESET, 50, 100);
    Ogre ogre1 = new Ogre(tColor_PURPLE + "➤ Bigfoot" + tbColor_RESET, 75, 150);
    Ogre ogre2 = new Ogre(tColor_PURPLE + "➤ Chupacabra" + tbColor_RESET, 75, 150);
    Ogre ogre3 = new Ogre(tColor_PURPLE + "➤ Werewolf" + tbColor_RESET, 75, 150);
    Dragon dragon1 = new Dragon(tColor_PURPLE + "➤ Draco" + tbColor_RESET, 100, 200);
    Dragon dragon2 = new Dragon(tColor_PURPLE + "➤ Pendragon" + tbColor_RESET, 100, 200);
    Dragon dragon3 = new Dragon(tColor_PURPLE + "➤ Brenton" + tbColor_RESET, 100, 200);
    Player player;

    /**
     * Method to add all different monsters into a List
     */
    public void initializeMonsters() {
        allMonsters.add(monster1);
        allMonsters.add(monster2);
        allMonsters.add(monster3);
        allMonsters.add(ogre1);
        allMonsters.add(ogre2);
        allMonsters.add(ogre3);
        allMonsters.add(dragon1);
        allMonsters.add(dragon2);
        allMonsters.add(dragon3);
    }

    /**
     * Method for the first initalazation of the game, choose new or load game.
     * Includes switchcase menu for 2 different options.
     * throws IOException and ClassNotFoundException because of the saveGame and loadGame Methods
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void lobby() throws IOException, ClassNotFoundException {
        System.out.println(tColor_BOLDWHITE + "\n****************➤*****************" + tbColor_RESET + "\n"
                + tColor_BOLDWHITE + "❂" + tbColor_RESET
                + tColor_BOLDYELLOW + " WELCOME TO WARRIORS & MONSTERS " + tbColor_RESET
                + tColor_BOLDWHITE + "❂" + tbColor_RESET + "\n"
                + tColor_BOLDWHITE + "****************➤*****************" + tbColor_RESET);
        System.out.println(tColor_BOLDYELLOW + "\n1. New game" + tbColor_RESET);
        System.out.println(tColor_BOLDYELLOW + "2. Load last saved game" + tbColor_RESET);
        System.out.print("\nMake your choice: ");
        boolean loop = true;
        while (loop) {
            switch (sc.nextLine()) {
                case "1":
                    System.out.print("\nEnter your name: ");
                    player = new Player(tColor_BLUE + "❂ " + sc.nextLine() + tbColor_RESET);
                    loop = false;
                    initializeMonsters();
                    break;
                case "2":
                    loadGame();
                    loop = false;
                    break;
                default:
                    System.out.println(tColor_RED + "You didn't choose anything..." + tbColor_RESET);
                    System.out.println(tColor_RED + "Try again!" + tbColor_RESET);
            }
        }
    }

    /**
     * Method to hold the menu open in the game.
     * Switchcase menu for the different options.
     * throws IOEXception and ClassNotFoundException for the saveGame and loadGame methods to work.
     */
    public void openMenu() throws IOException, ClassNotFoundException {
        System.out.println(tColor_YELLOW + "\nMenu:" + tbColor_RESET);
        System.out.println(tColor_GREEN + "1. Go adventuring" + tbColor_RESET);
        System.out.println(tColor_BLUE + "2. Show details about your character" + tbColor_RESET);
        System.out.println(tColor_PURPLE + "3. Show all Monsters details" + tbColor_RESET);
        System.out.println(tColor_CYAN + "4. Enter the shop" + tbColor_RESET);
        System.out.println(tColor_BOLDRED + "\n5. Save and exit game" + tbColor_RESET);
        System.out.println(tColor_RED + "6. Exit game" + tbColor_RESET);
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1" -> goOnAdventure();
            case "2" -> playerDetails();
            case "3" -> monsterDetails();
            case "4" -> openShop();
            case "5" -> {
                saveGame();
                System.out.println(tColor_GREEN + "Saving.....See you another time. :)" + tbColor_RESET);
            }
            case "6" -> System.out.println(tColor_RED + "Goodbye...☹ See you soon!!" + tbColor_RESET);
            default -> {
                System.out.println(tColor_RED + "You didn't press anything..." + tbColor_RESET);
                openMenu();
            }
        }
    }

    /**
     * Gets a random monster from the allMonsters List
     * @return a random monster randomized by the randomclass
     */
    public Monster getRandomMonster() {
        Monster tempMonster = allMonsters.get(r.nextInt(allMonsters.size()));
        if (tempMonster.getHealth() <= 0) {
            tempMonster = allMonsters.get(r.nextInt(allMonsters.size()));
        }
        return tempMonster;
    }

    /**
     * Method to ask user if they want to continue to search monsters after a fight.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void continueOrNot() throws IOException, ClassNotFoundException {
        System.out.println("Do you want to continue your adventures?\n");
        System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "for yes, press anything else to go back to the " + tColor_YELLOW + "menu." + tbColor_RESET);
        if (sc.nextLine().equals("y")) {
            huntMonsters();
        } else {
            openMenu();
        }
    }

    /**
     * Method to hunt monsters, also a if else for a 10% chance you dont find a monster and have to search again.
     * if you find a monster we call for the getRandomMonster() and fightScene()
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void huntMonsters() throws IOException, ClassNotFoundException {
        int tempNumber = r.nextInt(10) + 1;
        if (tempNumber == 5) {
            System.out.println(tColor_PURPLE + "Didn't find any monsters" + tbColor_RESET);
            System.out.println("[Press Enter to continue]");
            sc.nextLine();
            huntMonsters();
        } else {
            Monster tempMonster;
            tempMonster = getRandomMonster();
            story.fightScene(tempMonster, player);
            if (player.checkIfMaxLevel()) {
                sc.nextLine();
                printRemainingMonstersAndCredits();
            }
            continueOrNot();
        }
    }

    /**
     * Prints out all details about the player.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void playerDetails() throws IOException, ClassNotFoundException {
        System.out.println("***************" + tColor_BLUE + " YOUR CHARACTER "+ tbColor_RESET + "**************\n"
                + "* Player Name: " + player.getName() + "\n"
                + "* Player Level: " + player.getLevel() + "\n"
                + "* Player Health: " + player.getHealth() + "/200\n"
                + "* Player Experience: " + player.getExperience() + "/100\n"
                + "* Player Gold: " + player.getGold() + "\n"
                + "* Player Strength: " + player.getStrength() + "\n"
                + "*********************************************");
        System.out.println("[Press Enter to go back to the Menu]");
        sc.nextLine();
        openMenu();
    }

    /**
     * Prints out all the details about the monsters.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void monsterDetails() throws IOException, ClassNotFoundException {
        allMonsters.stream().forEach(System.out::println);
        System.out.println("[Press Enter to go back to the Menu]");
        sc.nextLine();
        openMenu();
    }

    /**
     * first initation of hunting monsters.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void goOnAdventure() throws IOException, ClassNotFoundException {
        int temp = r.nextInt(10) + 1;
        if (temp == 5) {
            System.out.println(tColor_PURPLE + "Didn't find any monsters" + tbColor_RESET);
            System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to continue, press anything else to go back to the " + tColor_YELLOW + "menu." + tbColor_RESET);
            if (sc.nextLine().equals("y")) {
                Monster tempMonster;
                tempMonster = getRandomMonster();
                story.fightScene(tempMonster, player);
                if (player.checkIfMaxLevel()) {
                    sc.nextLine();
                    printRemainingMonstersAndCredits();
                }
                continueOrNot();
            } else {
                openMenu();
            }
        } else {
            Monster tempMonster;
            tempMonster = getRandomMonster();
            story.fightScene(tempMonster, player);
            if (player.checkIfMaxLevel()) {
                sc.nextLine();
                printRemainingMonstersAndCredits();
            }
            continueOrNot();
        }
    }

    /**
     * Method to save the player and monster details.
     * @throws IOException
     */
    public void saveGame() throws IOException {
        ObjectOutputStream savePlayer = new ObjectOutputStream(new FileOutputStream("Player.txt"));
        savePlayer.writeObject(player);
        ObjectOutputStream saveMonsters = new ObjectOutputStream(new FileOutputStream("Monster.txt"));
        saveMonsters.writeObject(allMonsters);
        savePlayer.close();
        saveMonsters.close();
    }

    /**
     * Method to load the player and monster details
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadGame() throws IOException, ClassNotFoundException {
        ObjectInputStream load = new ObjectInputStream(new FileInputStream("Player.txt"));
        player = (Player) load.readObject();
        load.close();
        ObjectInputStream loadMonster = new ObjectInputStream(new FileInputStream("Monster.txt"));
        allMonsters = (List<Monster>) loadMonster.readObject();
        loadMonster.close();
    }

    /**
     * Method to open the shop and choose between different potions that increase player health or player strength
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void openShop() throws IOException, ClassNotFoundException {
        int healthPotPrice = 5;
        int healthFromPot = 200;
        int strengthPotPrice = 5;
        int strengthFromPot = 5;
        System.out.println("\n*------------------------*" + tColor_CYAN + " SHOP " + tbColor_RESET + "*--------------------------*");
        System.out.println("\nWelcome to the shop. What do you want to purchase?");
        System.out.println("You have " + player.getGold() + tColor_GREEN + " Gold" + tbColor_RESET);
        System.out.println("\nPress number of the desired item. Or anything else if you want to be redirected to the" + tColor_YELLOW + " menu" + tbColor_RESET);
        System.out.println("1. " + tColor_CYAN + "Healthpotion" + tbColor_RESET + " (Gives your maxhealth). Price: " + tColor_GREEN + healthPotPrice + tbColor_RESET);
        System.out.println("2. " + tColor_RED + "Strengthpotion" + tbColor_RESET + " (Gives your extra attack power). Price: " + tColor_GREEN + strengthPotPrice + tbColor_RESET);
        String selection = sc.nextLine();
        switch (selection) {
            case "1":
                if (player.getGold() >= healthPotPrice) {
                    player.useGold(healthPotPrice);
                    player.useHealthPotion(healthFromPot);
                    System.out.println("You successfully bought a " + tColor_CYAN + "Healthpotion" + tbColor_RESET + "! You have now " + player.getHealth() + tColor_CYAN + " Healthpoints " + tbColor_RESET + "and " + player.getGold() + tColor_GREEN + " Gold" + tbColor_RESET + ".");
                    System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to browse through the shop again, anything else to go back to the " + tColor_YELLOW + "main menu." + tbColor_RESET);
                    String select = sc.nextLine();
                    if ("y".equals(select)) {
                        openShop();
                    } else {
                        openMenu();
                    }
                } else if (player.getGold() < healthPotPrice) {
                    System.out.println(tColor_RED + "You dont have enough gold to purchase this item." + tbColor_RESET);
                    System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to browse through the shop again, anything else to go back to the " + tColor_YELLOW + "main menu." + tbColor_RESET);
                    String select = sc.nextLine();
                    if ("y".equals(select)) {
                        openShop();
                    } else {
                        openMenu();
                    }
                }
                break;
            case "2":
                if (player.getGold() >= strengthPotPrice) {
                    player.useGold(strengthPotPrice);
                    player.useStrengthPotion(strengthFromPot);
                    System.out.println("You successfully bought a " + tColor_RED + "Strengthpotion" + tbColor_RESET + "! You have now " + player.getStrength() + tColor_RED + " attacking power" + tbColor_RESET + " and " + player.getGold() + tColor_GREEN + " Gold" + tbColor_RESET + ".");
                    System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to browse through the shop again, anything else to go back to the " + tColor_YELLOW + "main menu." + tbColor_RESET);
                    String select = sc.nextLine();
                    if ("y".equals(select)) {
                        openShop();
                    } else {
                        openMenu();
                    }
                } else if (player.getGold() < strengthPotPrice) {
                    System.out.println(tColor_RED + "You dont have enough gold to purchase this item." + tbColor_RESET);
                    System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to browse through the shop again, anything else to go back to the " + tColor_YELLOW + "main menu." + tbColor_RESET);
                    String select = sc.nextLine();
                    if ("y".equals(select)) {
                        openShop();
                    } else {
                        openMenu();
                    }
                }
                break;
            default:
                System.out.println(tColor_RED + "You didnt choose anything. Redirecting you to the main menu." + tbColor_RESET);
                System.out.println("[Press Enter to continue]");
                sc.nextLine();
                openMenu();
        }
    }

    /**
     * Prints out all the monsters when you win the game. Also endgame credits
     */
    public void printRemainingMonstersAndCredits() {
        allMonsters
                .stream()
                .filter(Monster -> Monster.getHealth() >= 0)
                .forEach(System.out::println);
        System.out.println("\n " + bColor_BLACK + tColor_RED + "Credits : Besim & Dino made this crazy ass super mega nice game" + tbColor_RESET);
        System.exit(0);
    }
}

