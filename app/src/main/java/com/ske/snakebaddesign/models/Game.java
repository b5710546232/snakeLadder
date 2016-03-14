package com.ske.snakebaddesign.models;

import android.util.Log;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Die die;
    private int turn;

    public Game(){
        initComponents();
    }

    private void initComponents() {
        player1 = new Player("P1");
        player2 = new Player("P2");
        die = new Die();
        board = new Board(64);
        turn = 0;

    }
    public void  resetGame(){

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
    public void checkWin(){

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
        board.setBoardSize(8);
        turn = 0;
    }
}
