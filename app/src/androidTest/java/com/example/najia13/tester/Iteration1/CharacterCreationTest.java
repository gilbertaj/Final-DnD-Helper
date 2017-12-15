package com.example.najia13.tester.Iteration1;

/**
 * Created by sbane on 10/11/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.CreateCharacterActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

public class CharacterCreationTest {

    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<CreateCharacterActivity>activityTestRule = new ActivityTestRule<>(CreateCharacterActivity.class);

    @Test
    public void launchCharacterCreator() throws Exception {
        //Arrange
        String givenString = "Name:";

        //Act

        //Assert
        onView(withId(R.id.tvName)).check(matches(withText(givenString)));
    }

    @Test
    public void checkName() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String text = "This is a test";

        //Act
        onView(withId(R.id.etName)).perform(replaceText(text));
        onView(withId(R.id.bSave)).perform(click());
        String testName = character.getString("Name", " ");

        //Assert
        Assert.assertEquals(testName, text);
    }

    @Test
    public void checkClass() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String charClass = "Barbarian";
        String testClass;

        //Act
        onView(withId(R.id.bSave)).perform(click());
        onView(allOf(withText(charClass))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testClass = character.getString("Class", " ");

        //Assert
        Assert.assertEquals(charClass, testClass);
    }
}
