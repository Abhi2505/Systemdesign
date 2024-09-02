package com.SystemDesign.ChessGame;

public class Move {
    Block startBlock;
    Block endBlock;

    public Move(Block startblock, Block endblock) {
        this.startBlock = startblock;
        this.endBlock = endblock;
    }
    public boolean isValid(){
        return !(startBlock.getPiece().isWhite == endBlock.getPiece().isWhite);
    }
    public Block getStartBlock() {
        return startBlock;
    }
    public Block getEndBlock() {
        return endBlock;
    }
}
