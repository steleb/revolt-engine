package com.github.steleb.engine.graphics;

import com.github.steleb.game.GameContainer;

import java.awt.image.DataBufferInt;

public class Renderer
{
    private int pixelW, pixelH;
    private int[] pixel;

    public Renderer(GameContainer gc)
    {
        pixelW = gc.getWidth();
        pixelH = gc.getHeight();
        pixel = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();

    }

    public void clear()
    {
        for(int i = 0; i < pixel.length; i++)
        {
            pixel[i] += i;
        }
    }
}
