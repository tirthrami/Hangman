package com.cs321_005.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayingGame extends AppCompatActivity {
    char guessedLetter;
    String difficulty;
    String word;
    ImageView noose;
    Button[] letters = new Button[26];//below this will be setting each index to a particular button
    Button voiceButton;
    Button gestureButton;
    Button quitButton;
    Button newGame;
    TextView usedLetters;
    TextView unknownWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_game);
        letters[0] = (Button) findViewById(R.id.button_A);//starting from index 0 to 26 we go from A-Z
        letters[1] = (Button) findViewById(R.id.button_B);
        letters[2] = (Button) findViewById(R.id.button_C);
        //Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
        newGame = (Button) findViewById(R.id.NewGame);//setting the new game button to the New Game in XML
        newGame.setOnClickListener(new View.OnClickListener() {//listens for the click of the NEw Game button and starts a new game
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(),MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
        quitButton = (Button) findViewById(R.id.Quit);
        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Quit was Pressed",Toast.LENGTH_SHORT).show();
                quit();
                //System.exit(0);//closes the app and returns to the android menu
            }
        });

        letters[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed A",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'a';
                //checkWord(guessedLetter);
            }
        });
    }

    public boolean checkWord(){//checks the guessed letter against the word to be guessed
        return false;
    }

    /*public char voiceRecog(){//calls some voice recognition system to obtain a letter
        char finalchar= a;
        return finalchar;
    }

    public char gestureRecog(){//calls some gesture system to check the users drawn letter
        char finalchar = a;
        return finalchar;
    }*/

    public boolean updateWord(){//if checkWord() returns true then we update the word to be guessed
        return false;
    }

    public void updateUsedLetters(){//will remove the guessed letter from the keyboard/letters array

    }

    public int drawMan(){//this will be called when checkWord() returns a false value and will draw a piece of the character
        return 1;

    }

    public void youWin(){//if the user guesses the word before the count reaches 6 then they win

    }

    public void youLose(){//once the count reaches 6 the user is presented with this screen saying that they lost

    }

    /*public void newGame(){//allows the user to start a new game will call the difficulty screen or the main menu and begin from there
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(),MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
    }*/

    public void quit(){//method to close the application when the user wants to quit
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //System.exit(0);//closes the app and returns to the android menu
    }

}
