package com.SystemDesign.SnakeAndLadder;

import java.util.Random;

public class DiceService {
    static final int MAX_RAND=6;
    public static int  roll(){
        Random r=new Random();
        return 1+r.nextInt(MAX_RAND);
    }
}
