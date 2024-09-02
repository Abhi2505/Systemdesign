package com.SystemDesign.SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameService gameService=new GameService(5,5);

        Player p1=new Player("abhinav");
        Player p2=new Player("ram");
        Player p3=new Player("Arjun");
        Player p4=new Player("Karan");
        List<Player> pl=new ArrayList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        pl.add(p4);

        Ladder l1=new Ladder(4,12);
        Ladder l2=new Ladder(24,70);
        Ladder l3=new Ladder(45,67);
        Ladder l4=new Ladder(80,90);

        HashMap<Integer,Ladder> ladder=new HashMap<>();
        ladder.put(4,l1);
        ladder.put(24,l1);
        ladder.put(45,l1);
        ladder.put(80,l1);
        gameService.setLadders(ladder);
        gameService.setPlayers(pl);

        HashMap<Integer,Snake>snake=new HashMap<>();
        Snake s1=new Snake(99,34);
        Snake s2=new Snake(17,6);
        Snake s3=new Snake(47,15);
        Snake s4=new Snake(69,6);
        snake.put(99,s1);
        snake.put(17,s2);
        snake.put(47,s3);
        snake.put(69,s4);
        gameService.setSnake(snake);

        gameService.startGame();
    }
}
