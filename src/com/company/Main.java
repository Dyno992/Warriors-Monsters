package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
        Game game = new Game();
        game.lobby();
        game.openMenu();
    }
}



