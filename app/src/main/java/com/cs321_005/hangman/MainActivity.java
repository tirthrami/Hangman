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
    Button difficultyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultyButton = (Button) findViewById(R.id.difficultyButton);
        howToPlay = (Button) findViewById(R.id.Help);

        difficultyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent difficulty = new Intent(getBaseContext(),Difficulty.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(difficulty);
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


