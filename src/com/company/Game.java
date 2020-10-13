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
    Monster monster1 = new Monster("Jebote", 50,100);
    Monster monster2 = new Monster("Dino", 50,100);
    Monster monster3 = new Monster("Besim", 50,100);
    Ogre ogre1 = new Ogre("Daaamn-Monster", 100, 150);
    Ogre ogre2 = new Ogre("OMG-Monster", 100, 150);
    Ogre ogre3 = new Ogre("Holy-ShitMonster", 100, 150);
    Player player;
    public void initializeGame() {
        allMonsters.add(monster1);
        allMonsters.add(monster2);
        allMonsters.add(monster3);
        allMonsters.add(ogre1);
        allMonsters.add(ogre2);
        allMonsters.add(ogre3);
        System.out.println("**********************************");
        System.out.println("* WELCOME TO WARRIORS & MONSTERS *");
        System.out.println("**********************************");
        System.out.print("Enter your name: ");
        player = new Player(sc.nextLine());
    }

    public void openMenu() {
        System.out.println("1. Go adventuring");
        System.out.println("2. Show details about your character");
        System.out.println("3. Exit game");
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1":
                int temp = r.nextInt(10) + 1;
                    if (temp == 5) {
                        System.out.println("Didn't find any monsters");
                        System.out.println("Press y to continue, anything else to go back to the Menu");
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
                System.out.println("*****************************");
                System.out.println("* Player Name: " + player.getName());
                System.out.println("* Player Level: " + player.getLevel());
                System.out.println("* Player Health: " + player.getHealth() + "/200");
                System.out.println("* Player Experience: " + player.getExperience() + "/100");
                System.out.println("*****************************\n");
                System.out.println("[Press Enter to go back to the Menu]");
                sc.nextLine();
                openMenu();
                break;
            case "3":
                System.out.println("Goodbye...");
                break;
            default:
                System.out.println("Du tryckte inte på något");

        }
    }
        public Monster getRandomMonster() {
            return allMonsters.get(r.nextInt(allMonsters.size()));
        }

        public void continueOrNot() {
            System.out.println("Do you want to continue your adventures?\n");
            System.out.println("Press y for yes, press anything else to go back to the menu.");
            if(sc.nextLine().equals("y")){
                huntMonsters();
            }else{
                openMenu();
            }
        }
        public void huntMonsters() {
            int tempNumber = r.nextInt(10) + 1;
            if (tempNumber == 5) {
                System.out.println("Didn't find any monsters");
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
