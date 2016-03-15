package com.ske.snakebaddesign.models;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Game {
    public static Game instance;
    private Board board;
    private Player player1;
    private Player player2;
    private Die die;
    private int turn;
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
        if(player1.getPostion() == dest){
            return  true;
        }
        else if(player2.getPostion() == dest ){
            return true;
        }
        return false;
    }

    public boolean checkSquareEffect(){
        if(turn%2==0){
            return board.getSquare(player1.getPostion()).checkEffect(player1);
        }
        else return board.getSquare(player2.getPostion()).checkEffect(player2);
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

    public int getTurn() {
        return turn;
    }

    public void nextTurn(){
        this.turn++;
    }

    public void reset(){
        player1.setPostion(0);
        player2.setPostion(0);
        board.setBoardSize(BOARDSIZE);
        turn = 0;
    }

    public String getDialogTitle() {

        if(board.getSquare(player1.getPostion()).checkEffect(player1)){
           return board.getSquare(player1.getPostion()).effectTitile(player1);
        }
        else
        if(board.getSquare(player2.getPostion()).checkEffect(player2)){
            return board.getSquare(player2.getPostion()).effectTitile(player2);
        }
        return "";
    }



    public String getDialogMsg() {

        if(board.getSquare(player1.getPostion()).checkEffect(player1)){
            return board.getSquare(player1.getPostion()).effectMessage(player1);
        }
        else
        if(board.getSquare(player2.getPostion()).checkEffect(player2)){
            return board.getSquare(player2.getPostion()).effectMessage(player2);
        }
        return "";

    }


}
