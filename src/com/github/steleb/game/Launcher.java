package com.github.steleb.game;

import com.github.steleb.game.GameContainer;

public class Launcher {

    public static void main(String args[])
    {
        GameContainer gc = new GameContainer("Revolt-Engine", 500, 500);
        gc.start();
    }
}
