package com.ske.snakebaddesign.models;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public  class Square {
    private  int position;
    private  int TYPE;
    private String label;
    private int color;
    Square(int position,String label,int color){
        this.position = position;
        this.label = label;
        this.color = color;
    }
    public int getPosition() {
        return position;
    }
    public void effect(Player p){
        // do nothing.
    }

    public int getColor(){
        return color;
    }

    public String getLabel() {
        return label;
    }
}
