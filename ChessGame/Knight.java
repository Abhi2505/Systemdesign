package com.SystemDesign.ChessGame;

public class Knight extends Piece {
    public Knight(boolean isWhite, boolean isKilled) {
        super(isWhite, isKilled);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }
}
