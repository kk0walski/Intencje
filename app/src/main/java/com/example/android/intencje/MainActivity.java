package com.example.android.intencje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void coffeeOrder(View vew){
        Intent order = new Intent(MainActivity.this, JustJava.class);
        startActivity(order);
    }

    public void playMatch(View view){
        Intent match = new Intent(MainActivity.this, CourtCounter.class);
        startActivity(match);
    }
}
