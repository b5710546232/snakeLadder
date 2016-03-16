package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Game {
    private static Game instance;
    private Board board;
    private Player player1;
    private Player player2;
    private List<Player> players;
    private Die die;
    private int turn;
    private int indexCurrentPlayer;
    public static final int BOARDSIZE = 6;
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
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        die = Die.getInstance();
        board = Board.getInstance();
        turn = 0;

    }


    public void rollDice(){
        die.roll();
    }

    public Die getDie(){
        return die;
    }


    public boolean checkWin(){
        int dest = board.getBoardSize() * board.getBoardSize() - 1;
        if(getCurrentPlayer().getPostion()==dest)return true;
        return false;
    }

    public Player getCurrentPlayer(){
        return players.get(turn%players.size());
    }

    public boolean checkSquareEffect(){
        return board.getSquare(getCurrentPlayer().getPostion()).checkEffect(getCurrentPlayer());
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

    public void nextTurn(){
        this.turn++;
    }

    public void reset(){
        for(Player p : players){
            p.setPostion(0);
        }
        board.setBoardSize(BOARDSIZE);
        turn = 0;
    }

    public String getDialogTitle() {
        return board.getSquare(getCurrentPlayer().getPostion()).effectTitile(getCurrentPlayer());
    }

    public String getDialogMsg() {
        return board.getSquare(getCurrentPlayer().getPostion()).effectMessage(getCurrentPlayer());

    }
    public int getTurn(){
        return  turn;
    }


}
