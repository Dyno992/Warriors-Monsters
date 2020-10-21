package com.company;

import java.io.Serializable;


public class Player implements Serializable {
    private String playerName = "";
    private int level = 1;
    private int experience;
    private int xpToLvlUp = 100;
    private int health = 200;
    private int strength = 15;
    private int playerGold;


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
        return this.strength*getLevel();
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
        if (experience >= xpToLvlUp){
            level++;
            experience -= 100;
            System.out.println("You leveled up, and are now level "+ getLevel());
        }
    }
}
