package com.ske.snakebaddesign.models.squares;

import android.graphics.Color;

import com.ske.snakebaddesign.models.Game;
import com.ske.snakebaddesign.models.Player;

/**
 * Created by nattapat on 3/15/2016 AD.
 */
public class GoalSquare extends AbstractSquare {
    private final int color = Color.parseColor("#ee6283");
    public GoalSquare(int position , String label){
        super(position, label);
    }

    @Override
    public boolean checkEffect(Player p) {
        return true;
    }

    @Override
    public void getEffect(Player p) {

//        Game.getInstance().setWinner(p.getName());
        Game.getInstance().reset();
    }

    public int getColor() {
        return color;
    }

    @Override
    public String effectMessage(Player p) {
        return p.getName()+" won !";
    }

    @Override
    public String effectTitile(Player p) {
        return "Game Over !!!";
    }


}
