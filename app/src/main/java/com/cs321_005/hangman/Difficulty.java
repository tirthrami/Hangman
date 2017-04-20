package com.cs321_005.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Difficulty extends AppCompatActivity {
    Button easyDifficulty;//Buttons for the three different difficulties
    Button mediumDifficulty;
    Button hardDifficulty;
    String difficultyLevel;//String that will pass the difficulty chosen to the PlayingGame Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        easyDifficulty = (Button) findViewById(R.id.easyDifficulty);
        mediumDifficulty = (Button) findViewById(R.id.mediumDifficulty);
        hardDifficulty = (Button) findViewById(R.id.hardDifficulty);

        easyDifficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent easyDifficulty = new Intent(getBaseContext(),PlayingGame.class);//intents allow you to transfer data over transfer variables over to new class
                difficultyLevel = "Easy";//User chose the Easy Difficulty
                easyDifficulty.putExtra("level",difficultyLevel);
                startActivity(easyDifficulty);
            }
        });
        mediumDifficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mediumDifficulty = new Intent(getBaseContext(),PlayingGame.class);//intents allow you to transfer data over transfer variables over to new class

                difficultyLevel = "Medium";//user chose the Medium Difficulty
                mediumDifficulty.putExtra("level",difficultyLevel);
                startActivity(mediumDifficulty);
            }
        });
        hardDifficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent hardDifficulty = new Intent(getBaseContext(),PlayingGame.class);//intents allow you to transfer data over transfer variables over to new class
                difficultyLevel = "Hard";//User chose the Hard Difficulty
                hardDifficulty.putExtra("level",difficultyLevel);//passing the String into the
                startActivity(hardDifficulty);
            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
