package com.example.android.intencje;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CountScore extends AppCompatActivity {

    static ArrayList<Score> listItems = new ArrayList<Score>();
    private ArrayAdapter<Score> adapter;
    private Bundle score;
    private Intent backIntent;
    private Score element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_score);
        backIntent = this.getIntent();
        score = backIntent.getExtras();
        add(score);
        sendAnswer();
        show();
    }

    private void add(Bundle result){
        element = new Score(score.getString("nameA"), score.getInt("scoreA"), score.getString("nameB"), score.getInt("scoreB"));
        listItems.add(element);
    }
    private void show(){
        ListView list = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<Score>(this, R.layout.row,listItems);
        list.setAdapter(adapter);
    }
    private void sendAnswer(){
        String wynik = element.scoreA == element.scoreB ? "remis" : element.scoreA > element.scoreB ? element.nameA + " wygrał" : element.nameB + " wygrał";
        score.putString("wynik", wynik);
        backIntent.putExtras(score);
        setResult(Activity.RESULT_OK, backIntent);
    }

    public void back(View view){
        finish();
    }
}
