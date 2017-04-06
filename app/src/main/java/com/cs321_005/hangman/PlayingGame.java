package com.cs321_005.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class PlayingGame extends AppCompatActivity {
    String difficulty;
    String word;
    ImageView noose;
    Button[] letters = new Button[26];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_game);
    }

    public boolean checkWord(){//checks the guessed letter against the word to be guessed
        return false;
    }

    public char voiceRecog(){//calls some voice recognition system to obtain a letter
        char finalchar= a;
        return finalchar;
    }

    public char gestureRecog(){//calls some gesture system to check the users drawn letter
        char finalchar = a;
        return finalchar;
    }

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

    public void newGame(){//allows the user to start a new game will call the difficulty screen or the main menu and begin from there

    }

    public void quit(){//method to close the application when the user wants to quit
        System.exit(0);//closes the app and returns to the android menu
    }

}
