package com.github.steleb.game;

import com.github.steleb.engine.graphics.Renderer;
import com.github.steleb.engine.graphics.Window;

public class GameContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;
    private int width = 1280, height = 720;
    private float scale = 1f;
    private String title = "Revolt-Engine v1.0";


    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    public GameContainer()
    {

    }

    public void start()
    {
        window = new Window(this);
        renderer = new Renderer(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop()
    {

    }

    public void run()
    {
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1.0e9; //Converts nanoTime into milliseconds
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(running)
        {
            render = false;

            firstTime = System.nanoTime() / 1.0e9; //Converts nanoTime into milliseconds
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                //TODO: Update game
                if(frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if(render)
            {
                renderer.clear();
                //TODO: Render game
                window.update();
                frames ++;
            }
            else
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose()
    {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public Window getWindow() {
        return window;
    }
}
