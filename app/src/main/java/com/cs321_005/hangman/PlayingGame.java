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
    String testword ="a";
    int guessesRemaining = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_game);
        letters[0] = (Button) findViewById(R.id.button_A);//starting from index 0 to 26 we go from A-Z
        letters[1] = (Button) findViewById(R.id.button_B);
        letters[2] = (Button) findViewById(R.id.button_C);
        letters[3] = (Button) findViewById(R.id.button_D);
        letters[4] = (Button) findViewById(R.id.button_E);
        letters[5] = (Button) findViewById(R.id.button_F);
        letters[6] = (Button) findViewById(R.id.button_G);
        letters[7] = (Button) findViewById(R.id.button_H);
        letters[8] = (Button) findViewById(R.id.button_I);
        letters[9] = (Button) findViewById(R.id.button_J);
        letters[10] = (Button) findViewById(R.id.button_K);
        letters[11] = (Button) findViewById(R.id.button_L);
        letters[12] = (Button) findViewById(R.id.button_M);
        letters[13] = (Button) findViewById(R.id.button_N);
        letters[14] = (Button) findViewById(R.id.button_O);
        letters[15] = (Button) findViewById(R.id.button_P);
        letters[16] = (Button) findViewById(R.id.button_Q);
        letters[17] = (Button) findViewById(R.id.button_R);
        letters[18] = (Button) findViewById(R.id.button_S);
        letters[19] = (Button) findViewById(R.id.button_T);
        letters[20] = (Button) findViewById(R.id.button_U);
        letters[21] = (Button) findViewById(R.id.button_V);
        letters[22] = (Button) findViewById(R.id.button_W);
        letters[23] = (Button) findViewById(R.id.button_X);
        letters[24] = (Button) findViewById(R.id.button_Y);
        letters[25] = (Button) findViewById(R.id.button_Z);
        voiceButton = (Button) findViewById(R.id.button_voice);
        gestureButton = (Button) findViewById(R.id.Gesture);

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
                checkWord(guessedLetter);
            }
        });
        letters[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed B",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'b';
                checkWord(guessedLetter);
            }
        });

        letters[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed C",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'c';
                checkWord(guessedLetter);
            }
        });
        letters[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed D",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'd';
                checkWord(guessedLetter);
            }
        });

        letters[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed E",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'e';
                checkWord(guessedLetter);
            }
        });
        letters[5].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed F",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'f';
                checkWord(guessedLetter);
            }
        });
        letters[6].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed G",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'g';
                checkWord(guessedLetter);
            }
        });
        letters[7].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed H",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'h';
                checkWord(guessedLetter);
            }
        });
        letters[8].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed I",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'i';
                checkWord(guessedLetter);
            }
        });
        letters[9].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed J",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'j';
                checkWord(guessedLetter);
            }
        });
        letters[10].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed K",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'k';
                checkWord(guessedLetter);
            }
        });
        letters[11].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed L",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'l';
                checkWord(guessedLetter);
            }
        });
        letters[12].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed M",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'm';
                checkWord(guessedLetter);
            }
        });
        letters[13].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed N",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'n';
                checkWord(guessedLetter);
            }
        });
        letters[14].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed O",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'o';
                checkWord(guessedLetter);
            }
        });
        letters[15].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed P",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'p';
                checkWord(guessedLetter);
            }
        });
        letters[16].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed Q",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'q';
                checkWord(guessedLetter);
            }
        });
        letters[17].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed R",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'r';
                checkWord(guessedLetter);
            }
        });
        letters[18].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed S",Toast.LENGTH_SHORT).show();
                char guessedLetter = 's';
                checkWord(guessedLetter);
            }
        });
        letters[19].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed T",Toast.LENGTH_SHORT).show();
                char guessedLetter = 't';
                checkWord(guessedLetter);
            }
        });
        letters[20].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed U",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'u';
                checkWord(guessedLetter);
            }
        });
        letters[21].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed V",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'v';
                checkWord(guessedLetter);
            }
        });
        letters[22].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed W",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'w';
                checkWord(guessedLetter);
            }
        });
        letters[23].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed X",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'x';
                checkWord(guessedLetter);
            }
        });
        letters[24].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed Y",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'y';
                checkWord(guessedLetter);
            }
        });
        letters[25].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button Pressed Z",Toast.LENGTH_SHORT).show();
                char guessedLetter = 'z';
                checkWord(guessedLetter);
            }
        });















    }

    public boolean checkWord(char letterCheck){//checks the guessed letter against the word to be guessed

        if(testword.indexOf(letterCheck)!=-1){
            Toast.makeText(getApplicationContext(), "Letter is in Word", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(),"Letter Is not in Word",Toast.LENGTH_LONG).show();
            drawMan();
            return false;
        }
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
        guessesRemaining--;
        //drawing the actual hangman picture piece by piece

        if(guessesRemaining==0){
            youLose();
        }
            Toast.makeText(getApplicationContext(), "You Have "+guessesRemaining+" Guesses Remaining", Toast.LENGTH_SHORT).show();
            return guessesRemaining;

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
