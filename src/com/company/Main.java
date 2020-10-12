package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
                System.out.println("Nu tryckte du på ettan");
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
