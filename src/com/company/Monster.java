package com.company;

public class Monster {
    private String monsterName = "";
    private int level = 0;
    private int experience = 0;
    private int healthPoints = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }
    public int playerLevel(int l) {
        return this.level = l;
    }

    public int playerExperienc(int e) {
        return this.experience = e;
    }

    public int playerhealthPoints(int h) {
        return this.healthPoints = h;
    }
}
}
