package com.ske.snakebaddesign.models.squares;

import android.graphics.Color;
import android.util.Log;

import com.ske.snakebaddesign.models.Player;

/**
 * Created by nattapat on 3/15/2016 AD.
 */
public class StartAgainSquare extends AbstractSquare {
    private final int color  = Color.parseColor("#f07508");
    public StartAgainSquare(int position , String label){
        super(position,label);
    }

    @Override
    public boolean checkEffect(Player p) {
        return true;
    }


    @Override
    public void getEffect(Player p) {
        // go to start;
        Log.e("effect","ok");
        p.setPostion(0);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public String effectMessage(Player p) {
        return "You will go to starter point :p";
    }

    @Override
    public String effectTitile(Player p) {
        return "Oh God you are bad luck";
    }
}
