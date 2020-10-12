package com.company;

public class BigMonster extends Monster{

    private int bigMonsterExperience;
    private int bigMonsterHealth;
    private String bigMonsterName;

    public BigMonster(String name, int startingHealth, int experience) {
        super(name, startingHealth);

    }

    public int getBigMonsterExperience() {
        return this.bigMonsterExperience;
    }

    public int getBigMonsterHealth() {
        return this.bigMonsterHealth;
    }
}