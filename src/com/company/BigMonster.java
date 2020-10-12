package com.company;

public class BigMonster extends Monster{

    private int experience;
    private String name;
    private int level;

    public BigMonster(String name, int startingHealth, int experience) {
        super(name, startingHealth);
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getLevel() {
        return this.level;
    }

}