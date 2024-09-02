package com.SystemDesign.ChessGame;

public class Pawn extends Piece{
    public Pawn(boolean isWhite, boolean isKilled) {
        super(isWhite, isKilled);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }
}
