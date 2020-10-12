package com.company;

public class Player {
    private String playerName = "";
    private int level = 1;
    private int experience = 0;
    private int health = 200;
    private int strength;

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

    public int getHealth() {
        return this.health;
    }
    
    public int getStrength() {
        return 10+getLevel();
    }

    public void getHit(int hit) {
        this.health -= hit;
    }
    
}
