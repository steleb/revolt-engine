package com.github.steleb.game;

import com.github.steleb.engine.graphics.Window;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class GameContainer implements Runnable
{

    private Window window;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public GameContainer(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init()
    {
        window = new Window(title, width, height);
    }

    private void tick()
    {

    }

    private void render()
    {
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        // Clear Screen
        g.clearRect(0,0, width, height);

        // Draw start

        // Draw end
        bs.show();
        g.dispose();
    }

    public void run()
    {
        init();

        while(running)
        {
            tick();
            render();

        }
        stop();
    }

    public synchronized  void start()
    {
        if(running)
        {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if(!running)
        {
            return;
        }

        running = false;

        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
