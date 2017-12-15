package com.example.najia13.tester.Iteration3;

/**
 * Created by Najia13 on 11/27/2016.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.NotesActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;

public class NotesTest {

    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<NotesActivity> activityTestRule = new ActivityTestRule<>(com.example.najia13.tester.activities.NotesActivity.class);

    @Test
    public void checkName() throws Exception {
        //Arrange
        String givenString = "Name:";
        onView(ViewMatchers.withId(R.id.etNotes)).perform(replaceText(givenString));

        //Act
        onView(withId(R.id.etNotes)).perform(pressImeActionButton());

        //Assert
        onView(withId(R.id.etNotes)).check(matches(withText(givenString)));
    }

    @Test
    public void checkSave() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);

        String text = "This is a test";
        onView(withId(R.id.etNotes)).perform(replaceText(text));

        //Act
        onView(withId(R.id.saveButtonxml)).perform(click());

        //Assert
        String test = character.getString("Notes", " ");
        onView(withId(R.id.etNotes)).check(matches(withText(test)));
    }

}














