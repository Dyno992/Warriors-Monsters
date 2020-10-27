package com.company;

import java.io.Serializable;
import java.util.Random;

public class Monster implements Serializable {

    // text colors
    public static final String tbColor_RESET = "\u001B[0m";
    public static final String tColor_RED = "\u001B[31m";

    Random r = new Random();
    private String name;
    private String call = "URGHHH * SLuRp * ";
    private int health;
    private int strength;
    private int level = r.nextInt(10) + 1;
    private int experience;
    private int gold = r.nextInt(20) + 1;

    public Monster(String name, int health, int experience) {
        this.name = name;
        this.health = health;
        this.experience = experience;
    }

    public String getName() {
        return this.name;
    }
    public void getsoundWhenHit(String message) {
        System.out.println(this.name + ": " + message);
    }
    public void getsoundWhenHit() {
        getsoundWhenHit(call);
    }

    public int getHealth() {
        return this.health;
    }

    public void getHit(int hit) {
        this.health -= hit;
    }

    public int getLevel(){
        return this.level;
    }

    public int getStrength() {
        return 5+getLevel();
    }

    public int getExperience() {
        return this.experience;
    }

    public int getGold() {
        return this.gold;
    }

    @Override
    public String toString() {
        if(this.health <= 0) {
            return this.getName() + "\n" + tColor_RED + "This Monster is dead" + tbColor_RESET;
        } else {
            return this.getName() + "\nHealth: " + getHealth() + "\nLevel: " + getLevel();
        }
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    @Override
    public boolean equals(Object monster) {
        Monster m1 = (Monster) monster;
        return m1.name.equals(this.name) &&
                m1.level == this.level &&
                m1.health == this.health &&
                m1.experience == this.experience &&
                m1.gold == this.gold &&
                m1.strength == this.strength;
    }
}
