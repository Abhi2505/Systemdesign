package com.SystemDesign.TicTacToe;

public class Player {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(CellSymbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public CellSymbol getSymbol() {
        return symbol;
    }

    CellSymbol symbol;
    Player(String name,CellSymbol symbol){
        this.name=name;
        this.symbol=symbol;
    }
}
