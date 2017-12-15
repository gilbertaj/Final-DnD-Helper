package com.example.najia13.tester.Iteration2;

/**
 * Created by Najia13 on 11/8/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

import com.example.najia13.tester.activities.MainActivity;

import junit.framework.Assert;

@RunWith(AndroidJUnit4.class)

public class SpellsActivityTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkAcidSplash() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "AcidSplash";

        //Act
        editor.putBoolean(spell, true);
        editor.commit();
        onView(allOf(withText("Spells"))).perform(click());

        //Assert
        Assert.assertEquals(character.getBoolean(spell, false), true);
    }

    @Test
    public void checkDelayPoison() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "DelayPotion";

        //Act
        editor.putBoolean(spell, true);
        editor.commit();
        onView(allOf(withText("Spells"))).perform(click());

        //Assert
        Assert.assertEquals(character.getBoolean(spell, false), true);
    }

    @Test
    public void checkDetectMagic() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "DetectMagic";

        //Act
        editor.putBoolean(spell, true);
        editor.commit();
        onView(allOf(withText("Spells"))).perform(click());

        //Assert
        Assert.assertEquals(character.getBoolean(spell, false), true);
    }

}
