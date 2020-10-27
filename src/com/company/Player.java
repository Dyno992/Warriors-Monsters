package com.company;

import java.io.Serializable;


public class Player implements Serializable {
    private String playerName = "";
    private int level = 1;
    private int experience;
    private int health = 100;
    private int strength = 15;
    private int playerGold;

    // text colors
    public static final String tColor_GREEN = "\u001B[32m";
    public static final String tbColor_RESET = "\u001B[0m";
    public static final String tColor_PURPLE = "\u001B[35m";
    // text background color
    public static final String bColor_GREEN = "\u001B[42m";

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.playerName;
    }

    public int getExperience() {
        return this.experience;
    }

    public void giveExperience(int xp) {
        this.experience += xp;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength * getLevel();
    }

    public void getHit(int hit) {
        this.health -= hit;
    }

    public void lootGold(int gold) {
        this.playerGold += gold;
    }

    public int getGold() {
        return this.playerGold;
    }

    public void useGold(int gold) {
        this.playerGold -= gold;
    }

    public void useHealthPotion(int pot) {
        this.health = pot;
    }

    public void useStrengthPotion(int pot) {
        this.strength = this.strength + pot;
    }

    public void checkIfLevelUp() {
        int xpToLvlUp = 100;
        if (experience >= xpToLvlUp) {
            level++;
            experience -= 100;
            if(experience >= xpToLvlUp){
                level++;
                experience -= 100;
            }
            System.out.println("You leveled up, and are now level " + getLevel());
        }
    }

    public boolean checkIfMaxLevel() {
        boolean endGame = false;
        if (getLevel() == 10 || getLevel() > 10) {
            System.out.println("\n" + tColor_GREEN + "Congratulations!" + tbColor_RESET + " You are max level and have just won the game!!!");
            System.out.println(bColor_GREEN + tColor_PURPLE +"YOU WIN !!!!!!!!!!!!!" + tbColor_RESET + "\n");
            System.out.println("[Press Enter to see the remaining monsters and credits]");
            endGame = true;
        }
        return endGame;
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    public boolean equals(Object player) {
        Player p1 = (Player) player;
        return this.playerName.equals(p1.playerName);
    }
}