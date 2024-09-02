package com.SystemDesign.CricBuzz;

import java.util.Date;
import java.util.Random;

public class Match {
    Team teamA;
    Team teamB;
    String Venue;

    public Match(Team teamA, Team teamB, String venue, MatchType matchType, Team tosswinner, InningDetails[] inningDetails, Date matchdate) {
        this.teamA = teamA;
        this.teamB = teamB;
        Venue = venue;
        this.matchType = matchType;
        this.tosswinner = tosswinner;
        this.inningDetails = inningDetails;
        this.matchdate = matchdate;
    }

    MatchType matchType;
    Team tosswinner;
    InningDetails[] inningDetails;

    Date matchdate;
    public void startMatch(){
        tosswinner=toss(teamA,teamB);
        //winning team will always choose batting
        for(int inning=1;inning<=2;inning++){
                InningDetails innning;
                Team BattingTeam;
                Team BowlingTeam;
                BattingTeam=tosswinner;
                BowlingTeam=tosswinner.getName().equals(teamA.getName())?teamA:teamB;
                inningDetails =new InningDetails[2];
        }


    }
    public Team toss(Team a,Team b){
        Random rand=new Random();
        return rand.nextInt(2)==0?teamA:teamB;
    }
}
