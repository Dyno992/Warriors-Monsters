package com.company;

public class Monster {
    private String monsterName = "";
    private int monsterLevel = 0;
    private int monsterExperience = 0;
    private int monsterHealthPoints = 0;

    public Monster(String monsterName, int startingHealth) {
        this.monsterName = monsterName;
        this.monsterHealthPoints = startingHealth;
    }
    public int monsterLevel(int l) {
        return this.monsterLevel = l;
    }

    public int monsterExperience(int e) {
        return this.monsterExperience = e;
    }

    public int monsterHealthPoints(int h) {
        return this.monsterHealthPoints = h;
    }
}
