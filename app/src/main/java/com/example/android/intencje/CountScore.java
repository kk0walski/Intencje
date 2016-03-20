package com.example.android.intencje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CountScore extends AppCompatActivity {

    private ArrayList<Score> listItems = new ArrayList<Score>();
    private ArrayAdapter<Score> adapter;
    private Bundle score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_score);
        score = this.getIntent().getExtras();
        add(score);
        show();
    }

    private void add(Bundle result){
        Score element = new Score(score.getString("nameA"), score.getInt("scoreA"), score.getString("nameB"), score.getInt("scoreB"));
        listItems.add(element);
    }
    private void show(){
        ListView list = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<Score>(this, R.layout.row,listItems);
        list.setAdapter(adapter);
    }

    public void back(View view){
        Intent intencja = new Intent(CountScore.this, CourtCounter.class);
        startActivity(intencja);
    }
}
