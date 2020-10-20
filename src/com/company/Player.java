package com.company;

public class Player {
    private String playerName = "";
    private int level = 1;
    private int experience;
    private int xpToLvlUp = 100;
    private int health = 200;
    private int strength;
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
        return 15*getLevel();
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
        this.strength =+ pot;
     }

    public void checkIfLevelUp() {
        int tempXp;
        if (experience >= xpToLvlUp){
            level++;
            tempXp = experience;
            tempXp = tempXp - 100;
            experience = 0;
            experience = tempXp;
            System.out.println("You leveled up, and are now level "+ getLevel());
        }
    }
}
