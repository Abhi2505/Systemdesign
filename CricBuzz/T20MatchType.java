package com.SystemDesign.CricBuzz;

public class T20MatchType implements   MatchType{
    @Override
    public int noOfOvers() {
        return 20;
    }

    @Override
    public int maxOverPerBowler() {
        return 5;
    }
}
