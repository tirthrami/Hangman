package com.cs321_005.hangman;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import android.view.View.OnClickListener;
import android.view.View;
import android.app.Activity;
import android.gesture.*;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

@TargetApi(Build.VERSION_CODES.DONUT)
public class PlayingGame extends AppCompatActivity implements OnGesturePerformedListener {
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
    GestureLibrary gLib; //Collection of saved gestures for letters a-z
    ViewFlipper viewFlipper;
    GestureOverlayView gOverlay;

    int[] letterID = {R.id.button_A, R.id.button_B, R.id.button_C, R.id.button_D, R.id.button_E, R.id.button_F, R.id.button_G,
            R.id.button_H, R.id.button_I, R.id.button_J, R.id.button_K, R.id.button_L, R.id.button_M, R.id.button_N, R.id.button_O,
            R.id.button_P, R.id.button_Q, R.id.button_R, R.id.button_S, R.id.button_T, R.id.button_U, R.id.button_V, R.id.button_W,
            R.id.button_X, R.id.button_Y, R.id.button_Z};

    char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

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
            final int j = i;
            letters[i] = (Button) findViewById(letterID[i]);
            letters[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkWord(alpha[j]);
                }
            });
        }
        noose = (ImageView) findViewById(R.id.iv_noose);
        voiceButton = (Button) findViewById(R.id.button_voice);
        gestureButton = (Button) findViewById(R.id.Gesture);
        quitButton = (Button) findViewById(R.id.Quit);
        newGame = (Button) findViewById(R.id.NewGame);//setting the new game button to the New Game in XML
        tvGuessedWord = (TextView) findViewById(R.id.textView_guess);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);//animator used to switch between keyboard and gestures
        gOverlay = (GestureOverlayView) findViewById(R.id.gOverlay);//view where gestures will be made

        gOverlay.addOnGesturePerformedListener(this);//creates a gesture listener to check for gestures on this overlay

        gLib = GestureLibraries.fromRawResource(context, R.raw.gestures);
        gLib.load();//Loads the gestures to the gesture library



        testword = getRandWord(difficulty);
        //testword = "bee";
        String blankString = getBlankString(testword);
        tvGuessedWord.setText(blankString);//replace testword with whatever the actual value is



        newGame.setOnClickListener(new View.OnClickListener() {//listens for the click of the NEw Game button and starts a new game
            public void onClick(View view) {
                Intent NewGame = new Intent(getBaseContext(), MainActivity.class);//intents allow you to transfer data over transfer variables over to new class
                startActivity(NewGame);
            }
        });
        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(TAG, "Quit was Pressed");
                quit();
                //System.exit(0);//closes the app and returns to the android menu
            }
        });

        voiceButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                try {
                    startActivityForResult(i, REQUEST_OK);
                } catch (Exception e) {
                    Toast.makeText(context, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
                }
            }
        });




        //Switches view from keyboard to gesture mode
        //once gesture is made on gesture overlay, gesture listener is called
        gestureButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                viewFlipper.setDisplayedChild(1);
            }
        });



    }


    //Called when a gesture is made on gesture overlay
    //recognizes gestures and calls checkWord with letter made with gestures
    //Returns back to keyboard view after gesture is made
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = gLib.recognize(gesture);


        char letter = predictions.get(0).name.charAt(0);
        checkWord(letter);
        viewFlipper.setDisplayedChild(0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_OK  && resultCode==RESULT_OK) {
            ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            guessedLetter = thingsYouSaid.get(0).charAt(0);

            //accounts for letters that sound like words
            //ISSUE: can't recognize letter 'e' for some reason
            if(thingsYouSaid.get(0).equals("see"))
                guessedLetter = 'c';
            else if(thingsYouSaid.get(0).equals("why"))
                guessedLetter = 'y';
            else if(thingsYouSaid.get(0).equals("are"))
                guessedLetter = 'r';
            else if(thingsYouSaid.get(0).equals("you"))
                guessedLetter = 'u';

            checkWord(guessedLetter);
        }
    }

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


    public int drawMan() {//this will be called when checkWord() returns a false value and will draw a piece of the character
        guessesRemaining--;
        //drawing the actual hangman picture piece by piece

        switch(guessesRemaining){
            case 5:
                noose.setBackgroundResource(R.drawable.a1);
                break;
            case 4:
                noose.setBackgroundResource(R.drawable.a2);
                break;
            case 3:
                noose.setBackgroundResource(R.drawable.a3);
                break;
            case 2:
                noose.setBackgroundResource(R.drawable.a4);
                break;
            case 1:
                noose.setBackgroundResource(R.drawable.a5);
                break;
            case 0:
                noose.setBackgroundResource(R.drawable.a6);
                youLose();
                break;
            default:
                youLose();
                break;
        }
        Toast.makeText(getApplicationContext(), "You Have " + guessesRemaining + " Guesses Remaining", Toast.LENGTH_SHORT).show();
        return guessesRemaining;//need to add the actual drawing of the stick man here...

    }

    public void youWin() {//if the user guesses the word before the count reaches 6 then they win
        Toast.makeText(context,"YOU WIN!", Toast.LENGTH_SHORT).show();
        Intent homeScreen = new Intent(getBaseContext(),MainActivity.class);//returns you to the main menu once you win.
        startActivity(homeScreen);

    }

    public void youLose() {//once the count reaches 6 the user is presented with this screen saying that they lost
        Toast.makeText(context,"YOU Lose :(", Toast.LENGTH_SHORT).show();
        Intent homeScreen = new Intent(getBaseContext(),MainActivity.class);//intent to reutrn to main menu once you lose
        startActivity(homeScreen);
    }


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
