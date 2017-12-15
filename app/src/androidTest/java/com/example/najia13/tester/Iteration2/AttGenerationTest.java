package com.example.najia13.tester.Iteration2;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.attributes.GenerateAttributes;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by Michael on 11/8/2016.
 */

//Test for checking attributes are generated and initial value 0 is replaced on button click

public class AttGenerationTest {
    @Rule
    public ActivityTestRule<GenerateAttributes> mActivityRule = new ActivityTestRule(GenerateAttributes.class);

    @Test
    public void test() {
        onView(ViewMatchers.withId(R.id.normal))
                .perform(click());
        onView(withId(R.id.etStrength)).check(matches(not(withText("0"))));

    }
}
