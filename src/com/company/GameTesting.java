package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GameTesting {

    @Test
    public void createPlayer() {

        String name = "Besim Test";
        Player p = new Player(name);
        assertEquals(name, p.getName());

    }

    @Test
    public void createMonster() {
        String name = "Monster Test";
        int health = 100;
        int experience = 20;
        Monster m = new Monster(name, health, experience);
        assertEquals(name, m.getName());
        assertEquals(health, m.getHealth());
        assertEquals(experience, m.getExperience());
    }

    @Test
    public void getRandomMonster() {    // denna funkar EJJJJJJJJJJ
        Random r = new Random();
        r.setSeed(2);
        List<Monster> allRandomMonsters = new ArrayList<>();
        Monster m1 = new Monster("Besim", 100, 200);
        Monster m2 = new Monster("Dino", 100, 200);
        Monster m3 = new Monster("David", 100, 200);
        allRandomMonsters.add(m1);
        allRandomMonsters.add(m2);
        allRandomMonsters.add(m3);
        Monster tempMonster = allRandomMonsters.get(r.nextInt(allRandomMonsters.size()));
        assertEquals(tempMonster, tempMonster.getName());
        assertEquals(tempMonster, tempMonster.getHealth());
        assertEquals(tempMonster, tempMonster.getExperience());
    }
}
