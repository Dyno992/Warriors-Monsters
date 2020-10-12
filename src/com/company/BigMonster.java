package com.company;

public class BigMonster extends Monster{

    private int bigMonsterExperience = 0;
    private int bigMonsterHealth = 0;
    private String bigMonsterName;

    public BigMonster(String name, int startingHealth, int experience) {
        super(name, startingHealth, experience);
        this.bigMonsterExperience = experience;
        this.bigMonsterHealth = startingHealth;
        this.bigMonsterName = name;
    }

    public int getBigMonsterExperience() {
        return this.bigMonsterExperience;
    }

    public int getBigMonsterHealth() {
        return this.bigMonsterHealth;
    }
}