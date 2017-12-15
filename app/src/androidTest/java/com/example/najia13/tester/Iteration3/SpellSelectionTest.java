package com.example.najia13.tester.Iteration3;

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
 * Created by sbane on 12/4/2016.
 */

public class SpellSelectionTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<FeatSelection> mActivityRule = new ActivityTestRule(FeatSelection.class);

    @Test
    public void checkMaze() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "Maze";
        Boolean isSelected;

        //Act
        editor.putString("Class", "Rogue");
        editor.commit();
        onView(withId(R.id.next)).perform(click());
        onView(allOf(withText(spell))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean(spell, false);

        //Assert
        Assert.assertTrue(isSelected);
    }

    @Test
    public void checkMagicCircle() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "Magic Circle";
        Boolean isSelected;

        //Act
        editor.putString("Class", "Rogue");
        editor.commit();
        onView(withId(R.id.next)).perform(click());
        onView(allOf(withText(spell))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean("MagicCircle", false);

        //Assert
        Assert.assertTrue(isSelected);
    }

    @Test
    public void checkConjureElemental() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String spell = "Conjure Elemental";
        Boolean isSelected;

        //Act
        editor.putString("Class", "Rogue");
        editor.commit();
        onView(withId(R.id.next)).perform(click());
        onView(allOf(withText(spell))).perform(click());
        onView(withId(R.id.next)).perform(click());
        isSelected = character.getBoolean("ConjureElemental", false);

        //Assert
        Assert.assertTrue(isSelected);
    }
}
