package com.ske.snakebaddesign.models.squares;

import com.ske.snakebaddesign.models.Player;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public abstract class AbstractSquare {
    private String label;
    private int position;

    AbstractSquare(int position, String label){

        this.position = position;
        this.label = label;
    }

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public abstract boolean checkEffect(Player p);
    public abstract void getEffect(Player p);

    public String getLabel() {
        return label;
    }
    public abstract  int getColor();

    public abstract  String effectMessage(Player p);
    public abstract  String effectTitile(Player p);
}
