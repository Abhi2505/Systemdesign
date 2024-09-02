package com.SystemDesign.CricBuzz;

import java.util.ArrayList;
import java.util.List;

public class InningDetails {
    Team BattingTeam;
    Team BowlingTeam;
    MatchType matchType;
    List<OverDetails>overs;

    public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        BattingTeam = battingTeam;
        BowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overDetailsList=new ArrayList<>();
    }

    public void start(int runstpWin){
        int totalOver=matchType.noOfOvers();
        for(int over=1;over<=totalOver;over++){
            BowlingTeam.chooseNextBowler(matchType.maxOverPerBowler());
            OverDetails currover=new OverDetails(over,BowlingTeam.getCurrentBowler());
            overs.add(currover);

        }
    }
    List<OverDetails> overDetailsList;
}
