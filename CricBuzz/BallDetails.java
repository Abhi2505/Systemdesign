package com.SystemDesign.CricBuzz;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    int ballNumber;
    BallType ballType;
    RunType runType;
    PlayerDetails playerdBy;
    PlayerDetails bowledBy;
//    public Wicket wicket;
    List<ScoreUpdateObservor> scoreUpdaterObserverList = new ArrayList<>();
    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }



}
