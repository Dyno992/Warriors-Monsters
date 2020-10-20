package com.company;

import java.util.Random;

public class Monster {
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

    public String toString() {
        if(this.health <= 0) {
            return this.getName() + "\nThis Monster is dead";
        } else {
            return this.getName() + "\nHealth: " + getHealth() + "\nLevel: " + getLevel();
        }
    }

    public int getGold() {
        return this.gold;
    }
}
