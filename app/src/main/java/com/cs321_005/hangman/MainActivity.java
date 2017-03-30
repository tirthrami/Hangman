package com.cs321_005.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button howToPlay;
    Button newGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = (Button) findViewById(R.id.newgame);
        howToPlay = (Button) findViewById(R.id.Help);
        Toast.makeText(getApplicationContext(), "Testing", Toast.LENGTH_SHORT).show();
        Log.d("GitTesting", "Test Git");
        Log.d("GitTesting", "Ahmads Test Message");
        Log.d("TestMessages", "Test2");
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent newGame = new Intent(getBaseContext(),NewGame.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(newGame);
            }
        });

        howToPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent helpScreen = new Intent(getBaseContext(),HowToPlay.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(helpScreen);
            }
        });

    }
}


