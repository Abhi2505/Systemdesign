package com.SystemDesign.TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;
    public Game(){
        players=new LinkedList<>() ;
        Player p1=new Player("Abhinav",CellSymbol.X);
        Player p2=new Player("Ram",CellSymbol.O);
        board=new Board(3);
        players.add(p1);
        players.add(p2);
    }
    public String startGame(){
        boolean isWinner=false;
        while(!isWinner){
            Player p1=players.removeFirst();
            board.printBoard();
            boolean SpaceAvailable=board.checkFreeCells();
            if(!SpaceAvailable){
                break;
            }
            System.out.println("Player "+p1.getName()+" Enter the position : " );
            Scanner sc=new Scanner(System.in);
            String pos=sc.nextLine();
            String ar[]=pos.split(" ");
            int row=Integer.parseInt(ar[0]);
            int col=Integer.parseInt(ar[1]);
            boolean validPosition=board.addAtPosition(row,col,p1.getSymbol());
            if(!validPosition){
                System.out.println("Please enter valid position");
                players.addFirst(p1);
                continue;
            }
            players.addLast(p1);
            boolean winner=isWinner(row,col,p1.getSymbol());
            if(winner){
                return p1.getName();
            }
        }
        return "Match TIE";
    }
    public boolean isWinner(int row,int col ,CellSymbol cellSymbol){
        boolean rowwin=true;
        boolean colwin=true;
        boolean diagonalwin=true;
        boolean antidiagonalwin=true;
        for(int i=0;i<board.size;i++){
            if(!board.board[row][i].cellSymbol.equals(cellSymbol)){
                rowwin=false;
                break;
            }
        }
        for(int i=0;i<board.size;i++){
            if(!board.board[i][col].cellSymbol.equals(cellSymbol)){
                colwin=false;
                break;
            }
        }
        for(int i=0,j=0;i<board.size;i++,j++){
            if(!board.board[i][j].cellSymbol.equals(cellSymbol)){
                diagonalwin=false;
            }
        }
        for(int i=0,j=board.size-1;i<board.size;i++,j--){
            if(!board.board[i][j].cellSymbol.equals(cellSymbol)){
                antidiagonalwin=false;
                break;
            }
        }
        return rowwin||colwin||diagonalwin||antidiagonalwin;
    }
    public static void main(String[] args) {
        Game game=new Game();
        String gamestatus=game.startGame();
        if(!gamestatus.equals("Match TIE")){
            System.out.println(" "+gamestatus+" wins !!");
        }
        else
            System.out.println(" "+gamestatus);
    }

}
