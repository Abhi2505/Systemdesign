package com.SystemDesign.CricBuzz;

public class BattingScoreUpdater implements ScoreUpdateObservor{

    @Override
    public void update(BallDetails ballDetails) {
        int run=0;
        if(RunType.ONE==ballDetails.runType){
            run=1;
        }
        if(RunType.TWO==ballDetails.runType){
            run=2;
        }
        if(RunType.FOUR==ballDetails.runType){
            run=4;
        }
        if(RunType.SIX==ballDetails.runType){
            run=6;
        }


    }
}
