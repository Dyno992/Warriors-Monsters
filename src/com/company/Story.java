package com.company;

import java.util.Scanner;

public class Story {
    Scanner sc = new Scanner(System.in);
    public void fightScene(Monster tempMonster, Player player) {
        System.out.println("Wow a wild " + tempMonster.getName() + " appeared!!!!!");
        System.out.println("[Press enter to hit the monster]");
        while (true) {
            sc.nextLine();
            System.out.println("You hit the monster, dealing " + player.getStrength() + " damage.");
            tempMonster.getHit(player.getStrength());
            tempMonster.getsoundWhenHit();
            System.out.println("The monster hits you, dealing " + tempMonster.getStrength() + " damage.");
            player.getHit(tempMonster.getStrength());
            System.out.println(player.getName() + ": " + player.getHealth() + " Healthpoints left");
            System.out.println(tempMonster.getName() + ": " + tempMonster.getHealth() + " Healthpoints left\n");
            if (player.getHealth() <= 0) {
                System.out.println("You were killed by the monster!");
                System.out.println("Game Over......\n");
                System.exit(0);
            } else if (tempMonster.getHealth() <= 0) {
                System.out.println("You killed the monster, gaining " + tempMonster.getExperience() + " experience!");
                player.giveExperience(tempMonster.getExperience());
                player.checkIfLevelUp();
                System.out.println("You are level " + player.getLevel() + ", and you have " + player.getExperience() + " experience and " + player.getHealth() + " healthpoints!");
                if (player.getLevel() == 10) {
                    System.out.println("Congratulations! You are max level and have just won over the Monsters!!!\n");
                    System.out.println("[Press Enter to close the game]");
                    sc.nextLine();
                    System.exit(0);
                }
                return;
            }
        }
    }
}
