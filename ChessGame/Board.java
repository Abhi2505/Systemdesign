package com.SystemDesign.ChessGame;

public class Board {
    Block[][] block;
    public Board(){
        initializeBoard();
    }
    public void initializeBoard(){
        //white pieces
        block[0][0]=new Block(0,0,new Rookie(true,false));
        block[0][1]=new Block(0,1,new Knight(true,false));
        block[0][2]=new Block(0,2,new Bishop(true,false));
        block[0][3]=new Block(0,3,new Queen(true,false));
        block[0][4]=new Block(0,4,new King(true,false));
        block[0][5] = new Block(0,5,new Bishop(true,false));
        block[0][6] = new Block(0,6,new Knight(true,false));
        block[0][7] = new Block(0,7,new Rookie(true,false));
        for(int j=0; j<8 ; j++){
            block[1][j] = new Block(1,j,new Pawn(true,false));
        }
        //black piece
        block[7][0] = new Block(7,0,new Rookie(false,true));
        block[7][1] = new Block(7,1,new Knight(false,true));
        block[7][2] = new Block(7,2,new Bishop(false,true));
        block[7][3] = new Block(7,3,new Queen(false,true));
        block[7][4] = new Block(7,4,new King(false,true));
        block[7][5] = new Block(7,5,new Bishop(false,true));
        block[7][6] = new Block(7,6,new Knight(false,true));
        block[7][7] = new Block(7,7,new Rookie(false,true));
        for(int j=0; j<8 ; j++){
            block[6][j] = new Block(6,j,new Pawn(false,false));
        }
        for(int i=2;i<6;i++){
            for( int j=0; j<8; j++){
                block[i][j] = new Block(i,j,null);
            }
        }


    }
}
