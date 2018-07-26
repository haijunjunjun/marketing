package com.example.demo.snake;

import java.awt.*;

public class Node {

    private static final int BLOCK_WIDTH = SnakeFrame.BLOCK_WIDTH;
    private static final int BLOCK_HEIGHT = SnakeFrame.BLOCK_HEIGHT;

    private int row;
    private int col;

    private Direction dir;

    private Node pre;
    private Node next;

    public Node(int row, int col, Direction dir) {
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    public void draw (Graphics g){
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillRect(col*BLOCK_WIDTH,row*BLOCK_HEIGHT,BLOCK_WIDTH,BLOCK_HEIGHT);
        g.setColor(color);
    }
}
