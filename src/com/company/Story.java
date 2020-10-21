package com.company;

import java.util.Scanner;

public class Story {
    Scanner sc = new Scanner(System.in);
    public void fightScene(Monster tempMonster, Player player) {
        System.out.println("Wow a wild " + tempMonster.getName() + " level " + tempMonster.getLevel() +" appeared!!!!!");
        System.out.println("[Press enter to hit the monster]");
        while (true) {
            sc.nextLine();
            System.out.println(tColor_GREEN + "You hit the monster, dealing " + player.getStrength() + " damage." + tbColor_RESET);
            tempMonster.getHit(player.getStrength());
            tempMonster.getsoundWhenHit();
            System.out.println(tColor_RED + "The monster hits you, dealing " + tempMonster.getStrength() + " damage." + tbColor_RESET);
            player.getHit(tempMonster.getStrength());
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
                if (player.getLevel() == 10) {
                    System.out.println(tColor_GREEN + "Congratulations! " + tbColor_RESET + tColor_BOLDYELLOW + "You are max level and have just won over the Monsters!!!\n" + tbColor_RESET);
                    System.out.println("[Press Enter to see the remaining monsters and credits]");
                    sc.nextLine();
                    printRemainingMonstersAndCredits();
                    sc.nextLine();
                    System.exit(0);
                }
                return;
            }
        }
    }

    private void printRemainingMonstersAndCredits() {

    }

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

}
