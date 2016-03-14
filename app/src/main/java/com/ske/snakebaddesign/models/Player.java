package com.ske.snakebaddesign.models;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Player {
    private String name;
    private int postion;

    public Player(String name){
        this.name = name;
    }
    public void setPostion(int postion) {
        this.postion = postion;
    }

    public int getPostion() {
        return postion;
    }

    public String getName() {
        return name;
    }
}
