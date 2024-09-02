package com.SystemDesign.CricBuzz;

import com.SystemDesign.SnakeAndLadder.Player;

import java.util.List;
import java.util.Queue;

public class Team {
    String name;
    List<PlayerDetails> benchplayers;
    Queue<PlayerDetails> q;
    BattingContoller bc;

    BowlingController bwlc;
    boolean isWinner;
    public PlayerDetails getCurrentBowler() {
        return  bwlc.getCurrentBowler();
    }

    public Team(String name, List<PlayerDetails> benchplayers, Queue<PlayerDetails> q, BattingContoller bc, BowlingController bwlc) {
        this.name = name;
        this.benchplayers = benchplayers;
        this.q = q;
        this.bc = bc;
        this.bwlc = bwlc;
    }

    public String getName() {
        return name;
    }
    public void chooseNextBatsman() throws Exception {
        bc.getNextPlayer();
    }
    public void chooseNextBowler(int maxoverperplayer){
        bwlc.getNextBowler(maxoverperplayer);
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerDetails> getBenchplayers() {
        return benchplayers;
    }

    public void setBenchplayers(List<PlayerDetails> benchplayers) {
        this.benchplayers = benchplayers;
    }

    public Queue<PlayerDetails> getQ() {
        return q;
    }

    public void setQ(Queue<PlayerDetails> q) {
        this.q = q;
    }

    public BattingContoller getBc() {
        return bc;
    }

    public void setBc(BattingContoller bc) {
        this.bc = bc;
    }

    public BowlingController getBwlc() {
        return bwlc;
    }

    public void setBwlc(BowlingController bwlc) {
        this.bwlc = bwlc;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }



}
