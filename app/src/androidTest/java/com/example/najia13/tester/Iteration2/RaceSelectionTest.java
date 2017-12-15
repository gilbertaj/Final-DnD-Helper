package com.example.najia13.tester.Iteration2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.RaceSelection;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

//Test for checking that clicking class brings you to desired class' page

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RaceSelectionTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<RaceSelection> mActivityRule = new ActivityTestRule(RaceSelection.class);

    @Test
    public void checkHuman() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String race = "Human";
        String testRace;

        //Act
        onView(allOf(withText(race))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testRace = character.getString("Race", " ");

        //Assert
        Assert.assertEquals(race, testRace);
    }

    @Test
    public void checkGnome() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String race = "Gnome";
        String testRace;

        //Act
        onView(allOf(withText(race))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testRace = character.getString("Race", " ");

        //Assert
        Assert.assertEquals(race, testRace);
    }

    @Test
    public void checkHalfling() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String race = "Halfling";
        String testRace;

        //Act
        onView(allOf(withText(race))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testRace = character.getString("Race", " ");

        //Assert
        Assert.assertEquals(race, testRace);
    }
}