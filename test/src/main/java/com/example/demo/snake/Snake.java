package com.example.demo.snake;

import java.awt.*;

public class Snake {

    private Node head = null;
    private Node tail = null;

    private SnakeFrame sf;

    private Node node = new Node(3, 4, Direction.D);

    private int size = 0;

    public Snake(SnakeFrame sf) {
        head = node;
        tail = node;
        size++;
        this.sf = sf;
    }

    public void draw (Graphics g){
        if (head == null){
            return ;
        }
//        for (Node node = head;node!=null;node = node){
//            node.draw(g);
//        }
    }
}
