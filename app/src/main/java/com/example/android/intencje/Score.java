package com.example.android.intencje;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 20.03.2016.
 */
public class Score {

    public String nameA;
    public int scoreA;
    public String nameB;
    public int scoreB;
    long time;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    Date today = Calendar.getInstance().getTime();

    public Score(String aName, int aScore, String bName, int bScore){
        nameA = aName;
        scoreA = aScore;
        nameB = bName;
        scoreB = bScore;
        time = System.currentTimeMillis();
    }

    @Override
    public String toString(){
        return df.format(today) + "   " + nameA + "   " + scoreA + "   -   " + nameB + "   " + scoreB;
    }
}

