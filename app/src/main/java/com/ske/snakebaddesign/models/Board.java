package com.ske.snakebaddesign.models;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Board {
    private View view;
    private int boardSize;
    private List<Square> squareList;


    public Board(int boardSize){
        this.boardSize = boardSize;
        squareList = new ArrayList<Square>();
        for(int i = 0 ;i<boardSize*boardSize;i++){
            squareList.add(new Square(i));
        }
    }

//    private void drawSquares(Canvas canvas) {
//
//        for(int i = 0; i < boardSize; i++) {
//            for(int j = 0; j < boardSize; j++) {
//                float startX = i * cellSize + padding/2;
//                float startY = j * cellSize + padding/2;
//                float endX = startX + cellSize - padding;
//                float endY = startY + cellSize - padding;
//                paint.setColor(colorCell);
//                canvas.drawRect(startX, startY, endX, endY, paint);
//                paint.setColor(colorText);
//                String label = (j *  boardSize + i + 1) + "";
//                canvas.drawText(label, startX + cellSize/2 - padding/2, startY + cellSize/2, paint);
//            }
//        }
//    }
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
//        view.postInvalidate();
    }

    public int getBoardSize() {
        return boardSize;
    }
}
