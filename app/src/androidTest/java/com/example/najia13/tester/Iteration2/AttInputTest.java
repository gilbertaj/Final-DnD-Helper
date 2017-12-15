package com.example.najia13.tester.Iteration2;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.attributes.InputAttributes;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Test for checking attributes can be input

public class AttInputTest {
    @Rule
    public ActivityTestRule<InputAttributes> mActivityRule = new ActivityTestRule(InputAttributes.class);

    @Test
    public void test() {
        String string = "16";

        onView(ViewMatchers.withId(R.id.etStrength)).perform(clearText()).perform(typeText(string));

        onView(withId(R.id.etStrength)).check(matches(withText(string)));

    }
}
