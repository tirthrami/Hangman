package com.cs321_005.hangman;

import org.junit.Test;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class HangmanUnitTests {
    @Test
    public void blankStringT1() throws Exception {
        assertEquals(PlayingGame.getBlankString("hello"),"_____");
        assertEquals(PlayingGame.getBlankString(""),"");
    }

    @Test(expected = NullPointerException.class)
    public void blankStringT2() throws Exception {
        PlayingGame.getBlankString(null);
    }

}