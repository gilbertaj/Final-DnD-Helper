package com.example.najia13.tester.Iteration1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.ClassSelection;

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
public class ClassSelectionTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<ClassSelection> mActivityRule = new ActivityTestRule(ClassSelection.class);

    @Test
    public void checkBarbarian() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String charClass = "Barbarian";
        String testClass;

        //Act
        onView(allOf(withText(charClass))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testClass = character.getString("Class", " ");

        //Assert
        Assert.assertEquals(charClass, testClass);
    }

    @Test
    public void checkCleric() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String charClass = "Cleric";
        String testClass;

        //Act
        onView(allOf(withText(charClass))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testClass = character.getString("Class", " ");

        //Assert
        Assert.assertEquals(charClass, testClass);
    }

    @Test
    public void checkMonk() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String charClass = "Monk";
        String testClass;

        //Act
        onView(allOf(withText(charClass))).perform(click());
        onView(withId(R.id.yes)).perform(click());
        testClass = character.getString("Class", " ");

        //Assert
        Assert.assertEquals(charClass, testClass);
    }
}