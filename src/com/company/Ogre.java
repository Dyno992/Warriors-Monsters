package com.company;

public class Ogre extends Monster{

    private int experience;
    private String name;
    private int level;

    public Ogre(String name, int startingHealth, int experience) {
        super(name, startingHealth, experience);
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getLevel() {
        return this.level;
    }

}