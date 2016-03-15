package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by nattapat on 3/10/2016 AD.
 */
public class Die {
    public static Die instance;
    private int value;
    public static final int MAX_VALUE = 6;
    public static final int MIN_VALUE = 1;

    private Random random;

    public static  Die getInstance(){
        if(instance==null){
            instance = new Die();
        }
        return instance;
    }

    private Die(){
        random = new Random();
    }
    public void roll(){
        value = MIN_VALUE+random .nextInt(MAX_VALUE);
    }

    public int getValue(){
        return value;
    }
}
