package com.example.najia13.tester.Iteration2;

/**
 * Created by gilbertaj on 11/8/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(AndroidJUnit4.class)

public class ItemsActivityTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkLongSword() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String item = "LongSword";
        String itemTest = "Long Sword";

        //Act
        editor.putBoolean(item, true);
        editor.commit();
        onView(allOf(withText("Items"))).perform(click());
        onView(allOf(withText(itemTest))).perform(click());

        //Assert
        onView(withId(R.id.textView93)).check(matches(withText(itemTest)));
    }

    @Test
    public void checkDagger() throws Exception {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String item = "Dagger";
        String itemTest = "Dagger";

        //Act
        editor.putBoolean(item, true);
        editor.commit();
        onView(allOf(withText("Items"))).perform(click());
        onView(allOf(withText(itemTest))).perform(click());

        //Assert
        onView(withId(R.id.textView94)).check(matches(withText(itemTest)));
    }

    @Test
    public void checkGauntletSpiked() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String item = "GauntletSpiked";
        String itemTest = "Gauntlet, Spiked";

        //Act
        editor.putBoolean(item, true);
        editor.commit();
        onView(allOf(withText("Items"))).perform(click());
        onView(allOf(withText(itemTest))).perform(click());

        //Assert
        onView(withId(R.id.textView94)).check(matches(withText(itemTest)));
    }
}
