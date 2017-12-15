package com.example.najia13.tester;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.activities.CharacterActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Admin on 11/8/2016.
 */

public class CharacterPageTest {
    Context mContext = InstrumentationRegistry.getTargetContext();
    SharedPreferences character = mContext.getSharedPreferences("Character", 0);

    @Rule
    public ActivityTestRule<CharacterActivity> activityTestRule = new ActivityTestRule<>(CharacterActivity.class);

    @Test
    public void checkCharacterPage() throws Exception {
        onView(withId(R.id.tvStrength)).check(matches(notNullValue()));
    }

    @Test
    public void checkButtonSubtract() throws Exception {
        //Arrange
        String skill = "Strength: ";

        //Act
        onView(withId(R.id.bStrSubtract)).perform(click());
        String strength = character.getString("Strength", "0");
        String strModifier = character.getString("StrModifier", "0");

        //Assert
        onView(withId(R.id.tvStrength)).check(matches(withText(skill + strength + " (" + strModifier + ")")));
    }

    @Test
    public void checkButtonAdd() throws Exception {
        //Arrange
        String skill = "Strength: ";

        //Act
        onView(withId(R.id.bStrAdd)).perform(click());
        String strength = character.getString("Strength", "0");
        String strModifier = character.getString("StrModifier", "0");

        //Assert
        onView(withId(R.id.tvStrength)).check(matches(withText(skill + strength + " (" + strModifier + ")")));
    }
}
