package com.example.android.intencje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CountScore extends AppCompatActivity {

    private ArrayList<Score> listItems=new ArrayList<Score>();
    private Bundle score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_score);
        score = this.getIntent().getExtras();

    }

    private void add(Bundle result){
        Score element = new Score(score.getString("nameA"), score.getInt("scoreA"), score.getString("nameB"), score.getInt("scoreB"));
        listItems.add(element);
    }
}
