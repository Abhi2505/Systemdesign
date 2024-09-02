package com.SystemDesign.ChessGame;

public class Bishop extends Piece{
    public Bishop(boolean isWhite, boolean isKilled) {
        super(isWhite, isKilled);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }
}
