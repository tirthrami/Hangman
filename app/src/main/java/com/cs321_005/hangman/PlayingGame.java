package com.cs321_005.hangman;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import android.view.View.OnClickListener;
import android.view.View;
import android.app.Activity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class PlayingGame extends AppCompatActivity implements OnClickListener {
    String TAG = "PlayingGame";
    char guessedLetter;
    String difficulty;
    String word;
    ImageView noose;
    Button[] letters = new Button[26];//below this will be setting each index to a particular button
    Button voiceButton;
    Button gestureButton;
    Button quitButton;
    Button newGame;
    TextView usedLetters, unknownWord, tvGuessedWord;
    String testword = "";
    int guessesRemaining = 6;
    Context context = this;

    int[] letterID = {R.id.button_A, R.id.button_B, R.id.button_C, R.id.button_D, R.id.button_E, R.id.button_F, R.id.button_G,
            R.id.button_H, R.id.button_I, R.id.button_J, R.id.button_K, R.id.button_L, R.id.button_M, R.id.button_N, R.id.button_O,
            R.id.button_P, R.id.button_Q, R.id.button_R, R.id.button_S, R.id.button_T, R.id.button_U, R.id.button_V, R.id.button_W,
            R.id.button_X, R.id.button_Y, R.id.button_Z};

    protected static final int REQUEST_OK = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_game);

        Intent intent = getIntent();
        difficulty = intent.getStringExtra("level");
        /**
         * Initialize Alphabet Buttons
         */
        for(int i =0; i < letters.length; i++){
            letters[i] = (Button) findViewById(letterID[i]);
        }

        voiceButton = (Button) findViewById(R.id.button_voice);
        voiceButton.setOnClickListener(this);
        gestureButton = (Button) findViewById(R.id.Gesture);

        //Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
        newGame = (Button) findViewById(R.id.NewGame);//setting the new game button to the New Game in XML
        tvGuessedWord = (TextView) findViewById(R.id.textView_guess);

        testword = getRandWord(difficulty);

        String blankString = getBlankString(testword);
        tvGuessedWord.setText(blankString);//replace testword with whatever the actual value is



        newGame.setOnClickListener(new View.OnClickListener() {//listens for the click of the NEw Game button and starts a new game
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(), MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
        quitButton = (Button) findViewById(R.id.Quit);
        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(TAG, "Quit was Pressed");
                quit();
                //System.exit(0);//closes the app and returns to the android menu
            }
        });

        letters[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed A", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'a';
                checkWord(guessedLetter);
            }
        });
        letters[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed B", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'b';
                checkWord(guessedLetter);
            }
        });

        letters[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed C", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'c';
                checkWord(guessedLetter);
            }
        });
        letters[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed D", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'd';
                checkWord(guessedLetter);
            }
        });

        letters[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed E", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'e';
                checkWord(guessedLetter);
            }
        });
        letters[5].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed F", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'f';
                checkWord(guessedLetter);
            }
        });
        letters[6].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed G", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'g';
                checkWord(guessedLetter);
            }
        });
        letters[7].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed H", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'h';
                checkWord(guessedLetter);
            }
        });
        letters[8].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed I", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'i';
                checkWord(guessedLetter);
            }
        });
        letters[9].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed J", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'j';
                checkWord(guessedLetter);
            }
        });
        letters[10].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed K", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'k';
                checkWord(guessedLetter);
            }
        });
        letters[11].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed L", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'l';
                checkWord(guessedLetter);
            }
        });
        letters[12].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed M", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'm';
                checkWord(guessedLetter);
            }
        });
        letters[13].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed N", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'n';
                checkWord(guessedLetter);
            }
        });
        letters[14].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed O", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'o';
                checkWord(guessedLetter);
            }
        });
        letters[15].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed P", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'p';
                checkWord(guessedLetter);
            }
        });
        letters[16].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed Q", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'q';
                checkWord(guessedLetter);
            }
        });
        letters[17].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed R", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'r';
                checkWord(guessedLetter);
            }
        });
        letters[18].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed S", Toast.LENGTH_SHORT).show();
                char guessedLetter = 's';
                checkWord(guessedLetter);
            }
        });
        letters[19].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed T", Toast.LENGTH_SHORT).show();
                char guessedLetter = 't';
                checkWord(guessedLetter);
            }
        });
        letters[20].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed U", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'u';
                checkWord(guessedLetter);
            }
        });
        letters[21].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed V", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'v';
                checkWord(guessedLetter);
            }
        });
        letters[22].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed W", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'w';
                checkWord(guessedLetter);
            }
        });
        letters[23].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed X", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'x';
                checkWord(guessedLetter);
            }
        });
        letters[24].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed Y", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'y';
                checkWord(guessedLetter);
            }
        });
        letters[25].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Pressed Z", Toast.LENGTH_SHORT).show();
                char guessedLetter = 'z';
                checkWord(guessedLetter);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            startActivityForResult(i, REQUEST_OK);
        } catch (Exception e) {
            Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
        }
    }
    /* Part of the voice recognition. need to change this
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_OK  && resultCode==RESULT_OK) {
            ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ((TextView)findViewById(R.id.text1)).setText(thingsYouSaid.get(0));
        }
    }
*/
    private String getBlankString(String testword) {
        String blank = "";
        for (int i = 0; i < testword.length(); i++) {
            blank += "_";
        }
        return blank;
    }

    public boolean checkWord(char letterCheck) {//checks the guessed letter against the word to be guessed

        if (testword.indexOf(letterCheck) != -1) {
            Log.d(TAG, "Letter is in word");
            String currentGuess = getReplacedWord(testword, letterCheck);
            tvGuessedWord.setText(currentGuess);
            checkWordComplete(currentGuess);
            return true;
        } else {
            Log.d(TAG, "Letter is not in word");
            drawMan();
            return false;
        }
    }

    private void checkWordComplete(String currentGuess) {
        if(!currentGuess.contains("_")) youWin();
    }

    private String getReplacedWord(String testword, char letterCheck) {
        char[] current = tvGuessedWord.getText().toString().toCharArray();
        for (int i = 0; i < testword.length(); i++) {
            if (testword.charAt(i) == letterCheck) {
                current[i] = letterCheck;
            }
        }
        return String.valueOf(current);
    }


    /*public char voiceRecog(){//calls some voice recognition system to obtain a letter
        char finalchar= a;
        return finalchar;
    }

    public char gestureRecog(){//calls some gesture system to check the users drawn letter
        char finalchar = a;
        return finalchar;
    }*/


    public void updateUsedLetters() {//will remove the guessed letter from the keyboard/letters array

    }

    public int drawMan() {//this will be called when checkWord() returns a false value and will draw a piece of the character
        guessesRemaining--;
        //drawing the actual hangman picture piece by piece

        if (guessesRemaining == 0) {
            youLose();
        }
        Toast.makeText(getApplicationContext(), "You Have " + guessesRemaining + " Guesses Remaining", Toast.LENGTH_SHORT).show();
        return guessesRemaining;

    }

    public void youWin() {//if the user guesses the word before the count reaches 6 then they win
        Toast.makeText(context,"YOU WIN!", Toast.LENGTH_SHORT).show();

    }

    public void youLose() {//once the count reaches 6 the user is presented with this screen saying that they lost
        Toast.makeText(context,"YOU Lose :(", Toast.LENGTH_SHORT).show();
    }

    /*public void newGame(){//allows the user to start a new game will call the difficulty screen or the main menu and begin from there
        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(),MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
    }*/

    public void quit() {//method to close the application when the user wants to quit
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //System.exit(0);//closes the app and returns to the android menu
    }

    public String getRandWord(String difficulty) {
        String[] array;
        switch(difficulty){
            case "Easy":
                array = context.getResources().getStringArray(R.array.easy_word_array);
                 return array[new Random().nextInt(array.length)];
            case "Medium":
                array = context.getResources().getStringArray(R.array.medium_word_array);
                return array[new Random().nextInt(array.length)];
            case "Hard":
                array = context.getResources().getStringArray(R.array.hard_word_array);
                return array[new Random().nextInt(array.length)];
        }
        return "";
    }
}
