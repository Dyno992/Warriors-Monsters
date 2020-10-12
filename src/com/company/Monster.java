package com.company;

public class Monster extends BigMonster {
    private String monsterName = "";
    private int monsterLevel = 0;

    private int monsterHealthPoints = 0;

    public Monster(String name, int health) {
        super(name, health);
//        this.monsterName = name;
//        this.monsterHealthPoints = health;
    }
    public int monsterLevel(int l) {
        return this.monsterLevel = l;
    }

    public int monsterHealthPoints(int h) {
        return this.monsterHealthPoints = h;
    }
}
