package com.ske.snakebaddesign.models.squares;

import android.graphics.Color;

import com.ske.snakebaddesign.models.Board;
import com.ske.snakebaddesign.models.Player;

import java.util.Random;

/**
 * Created by nattapat on 3/15/2016 AD.
 */
public class RandomSquare extends AbstractSquare {

    private Random random;
    private static final int MAX_VALUE = Board.getInstance().getBoardSize()*Board.getInstance().getBoardSize() - 5;
    private static final int MIN_VALUE = 2;
    private final int color = Color.parseColor("#981e82");
    private int value;
    public RandomSquare(int position,String label){
        super(position,label);
        random = new Random();
    }

    @Override
    public boolean checkEffect(Player p) {
        return true;
    }

    @Override
    public void getEffect(Player p) {
        p.setPostion(value);
    }
    public void getRandom(){
        value = MIN_VALUE+random .nextInt(MAX_VALUE);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public String effectMessage(Player p) {
        getRandom();
        return "Your position will get a random.\nGo to "+value;
    }

    @Override
    public String effectTitile(Player p) {
        return "You are in the twisted dimension";
    }
}
