package com.example.najia13.tester.Iteration2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.FeatSelection;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by root on 11/9/16.
 */
public class FeatSelectionTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<FeatSelection> mActivityRule = new ActivityTestRule(FeatSelection.class);

    @Test
    public void checkDualWielding() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String feat = "Dual Wielding";
        Boolean isSelected;

        //Act
        onView(allOf(withText(feat))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean("DualWielding", false);

        //Assert
        Assert.assertTrue(isSelected);
    }

    @Test
    public void checkPointBlankShot() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String feat = "Point Blank Shot";
        Boolean isSelected;

        //Act
        onView(allOf(withText(feat))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean("PointBlankShot", false);

        //Assert
        Assert.assertTrue(isSelected);
    }

    @Test
    public void checkInitiativeBonus() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String feat = "Initiative Bonus";
        Boolean isSelected;

        //Act
        onView(allOf(withText(feat))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean("InitiativeBonus", false);

        //Assert
        Assert.assertTrue(isSelected);
    }
}