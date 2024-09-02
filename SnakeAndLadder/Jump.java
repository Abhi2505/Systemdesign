package com.SystemDesign.SnakeAndLadder;

public abstract class Jump {

     final int from;
     final int to;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public Jump(int st, int ed){
        this.from=st;
        this.to=ed;
    }

}
