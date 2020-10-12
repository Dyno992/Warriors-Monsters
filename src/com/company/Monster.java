package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String monsterName = "";
    private int monsterLevel = 0;
    private int monsterHealthPoints = 0;
    private int monsterExperience = 0;
    Monster monster1 = new Monster("Jebote", 50, 10);
    Monster monster2 = new Monster("Dino", 50, 10);
    Monster monster3 = new Monster("Besim", 50, 10);

    public Monster(String name, int health, int experience) {
       // super(name, health, experience);
        this.monsterName = name;
        this.monsterHealthPoints = health;
        this.monsterExperience = experience;
    }
    public List<Monster> getAllMonsters() {
        Monster monster1 = new Monster("Jebote", 50, 10);
        Monster monster2 = new Monster("Dino", 50, 10);
        Monster monster3 = new Monster("Besim", 50, 10);
        List<Monster> allMonsters = new ArrayList<>();
        allMonsters.add(monster1);
        allMonsters.add(monster3);
        allMonsters.add(monster2);
        return allMonsters;
    }

    public String getMonsterName() {
        return this.monsterName;
    }

    public int monsterLevel() {
        return this.monsterLevel;
    }

    public int monsterHealthPoints() {
        return this.monsterHealthPoints;
    }
}
