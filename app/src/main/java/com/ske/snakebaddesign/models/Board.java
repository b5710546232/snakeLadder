package com.ske.snakebaddesign.models;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Board {
    private int boardSize;
    private List<Square> squareList;


    public Board(int boardSize){
        this.boardSize = boardSize;
        squareList = new ArrayList<Square>();
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                int index = j *  boardSize + i;
                Log.e("check"," index "+index + "board Size "+boardSize);

                if(index==0){
                    squareList.add(new Square(index,"START", Color.parseColor("#ff0054")));
                }
                else if(index == boardSize*boardSize-1){
                    squareList.add(new Square(index,"GOAL", Color.parseColor("#ff0054")));
                }
                else
                squareList.add(new Square(index,index+"" , Color.parseColor("#87aa4c")));

            }
        }

    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
//        view.postInvalidate();
    }

    public Square getSquare(int index){
        return squareList.get(index);
    }

    public int getBoardSize() {
        return boardSize;
    }



}
