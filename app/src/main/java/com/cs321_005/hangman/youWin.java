package com.cs321_005.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class youWin extends AppCompatActivity {
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_youwin);
        ok = (Button) findViewById(R.id.winOk);
        ok.setOnClickListener(new View.OnClickListener() {//listens for the click of the NEw Game button and starts a new game
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(), MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
