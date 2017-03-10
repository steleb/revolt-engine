package com.github.steleb.game;

import com.github.steleb.engine.graphics.Window;

public class GameContainer {

    private Window window;
    public int width, height;

    public GameContainer(String title, int width, int height)
    {
        this.width = width;
        this.height = height;

        window = new Window(title, width, height);
    }

}
