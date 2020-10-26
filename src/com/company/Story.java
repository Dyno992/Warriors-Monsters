package com.company;

import java.util.Scanner;

public class Story {

    // text colors
    public static final String tbColor_RESET = "\u001B[0m";
    public static final String tColor_RED = "\u001B[31m";
    public static final String tColor_GREEN = "\u001B[32m";

    Scanner sc = new Scanner(System.in);

    public void fightScene(Monster tempMonster, Player player) {
        System.out.println("Wow a wild " + tempMonster.getName() + " level " + tempMonster.getLevel() + " appeared!!!!!");
        System.out.println("[Press enter to hit the monster]");
        boolean fight = true;
        while (fight) {
            sc.nextLine();
            System.out.println(tColor_GREEN + "You hit the monster, dealing " + player.getStrength() + " damage." + tbColor_RESET);
            tempMonster.getHit(player.getStrength());
            tempMonster.getsoundWhenHit();
            System.out.println(tColor_RED + "The monster hits you, dealing " + tempMonster.getStrength() + " damage." + tbColor_RESET);
            player.getHit(tempMonster.getStrength());
            if (tempMonster.getHealth() <= 0) {
                tempMonster.setHealth(0);
            }
            else if (player.getHealth() <= 0 ) {
                player.setHealth(0);
            }
            System.out.println(player.getName() + ": " + player.getHealth() + " Healthpoints left");
            System.out.println(tempMonster.getName() + ": " + tempMonster.getHealth() + " Healthpoints left\n");
            System.out.println("[Press enter to hit the monster]");
            if (player.getHealth() <= 0) {
                System.out.println(tColor_RED + "You were killed by the monster!" + tbColor_RESET);
                System.out.println(tColor_RED + "Game Over......\n" + tbColor_RESET);
                System.exit(0);
            } else if (tempMonster.getHealth() <= 0) {
                System.out.println(tColor_GREEN + "You killed the monster, gaining " + tempMonster.getExperience() + " experience and " + tempMonster.getGold() + " Gold!" + tbColor_RESET);
                player.giveExperience(tempMonster.getExperience());
                player.lootGold(tempMonster.getGold());
                player.checkIfLevelUp();
                System.out.println("You are level " + player.getLevel() + ", and you have " + player.getExperience() + " experience and " + player.getHealth() + " healthpoints!");
                fight = false;
            }
        }
    }
}

