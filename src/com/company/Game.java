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
    Monster monster1 = new Monster(tColor_PURPLE + "➤ Orc" + tbColor_RESET, 25,100);
    Monster monster2 = new Monster(tColor_PURPLE + "➤ Dyno992" + tbColor_RESET, 25,100);
    Monster monster3 = new Monster(tColor_PURPLE + "➤ Spetzim" + tbColor_RESET, 25,100);
    Ogre ogre1 = new Ogre(tColor_PURPLE + "➤ Bigfoot" + tbColor_RESET, 50, 150);
    Ogre ogre2 = new Ogre(tColor_PURPLE + "➤ Chupacabra" + tbColor_RESET, 50, 150);
    Ogre ogre3 = new Ogre(tColor_PURPLE + "➤ Werewolf" + tbColor_RESET, 50, 150);
    Dragon dragon1 = new Dragon(tColor_PURPLE + "➤ Draco" + tbColor_RESET, 75, 200);
    Dragon dragon2 = new Dragon(tColor_PURPLE + "➤ Pendragon" + tbColor_RESET, 75, 200);
    Dragon dragon3 = new Dragon(tColor_PURPLE + "➤ Brenton" + tbColor_RESET, 75, 200);
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
        System.out.println(tColor_RED + "3. Exit game" + tbColor_RESET);
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1":
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
                    break;
            case "2":
                System.out.println("*****************************\n"
                        + "* Player Name: " + player.getName() + "\n"
                        + "* Player Level: " + player.getLevel() + "\n"
                        + "* Player Health: " + player.getHealth() + "/200\n"
                        + "* Player Experience: " + player.getExperience() + "/100\n"
                        + "*****************************");
                System.out.println("[Press Enter to go back to the Menu]");
                sc.nextLine();
                openMenu();
                break;
            case "3":
                System.out.println(tColor_RED + "Goodbye...☹ See you soon!!" + tbColor_RESET);
                break;
            default:
                System.out.println(tColor_RED + "You didn't press anything..." + tbColor_RESET);
                openMenu();
        }
    }
        public Monster getRandomMonster() {
            return allMonsters.get(r.nextInt(allMonsters.size()));
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
            } else {
                Monster tempMonster;
                tempMonster = getRandomMonster();
                story.fightScene(tempMonster, player);
                continueOrNot();
            }
        }
    }
