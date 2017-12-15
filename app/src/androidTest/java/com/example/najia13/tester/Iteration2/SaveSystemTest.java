package com.example.najia13.tester.Iteration2;

/**
 * Created by Najia13 on 10/5/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.MainActivity;

import junit.framework.Assert;

@RunWith(AndroidJUnit4.class)

public class SaveSystemTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkNameSave() throws Exception {
        //Arrange
        String test = "Name";
        SharedPreferences Character = mContext.getSharedPreferences("Character", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Character.edit();

        //Act
        editor.putString(test, "Hello World");
        editor.commit();
        onView(allOf(withText("Character"))).perform(click());

        //Assert
        onView(ViewMatchers.withId(R.id.tvCharacter)).check(matches(withText(Character.getString(test, " "))));
    }

    @Test
    public void checkAgeSave() throws Exception {
        //Arrange
        String test = "Age";
        String age = "24";
        SharedPreferences character = mContext.getSharedPreferences("Character", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = character.edit();

        //Act
        editor.putString(test, age);
        editor.commit();
        onView(allOf(withText("Character"))).perform(click());

        //Assert
        Assert.assertEquals(character.getString("Age", " "), age);
    }

    @Test
    public void checkAlignmentSave() throws Exception {
        //Arrange
        String test = "Alignment";
        String alignment = "Lawful Neutral";
        SharedPreferences character = mContext.getSharedPreferences("Character", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = character.edit();

        //Act
        editor.putString(test, alignment);
        editor.commit();
        onView(allOf(withText("Character"))).perform(click());

        //Assert
        Assert.assertEquals(character.getString("Alignment", " "), alignment);
    }
}
