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
    Button easyDifficulty;
    Button mediumDifficulty;
    Button hardDifficulty;
    String difficultyLevel;
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
                //Add in the intent.extra to pass the correct String into the

                difficultyLevel = "Easy";
                easyDifficulty.putExtra("Easy",difficultyLevel);
                startActivity(easyDifficulty);
            }
        });
        mediumDifficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mediumDifficulty = new Intent(getBaseContext(),PlayingGame.class);//intents allow you to transfer data over transfer variables over to new class

                difficultyLevel = "Medium";
                mediumDifficulty.putExtra("Medium",difficultyLevel);
                startActivity(mediumDifficulty);
            }
        });
        hardDifficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent hardDifficulty = new Intent(getBaseContext(),PlayingGame.class);//intents allow you to transfer data over transfer variables over to new class
                difficultyLevel = "Hard";
                hardDifficulty.putExtra("Hard",difficultyLevel);
                startActivity(hardDifficulty);
            }
        });

    }

}
