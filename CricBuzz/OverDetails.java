package com.SystemDesign.CricBuzz;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {
    int overNumber;
    List<BallDetails> balls;
    int extraBallcount;
    PlayerDetails bowledBy;
    OverDetails(int overNumber,PlayerDetails bowledBy){
        this.overNumber=overNumber;
        this.bowledBy=bowledBy;
        this.balls=new ArrayList<>();
    }
    public void startOver(Team Batting,Team Bowling,int runsToWin){
        int ballcount=1;
        while(ballcount<=6){
            BallDetails ball=new BallDetails(ballcount);

            balls.add(ball);

        }

    }

}
