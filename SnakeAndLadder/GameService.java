package com.SystemDesign.SnakeAndLadder;

import java.util.HashMap;
import java.util.List;

public class GameService {
    private static Board b;
    private List<Player>p;
    public GameService(int h,int w){
        b=Board.getInstance(h,w);
    }
    public void setPlayers(List<Player>p){
        this.p=p;
    }
    public void setSnake(HashMap<Integer,Snake>h){
        b.setSnakes(h);
    }
    public void setLadders(HashMap<Integer,Ladder>h){
        b.setLadders(h);
    }

    private boolean isPlayerLocatonBeforeLastIndex(int currInd){
        return p.get(currInd).getLocation()<b.getSize();
    }
    private  boolean doesPlayerExceedLastCell(int currIndex,int steps){
      return   p.get(currIndex).getLocation()+steps>b.getSize();
    }
    public boolean hasplayerWon(int currIdx){
        return p.get(currIdx).getLocation()==b.getSize();
    }
    private int getNextPlayerIdx(int currIdx){
        return (currIdx+1)%p.size();
    }
    public void movePlayer(int currIdx,int steps){
        p.get(currIdx).setLocation(currIdx+steps);
        HashMap<Integer,Snake>snake=b.getSnakes();
        HashMap<Integer,Ladder>ladder=b.getLadders();
        int newloc=p.get(currIdx).getLocation();
        boolean isAtSnakeLocation=snake.containsKey(newloc);
        boolean isAtLadderLocation=ladder.containsKey(newloc);
        while(isAtSnakeLocation||isAtLadderLocation){
            if(isAtSnakeLocation){
                newloc=snake.get(newloc).getTo();
            }
            else if(isAtLadderLocation){
                newloc=ladder.get(newloc).getTo();
            }
            isAtSnakeLocation=snake.containsKey(newloc);
            isAtLadderLocation=ladder.containsKey(newloc);
        }
        System.out.println(p.get(currIdx).getName()+" rolled and move to "+newloc+" and got "+steps+" in dice");
    }
    public void startGame(){
        int currplayerInd=0;
        while(isPlayerLocatonBeforeLastIndex(currplayerInd)){
            int step=DiceService.roll();
            if(doesPlayerExceedLastCell(currplayerInd,step)){
                currplayerInd=getNextPlayerIdx(currplayerInd);
                continue;
            }
            movePlayer(currplayerInd,step);
            if(hasplayerWon(currplayerInd)){
                System.out.println("The player named "+p.get(currplayerInd)+" has won");
                break;
            }
            currplayerInd=getNextPlayerIdx(currplayerInd);
        }
    }
}
