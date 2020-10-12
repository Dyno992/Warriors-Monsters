package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    List<Monster> allMonsters = new ArrayList<>();
    Random r = new Random();
    public void initializeGame() {
        Scanner sc = new Scanner(System.in);
        Monster monster1 = new Monster("Jebote", 50);
        Monster monster2 = new Monster("Dino", 50);
        Monster monster3 = new Monster("Besim", 50);
        BigMonster bigMonster1 = new BigMonster("Daaamn-Monster", 100, 20);
        BigMonster bigMonster2 = new BigMonster("OMG-Monster", 100, 20);
        BigMonster bigMonster3 = new BigMonster("Holy-ShitMonster", 100, 20);
//                List<Monster> allMonsters = new ArrayList<>();
        allMonsters.add(monster1);
        allMonsters.add(monster2);
        allMonsters.add(monster3);
        allMonsters.add(bigMonster1);
        allMonsters.add(bigMonster2);
        allMonsters.add(bigMonster3);
        System.out.println("**********************************");
        System.out.println("* WELCOME TO WARRIORS & MONSTERS *");
        System.out.println("**********************************");
        System.out.print("Enter your name: ");
    }

    public void startGame() {
        int[] findMonsterGenerator = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Player player = new Player(sc.nextLine());
        System.out.println("1. Go adventuring");
        System.out.println("2. Show details about your character");
        System.out.println("3. Exit game");
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1":
                int temp = r.nextInt(10) + 1;
                    if (temp == 5) {
                        System.out.println("Didn't find any monsters");
                        System.out.println("[Press Enter to continue]");
                        sc.nextLine();
                    } else {
                        System.out.println("Wow a wild " + getRandomMonster().getMonsterName() + " appeared!!!!!");
                        System.out.println("[Press enter to hit the monster]");
                        sc.nextLine();
                        System.out.println();
                    }
                    break;
            case "2":
                System.out.println("*****************************");
                System.out.println("* Player Name: " + player.getPlayerName());
                System.out.println("* Player Level: " + player.getPlayerLevel());
                System.out.println("* Player Health: " + player.getPlayerHealthPoints() + "/200");
                System.out.println("* Player Experience: " + player.getPlayerExperience() + "/100");
                System.out.println("*****************************");
                break;
            case "3":
                System.out.println("Goodbye...");
                break;
            default:
                System.out.println("Du tryckte inte på något");
                break;
        }
    }
        public Monster getRandomMonster() {
            return allMonsters.get(r.nextInt(allMonsters.size()));
        }
    }
