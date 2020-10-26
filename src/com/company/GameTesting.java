package com.company;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GameTesting {

    @Test
    @DisplayName("Testing to create a Player")
    public void createPlayer() {
        String name = "Besim Test";
        Player p = new Player(name);
        assertEquals(name, p.getName());
    }

    @Test
    @DisplayName("Testing to Create a Monster")
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
    @DisplayName("Testing randomMonster function")
    public void getRandomMonster() {
        Random r = new Random();
        r.setSeed(3);
        List<Monster> allRandomMonsters = new ArrayList<>();
        Monster m1 = new Monster("Besim", 100, 200);
        Monster m2 = new Monster("Dino", 100, 200);
        Monster m3 = new Monster("David", 100, 200);
        allRandomMonsters.add(m1);
        allRandomMonsters.add(m2);
        allRandomMonsters.add(m3);
        Monster expectedMonster = allRandomMonsters.get(2);
        Monster actualMonster = allRandomMonsters.get(r.nextInt(allRandomMonsters.size()));
        assertEquals(expectedMonster, actualMonster);
    }

    @Test
    @DisplayName("Testing if Monster is alive or not")
    public void isMonsterAlive() {
        Monster m1 = new Monster("Besim", -50, 200);
        assertTrue(m1.getHealth() <= 0);
    }

    @Test
    @DisplayName("Testing if save & load function works propertly")
    public void saveGameAndLoadGame() throws IOException, ClassNotFoundException {
        Game game = new Game();
        List<Monster> testRandomMonsters = new ArrayList<>();
        Monster m1 = new Monster("Besim", 100, 200);
        Monster m2 = new Monster("Dino", 100, 200);
        Monster m3 = new Monster("David", 100, 200);
        testRandomMonsters.add(m1);
        testRandomMonsters.add(m2);
        testRandomMonsters.add(m3);
        Player testPlayer = new Player("testBesim");
        game.saveGame(testPlayer, testRandomMonsters);
        game.loadGame();
        assertEquals(game.player, testPlayer);
        assertEquals(game.allMonsters, testRandomMonsters);
    }
}
