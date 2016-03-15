package com.ske.snakebaddesign.models;

import android.util.Log;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Game {
    public static Game instance;
    private Board board;
    private Player player1;
    private Player player2;
    private String winner;
    private Die die;
    private int turn;
    private final int BOARDSIZE = 4;

    private Game(){
        initComponents();

    }

    public static Game getInstance(){
        if(instance==null){
            instance = new Game();
        }
        return instance;
    }

    private void initComponents() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        die = new Die();
        board = new Board(BOARDSIZE);
        turn = 0;

    }


    public void rollDice(){
//        p.roll();
//        int value = p.getDieValue();
//            String title = p.getName()+" rolled a die";
//            String msg = p.getName()+" got " + value;
//            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    moveCurrentPiece(value);
//                    dialog.dismiss();
//                }
//            };
//            displayDialog(title, msg, listener);
        die.roll();

    }

    public Die getDie(){
        return die;
    }

    public void moveCurrentPiece(){

    }

    public String getWinner(){
        if(checkWin()) return  winner;
        return null;
    }

    public boolean checkWin(){
        int dest = board.getBoardSize() * board.getBoardSize() - 1;
        if(player1.getPostion() == dest){
            winner = player1.getName();
            return  true;
        }
        else if(player2.getPostion() == dest ){
            winner = player2.getName();
            return true;
        }
        return false;
    }

    public void checkSquare(){

    }


    private int adjustPosition(int current, int distance) {
        current = current + distance;
        int maxSquare = board.getBoardSize() * board.getBoardSize() - 1;
        if(current > maxSquare) {
            current = maxSquare - (current - maxSquare);
        }
        return current;
    }

    public void movePlayer(Player p ,int distance){
        p.setPostion(adjustPosition(p.getPostion(),distance));
        Log.e(p.getName(),p.getPostion()+"");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn(){
        this.turn++;
        Log.e("nexturn"," call ");
    }

    public void reset(){
        player1.setPostion(0);
        player2.setPostion(0);
        board.setBoardSize(BOARDSIZE);
        winner = "";
        turn = 0;
    }
}
