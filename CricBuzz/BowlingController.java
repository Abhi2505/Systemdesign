package com.SystemDesign.CricBuzz;

import java.util.*;

public class BowlingController {

    Deque<PlayerDetails> bowlerList;
    Map<PlayerDetails,Integer> bowlerVsOver;

    PlayerDetails currentBowler;

    BowlingController (List<PlayerDetails> bowlerList){
       setBowler(bowlerList);
    }
    public void setBowler(List<PlayerDetails> bowlerList){
        this.bowlerList=new LinkedList<>();
        bowlerVsOver=new HashMap<>();
        for(PlayerDetails pl:bowlerList){
            this.bowlerList.addLast(pl);
            this.bowlerVsOver.put(pl,0);
        }
    }

    public void getNextBowler(int maxCountPerBowler){
        PlayerDetails playerDetails=bowlerList.poll();
        if(bowlerVsOver.get(playerDetails)+1==maxCountPerBowler){
            currentBowler=playerDetails;
        }
        else{
            currentBowler=playerDetails;
            bowlerList.addLast(playerDetails);
            bowlerVsOver.put(playerDetails,bowlerVsOver.get(playerDetails)+1);
        }
    }
    public PlayerDetails getCurrentBowler(){
        return currentBowler;
    }



}
