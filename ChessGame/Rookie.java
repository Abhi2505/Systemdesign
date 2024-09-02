package com.SystemDesign.ChessGame;

public class Rookie extends Piece{
    public Rookie(boolean isWhite, boolean isKilled) {
        super(isWhite, isKilled);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }
}
