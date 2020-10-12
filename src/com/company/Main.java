package com.company;

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
            case "1" -> System.out.println("Nu tryckte du på ettan");
            case "2" -> System.out.println("nu tryckte du på tvåan");
            case "3" -> System.out.println("nu tryckte du på trean");
            default -> System.out.println("Du tryckte inte på något");
        }
    }
}
