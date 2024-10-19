package com.SystemDesign.TicTacToe;

public class Board {
    int size;
    Cell[][] board;
    Board(int sz){
        this.size=sz;
        board=new Cell[sz][sz];
        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){
                board[i][j]=new Cell();
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j].cellSymbol!=CellSymbol.NULL){
                    System.out.print(board[i][j].cellSymbol+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public boolean addAtPosition(int x,int y,CellSymbol symbol){
        if(x>=0&&y<size&&board[x][y].cellSymbol.equals(CellSymbol.NULL)){
            board[x][y].cellSymbol=symbol;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkFreeCells(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j].cellSymbol.equals(CellSymbol.NULL)){
                    return true;
                }
            }
        }
        return false;
    }

}
