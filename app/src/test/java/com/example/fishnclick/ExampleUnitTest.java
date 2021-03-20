package com.example.fishnclick;
import org.junit.Rule;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void levelUp_isCorrect(){
        int fishValue = 1;
        Fish bar = new Fish("Bar", fishValue, R.drawable.fish1);
        bar.levelUp();
        assertEquals(bar.getLevel(),1);
    }

}