package com.SystemDesign.CricBuzz;

public class OneDayMatchType implements MatchType {
    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxOverPerBowler() {
        return 10;
    }
}
