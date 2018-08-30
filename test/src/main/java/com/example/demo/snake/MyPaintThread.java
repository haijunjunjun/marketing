package com.example.demo.snake;

import java.awt.*;

public class MyPaintThread extends Frame implements Runnable {
    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
