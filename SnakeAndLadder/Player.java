package com.SystemDesign.SnakeAndLadder;

import java.util.UUID;

public class Player {
    private final String id;
    private int location;
    private final String name;

    public String getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    Player(String name){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        location=0;
    }

}
