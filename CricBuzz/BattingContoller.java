package com.SystemDesign.CricBuzz;

import java.util.LinkedList;
import java.util.Queue;

public class BattingContoller {

    Queue<PlayerDetails>yettoPlay;
    PlayerDetails striker;
    PlayerDetails nonstiker;

    public PlayerDetails getStriker() {
        return striker;
    }

    public void setStriker(PlayerDetails striker) {
        this.striker = striker;
    }

    public PlayerDetails getNonstiker() {
        return nonstiker;
    }

    public void setNonstiker(PlayerDetails nonstiker) {
        this.nonstiker = nonstiker;
    }

    public BattingContoller(Queue<PlayerDetails>playing11){
    this.yettoPlay=new LinkedList<>();
    this.yettoPlay.addAll(playing11);
   }

    public void getNextPlayer()throws Exception{
       if(yettoPlay.isEmpty()){
           throw new Exception();
       }
       if(striker==null){
           striker=yettoPlay.poll();
       }
       if(nonstiker==null){
           nonstiker=yettoPlay.poll();
       }

    }
}
