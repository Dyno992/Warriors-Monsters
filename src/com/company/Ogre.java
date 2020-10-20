package com.company;

public class Ogre extends Monster{

    private int experience;
    private String name;
    private int level = r.nextInt(10) + 1;

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