package com.company;

public class Player {
    private String playerName = "";
    private int level = 0;
    private int experience = 0;
    private int healthPoints = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerLevel() {
        return this.level;
    }

    public String getPlayerName() {
        return this.playerName;
    }
//
//    public int playerExperience(int e) {
//        return this.experience = e;
//    }

    public int getPlayerExperience() {
        return this.experience;
    }

    public int getPlayerHealthPoints() {
        return this.healthPoints;
    }
}
