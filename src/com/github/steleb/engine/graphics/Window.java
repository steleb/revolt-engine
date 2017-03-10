package com.github.steleb.engine.graphics;

import javax.swing.JFrame;
import java.awt.*;


public class Window {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width;
    private int height;


    public Window(String title, int width, int height)
    {
       this.title = title;
       this.width = width;
       this.height = height;

       createWindow();
    }

    private void createWindow()
    {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas() {
        return canvas;
    }

}
