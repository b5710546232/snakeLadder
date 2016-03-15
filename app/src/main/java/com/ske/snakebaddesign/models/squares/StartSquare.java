package com.ske.snakebaddesign.models.squares;

import android.graphics.Color;

import com.ske.snakebaddesign.models.Player;

/**
 * Created by nattapat on 3/15/2016 AD.
 */
public class StartSquare extends AbstractSquare {

    private final int color = Color.parseColor("#59b32d");
    public StartSquare(int position , String label){
        super(position,label);
    }

    @Override
    public boolean checkEffect(Player p) {
        return false;
    }

    @Override
    public void getEffect(Player p) {
        // do nothing
    }

    public int getColor() {
        return color;
    }

    @Override
    public String effectMessage(Player p) {
        return null;
    }

    @Override
    public String effectTitile(Player p) {
        return null;
    }

}
