package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String monsterName = "";
    private int monsterLevel = 0;
    private int monsterHealthPoints = 0;


    public Monster(String name, int health) {
       // super(name, health, experience);
        this.monsterName = name;
        this.monsterHealthPoints = health;

    }
//    public List<Monster> getAllMonsters() {
//        Monster monster1 = new Monster("Jebote", 50);
//        Monster monster2 = new Monster("Dino", 50);
//        Monster monster3 = new Monster("Besim", 50);
//        List<Monster> allMonsters = new ArrayList<>();
//        allMonsters.add(monster1);
//        allMonsters.add(monster3);
//        allMonsters.add(monster2);
//        return allMonsters;
//    }

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
