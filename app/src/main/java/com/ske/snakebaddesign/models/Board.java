package com.ske.snakebaddesign.models;

import android.util.Log;

import com.ske.snakebaddesign.models.squares.AbstractSquare;
import com.ske.snakebaddesign.models.squares.GoalSquare;
import com.ske.snakebaddesign.models.squares.NormalSquare;
import com.ske.snakebaddesign.models.squares.RandomSquare;
import com.ske.snakebaddesign.models.squares.StartAgainSquare;
import com.ske.snakebaddesign.models.squares.StartSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Board {
    private int boardSize;
    private List<AbstractSquare> squareList;
    private static Board instance;

    public static Board getInstance(){
        if(instance == null){
            instance = new Board(Game.BOARDSIZE);
        }
        return instance;
    }
    private Board(int boardSize){
        Random random =new Random();
        int maxSize = (boardSize*boardSize);
        int positionSP1 = 1+ ( random.nextInt(maxSize/2 - 1));
        int positionSP2 = (maxSize/2)+1 + random.nextInt(maxSize/2 - 2);
        Log.e("1",""+positionSP1);
        Log.e("2",""+positionSP2);
                this.boardSize = boardSize;
        squareList = new ArrayList<AbstractSquare>();
        int position = 0;
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                int index = j *  boardSize + i;
                if(position==0){
                    squareList.add(new StartSquare(position,"START"));
                }
                else if(position == boardSize*boardSize-1){
                    squareList.add(new GoalSquare(position,"GOAL"));
                }
                else if(position==positionSP1){
                    squareList.add(new StartAgainSquare(position,positionSP1+"™"));
                }
                else if(position==positionSP2){
                    squareList.add(new RandomSquare(position,positionSP2+"™"));
                }
                else
                squareList.add(new NormalSquare(position,position+""));
                position++;

            }
        }


    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
//        view.postInvalidate();
    }

    public AbstractSquare getSquare(int index){
        return squareList.get(index);
    }

    public int getBoardSize() {
        return boardSize;
    }



}
