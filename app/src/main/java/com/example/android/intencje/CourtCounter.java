package com.example.android.intencje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CourtCounter extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_counter);
    }

    public  void Reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void ThreePointsA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void TwoPointsA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void OnePointsA(View view) {
        scoreTeamA++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void ThreePointsB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void TwoPointsB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void OnePointsB(View view) {
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void saveScore(View view){
        Log.v("CountCounter", "start function");
        Intent list = new Intent(CourtCounter.this, CountScore.class);
        Log.v("CountCounter", "create intent");
        EditText aName = (EditText)findViewById(R.id.nameA);
        EditText bName = (EditText)findViewById(R.id.nameB);
        String nameA = aName.getText().toString();
        Log.v("CountCounter", nameA);
        String nameB = bName.getText().toString();
        Log.v("CountCounter", nameB);
        Log.v("CountCounter", Integer.toString(scoreTeamA));
        Log.v("CountCounter", Integer.toString(scoreTeamB));
        Log.v("CountCounter", "Create variables");
        /*
        Log.v("CountCounter", "save data");
        dane.putString("nameA", nameA);
        dane.putInt("scoreA", scoreA);
        dane.putString("nameB", nameB);
        dane.putInt("scoreB", scoreB);
        list.putExtras(dane);
        Log.v("CountCounter", "put Extras");
        */
        startActivity(list);
    }
}
