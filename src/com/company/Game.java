package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    List<Monster> allMonsters = new ArrayList<>();
    Random r = new Random();
    Story story = new Story();
    Monster monster1 = new Monster(tColor_PURPLE + "➤ Orc" + tbColor_RESET, 50,100);
    Monster monster2 = new Monster(tColor_PURPLE + "➤ Dyno992" + tbColor_RESET, 50,100);
    Monster monster3 = new Monster(tColor_PURPLE + "➤ Spetzim" + tbColor_RESET, 50,100);
    Ogre ogre1 = new Ogre(tColor_PURPLE + "➤ Bigfoot" + tbColor_RESET, 75, 150);
    Ogre ogre2 = new Ogre(tColor_PURPLE + "➤ Chupacabra" + tbColor_RESET, 75, 150);
    Ogre ogre3 = new Ogre(tColor_PURPLE + "➤ Werewolf" + tbColor_RESET, 75, 150);
    Dragon dragon1 = new Dragon(tColor_PURPLE + "➤ Draco" + tbColor_RESET, 100, 200);
    Dragon dragon2 = new Dragon(tColor_PURPLE + "➤ Pendragon" + tbColor_RESET, 100, 200);
    Dragon dragon3 = new Dragon(tColor_PURPLE + "➤ Brenton" + tbColor_RESET, 100, 200);
    Player player;

    // text colors
    public static final String tbColor_RESET = "\u001B[0m";
    public static final String tColor_RED = "\u001B[31m";
    public static final String tColor_GREEN = "\u001B[32m";
    public static final String tColor_YELLOW = "\u001B[33m";
    public static final String tColor_BLUE = "\u001B[34m";
    public static final String tColor_PURPLE = "\u001B[35m";
    public static final String tColor_CYAN = "\u001B[36m";
    public static final String tColor_WHITE = "\u001B[37m";
    // bold text colors
    public static final String tColor_BOLDBLUE = "\033[1;34m";
    public static final String tColor_BOLDPURPLE = "\033[1;35m";
    public static final String tColor_BOLDWHITE = "\u001B[30m";
    public static final String tColor_BOLDYELLOW ="\033[1;33m";
    // text background color
    public static final String bColor_BLACK = "\u001B[40m";
    public static final String bColor_RED = "\u001B[41m";
    public static final String bColor_GREEN = "\u001B[42m";
    public static final String bColor_YELLOW = "\u001B[43m";
    public static final String bColor_BLUE = "\u001B[44m";
    public static final String bColor_PURPLE = "\u001B[45m";
    public static final String bColor_CYAN = "\u001B[46m";
    public static final String bColor_WHITE = "\u001B[47m";

    public void initializeGame() {
        allMonsters.add(monster1);
        allMonsters.add(monster2);
        allMonsters.add(monster3);
        allMonsters.add(ogre1);
        allMonsters.add(ogre2);
        allMonsters.add(ogre3);
        allMonsters.add(dragon1);
        allMonsters.add(dragon2);
        allMonsters.add(dragon3);

        System.out.println(tColor_BOLDWHITE + "\n****************➤*****************" + tbColor_RESET + "\n"
                + tColor_BOLDWHITE + "❂" + tbColor_RESET
                + tColor_BOLDYELLOW + " WELCOME TO WARRIORS & MONSTERS " + tbColor_RESET
                + tColor_BOLDWHITE + "❂" + tbColor_RESET + "\n"
                + tColor_BOLDWHITE + "****************➤*****************" + tbColor_RESET);
        System.out.print("\nEnter your name: ");
        player = new Player(tColor_BLUE + "❂ " + sc.nextLine() + tbColor_RESET);
    }

    public void openMenu() {
        System.out.println(tColor_YELLOW + "\nMenu:" + tbColor_RESET);
        System.out.println(tColor_GREEN + "1. Go adventuring" + tbColor_RESET);
        System.out.println(tColor_BLUE + "2. Show details about your character" + tbColor_RESET);
        System.out.println(tColor_PURPLE + "3. Show all Monsters details" + tbColor_RESET);
        System.out.println(tColor_CYAN + "4. Enter the shop" + tbColor_RESET);
        System.out.println(tColor_RED + "5. Exit game" + tbColor_RESET);
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1":
                goOnAdventure();
                break;
            case "2":
                playerDetails();
                break;
            case "3":
                monsterDetails();
                break;
            case "4":
                openShop();
                break;
            case "5":
                System.out.println(tColor_RED + "Goodbye...☹ See you soon!!" + tbColor_RESET);
                break;
            default:
                System.out.println(tColor_RED + "You didn't press anything..." + tbColor_RESET);
                openMenu();
        }
    }
        public Monster getRandomMonster() {
        Monster tempMonster = allMonsters.get(r.nextInt(allMonsters.size()));
           if (tempMonster.getHealth() <= 0){
               tempMonster = allMonsters.get(r.nextInt(allMonsters.size()));
            }
            return tempMonster;
        }

        public void continueOrNot() {
            System.out.println("Do you want to continue your adventures?\n");
            System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "for yes, press anything else to go back to the " + tColor_YELLOW +"menu." + tbColor_RESET);
            if(sc.nextLine().equals("y")){
                huntMonsters();
            }else{
                openMenu();
            }
        }

        public void huntMonsters() {
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
                continueOrNot();
            }
        }

        public void playerDetails() {
            System.out.println("*****************************\n"
                    + "* Player Name: " + player.getName() + "\n"
                    + "* Player Level: " + player.getLevel() + "\n"
                    + "* Player Health: " + player.getHealth() + "/200\n"
                    + "* Player Experience: " + player.getExperience() + "/100\n"
                    + "* Player Gold: " + player.getGold() + "\n"
                    + "* Player Strength: " + player.getStrength() + "\n"
                    + "*****************************");
            System.out.println("[Press Enter to go back to the Menu]");
            sc.nextLine();
            openMenu();
        }

        public void monsterDetails() {
            allMonsters.stream().forEach(System.out::println);
            System.out.println("[Press Enter to go back to the Menu]");
            sc.nextLine();
            openMenu();
        }

        public void goOnAdventure() {
            int temp = r.nextInt(10) + 1;
            if (temp == 5) {
                System.out.println(tColor_PURPLE + "Didn't find any monsters" + tbColor_RESET);
                System.out.println("Press " + tColor_GREEN + "y " + tbColor_RESET + "to continue, press anything else to go back to the " + tColor_YELLOW + "menu." + tbColor_RESET);
                if (sc.nextLine().equals("y")) {
                    Monster tempMonster;
                    tempMonster = getRandomMonster();
                    story.fightScene(tempMonster, player);
                    continueOrNot();
                }else {
                    openMenu();
                }
            } else {
                Monster tempMonster;
                tempMonster = getRandomMonster();
                story.fightScene(tempMonster, player);
                continueOrNot();
            }
        }

        public void openShop() {
        int healthPotPrice = 5;
        int healthFromPot = 200;
        int strengthPotPrice = 5;
        int strengthFromPot = 5;
            System.out.println("\n----------------------------------------------------------");
            System.out.println("\nWelcome to the shop. What do you want to purchase?");
            System.out.println("\nPress number of the desired item.");
            System.out.println("1. Healthpotion (Gives your maxhealth). Price: " + healthPotPrice);
            System.out.println("2. Strengthpotion (Gives your extra attack power). Price: " + strengthPotPrice);
            int selection = sc.nextInt();
            if (selection == 1) {
                if (player.getGold() >= healthPotPrice) {
                    player.useGold(healthPotPrice);
                    player.useHealthPotion(healthFromPot);
                    System.out.println("You successfully bought a Healthpotion! You have now " + player.getHealth() + " Healthpoints and " + player.getGold() + " Gold.");
                    System.out.println("Do you want to buy more potions? Press y for yes and anything else to go back to the main menu");
                } else if (player.getGold() < healthPotPrice) {
                    System.out.println("You dont have enough gold to purchase this item.");
                    System.out.println("Press y to go back to the main menu, anything else to browse through the shop again");
                }
            }else if (selection == 2){
                if (player.getGold() >= strengthPotPrice) {
                    player.useGold(strengthPotPrice);
                    player.useStrengthPotion(strengthFromPot);
                    System.out.println("You successfully bought a Strengthpotion! You have now " + player.getStrength() + " attacking power");
                    System.out.println("Do you want to buy more potions? Press y for yes and anything else to go back to the main menu");
                } else if (player.getGold() < strengthPotPrice) {
                    System.out.println("You dont have enough gold to purchase this item.");
                    System.out.println("Press y to browse through the shop again, anything else to go back to the main menu");
                }
            } else {
                System.out.println("You didnt choose anything. Redirecting you to the main menu.");
                System.out.println("[Press Enter to continue]");
                sc.nextLine();
                openMenu();
            }
            sc.nextLine();
            if(sc.nextLine().equals("y")){
                openMenu();
            }else {
                openShop();
            }
        }
    }
