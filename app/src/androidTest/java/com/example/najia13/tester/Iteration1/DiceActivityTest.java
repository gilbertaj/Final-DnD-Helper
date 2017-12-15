package com.example.najia13.tester.Iteration1;

/**
 * Created by Najia13 on 10/5/2016.
 */
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

@RunWith(AndroidJUnit4.class)




public class DiceActivityTest {
    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void launchDiceRoller() throws Exception {
        //Arrange
        String title = "Roll!";

        //Act
        onView(allOf(withText("Dice"))).perform(click());

        //Assert
        onView(ViewMatchers.withId(R.id.tvRoll)).check(matches(withText(title)));
    }
}
