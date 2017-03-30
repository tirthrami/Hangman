package com.cs321_005.hangman;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

       Button easyDifficulty = (Button) findViewById(R.id.Difficulty);
        Button mediumDifficulty = (Button) findViewById(R.id.Difficulty);
        Button hardDifficulty = (Button) findViewById(R.id.Difficulty);




    }

}
