package com.example.najia13.tester;

/**
 * Created by sbane on 10/11/2016.
 */
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
import static org.hamcrest.CoreMatchers.notNullValue;

import com.example.najia13.tester.activities.MainActivity;

@RunWith(AndroidJUnit4.class)

public class ItemsActivityTest {
    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void launchItems() throws Exception {
        //Arrange
        String buttonItems = "com/example/najia13/tester/Activities/items";

        //Act
        onView(withId(R.id.fragment_container)).perform(click());

        //Assert
        onView(withText(buttonItems)).check(matches(notNullValue()));
    }
}
