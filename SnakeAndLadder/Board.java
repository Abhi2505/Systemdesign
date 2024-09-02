package com.SystemDesign.SnakeAndLadder;

import java.util.HashMap;

public class Board {
    private int height;
    private int width;
    private static Board b;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getSize(){
        return this.height*this.width;
    }
    public static Board getInstance(int height,int width){
        if(b==null){
            b=new Board(height,width);
        }
        return b;
    }

    public void setSnakes(HashMap<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(HashMap<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }

    public HashMap<Integer, Snake> getSnakes() {
        return snakes;
    }

    public HashMap<Integer, Ladder> getLadders() {
        return ladders;
    }

    private HashMap<Integer,Snake>snakes;
    private HashMap<Integer,Ladder> ladders;
}
