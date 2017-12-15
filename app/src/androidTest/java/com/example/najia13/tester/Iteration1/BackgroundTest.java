package com.example.najia13.tester.Iteration1;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.BackgroundSelection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class BackgroundTest {
    @Rule
    public ActivityTestRule<BackgroundSelection> mActivityRule = new ActivityTestRule(BackgroundSelection.class);

    @Test
    public void test() throws Exception{
        String string = "test";
        onView(ViewMatchers.withId(R.id.background)).perform(typeText(string));

        onView(withId(R.id.background)).perform(pressImeActionButton());

        onView(withId(R.id.background)).check(matches(withText(string)));
    }
}