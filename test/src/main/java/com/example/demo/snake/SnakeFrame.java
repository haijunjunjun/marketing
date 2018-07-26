package com.example.demo.snake;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeFrame extends Frame {

    public static final int BLOCK_WIDTH = 15;
    public static final int BLOCK_HEIGHT = 15;

    public static final int ROW = 40;
    public static final int COL = 40;

    private Image offScreenImage = null;

    public static void main(String[] args) {
        new SnakeFrame().launch();
        new Thread(new MyPaintThread()).start();
    }

    public void launch() {
        this.setTitle("貪吃蛇");
        this.setSize(ROW * BLOCK_WIDTH, COL * BLOCK_HEIGHT);
        this.setLocation(300, 400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(true);
        this.setVisible(true);
        new Thread(new MyPaintThread()).start();
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(color.GRAY);
        for (int i = 0; i < ROW; i++) {
            g.drawLine(0, i * BLOCK_HEIGHT, COL * BLOCK_WIDTH, i * BLOCK_HEIGHT);
        }
        for (int i = 0; i < COL; i++) {
            g.drawLine(i * BLOCK_WIDTH, 0, i * BLOCK_WIDTH, ROW * BLOCK_HEIGHT);
        }
        g.setColor(color);
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(ROW * BLOCK_HEIGHT, COL * BLOCK_WIDTH);
        }
        Graphics graphics = offScreenImage.getGraphics();
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
