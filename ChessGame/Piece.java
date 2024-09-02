package com.SystemDesign.ChessGame;

public abstract class Piece {
    boolean isWhite;
    boolean isKilled;

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public Piece(boolean isWhite, boolean isKilled) {
        this.isWhite = isWhite;
        this.isKilled = isKilled;
    }
    abstract public boolean canMove(Board board, Block start,Block end);
}
