package com.SystemDesign.ChessGame;

public class Queen extends  Piece{
    public Queen(boolean isWhite, boolean isKilled) {
        super(isWhite, isKilled);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }
}
