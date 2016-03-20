package com.example.android.intencje;

/**
 * Created by admin on 20.03.2016.
 */
public class Score {

    public String nameA;
    public int scoreA;
    public String nameB;
    public int scoreB;
    long time;

    public Score(String aName, int aScore, String bName, int bScore){
        nameA = aName;
        scoreA = aScore;
        nameB = bName;
        scoreB = bScore;
        time = System.currentTimeMillis();
    }

    @Override
    public String toString(){
        return time + "   " + nameA + "   " + scoreA + "   -   " + nameB + "   " + scoreB;
    }
}

