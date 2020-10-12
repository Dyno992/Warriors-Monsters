package com.company;

public class Monster extends BigMonster {
    private String monsterName = "";
    private int monsterLevel = 0;

    private int monsterHealthPoints = 0;

    Monster monster1 = new Monster("Jebote", 50, 10);
    Monster monster2 = new Monster("Dino", 50, 10);
    Monster monster3 = new Monster("Besim", 50, 10);

    public Monster(String name, int health, int experience) {
        super(name, health, experience);
//        this.monsterName = name;
//        this.monsterHealthPoints = health;
    }

    public String getMonsterName() {
        return this.monsterName;
    }

    public int monsterLevel(int l) {
        return this.monsterLevel = l;
    }

    public int monsterHealthPoints(int h) {
        return this.monsterHealthPoints = h;
    }
}
