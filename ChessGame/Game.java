package com.SystemDesign.ChessGame;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;

    Status status;
    boolean isWhiteTurn=true;

    public void start(){
        Player p1=new Player("ram");
        Player p2=new Player("shyam");
        while(status==Status.ACTIVE){
            if(isWhiteTurn){
                //user will give input to move to which block ;
                int x1=0;
                int y1=0;
                int nx1=0;
                int ny1=0;

                //makeMove(new Move(new Block(x1,y1,peice),new Block(nx1,ny1,peice),p1));
            }
            else{
                int x2=0;
                int y2=0;
                int nx2=0;
                int ny2=0;
                //  makeMove(new Move(new Block(x2,y2,piece),new Block(nx2,ny2,peice),p2));
            }
        }
    }
    public void makeMove(Move move,Player player){
        if(move.isValid()){ //move valid means ki destination par same colour ke log agar h toh ie an invalid move
            Piece sp=move.getStartBlock().getPiece();
            if(sp.canMove(this.board,move.getStartBlock(),move.getEndBlock())){//can move would check ki us type ke chesspiece ki chal valid h ki nai
                Piece dp=move.getEndBlock().getPiece();
                //ham already varify krchuke  ki destination me different colour piece rhega
                if(dp instanceof King && isWhiteTurn){
                    this.status=Status.WHITEWIN;
                }
                else if(dp instanceof  King && !isWhiteTurn){
                    this.status=Status.BLACKWIN;
                }
                dp.setKilled(true);
            }
            move.getEndBlock().setPiece(sp);
            move.getStartBlock().setPiece(null);
            isWhiteTurn=!isWhiteTurn;
        }
    }
}
