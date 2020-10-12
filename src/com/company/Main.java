package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] findMonsterGenerator = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Insert input
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************************");
        System.out.println("* WELCOME TO WARRIORS & MONSTERS *");
        System.out.println("**********************************");
        System.out.print("Enter your name: ");
        Player player = new Player(sc.nextLine());
        System.out.println("1. Go adventuring");
        System.out.println("2. Show details about your character");
        System.out.println("3. Exit game");

        //Menu Choice
        System.out.print("\nMake your choice: ");
        switch (sc.nextLine()) {
            case "1" :
                int temp = 1;
                for (int j : findMonsterGenerator) {
                    if (temp == j) {
                        System.out.println("Didn't find any monsters");
                        System.out.println("[Press Enter to continue]");
                    } else{
                        System.out.println("Wow a wild" + Math.random(Monster));
                    }
                }
                break;
            case "2" :
                System.out.println("*****************************");
                System.out.println("* Player Name: " + player.getPlayerName());
                System.out.println("* Player Level: " + player.getplayerLevel());
                System.out.println("* Player Health: " + player.getPlayerHealthPoints() + "/200");
                System.out.println("* Player Experience: " + player.getPlayerExperience() + "/100");
                System.out.println("*****************************");
                break;
            case "3" :
                System.out.println("Goodbye...");
                break;
            default :
                System.out.println("Du tryckte inte på något");
                break;
        }
    }
}
