package com.company;

public class Dragon extends Monster {

    private int experience;
    private String name;
    private int level = r.nextInt(10) + 1;
    private int gold = r.nextInt(20) + 1;

    public Dragon(String name, int startingHealth, int experience) {
        super(name, startingHealth, experience);
        this.experience = experience;
    }

    @Override
    public int getExperience() {
        return this.experience;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getGold() {
        return this.gold;
    }
}
