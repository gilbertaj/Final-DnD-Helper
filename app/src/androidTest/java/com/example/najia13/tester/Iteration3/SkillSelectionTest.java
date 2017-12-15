package com.example.najia13.tester.Iteration3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.SkillSelection;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Michael on 12/4/2016.
 */

public class SkillSelectionTest {
    Context mContext = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<SkillSelection> mActivityRule = new ActivityTestRule<>(SkillSelection.class);

    @Test
    public void checkAppraiseAdd() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String skill = "Appraise";
        String rank = character.getString(skill, " ");

        //Act
        onView(withId(R.id.incAppraise)).perform(click());
        int increasedRank = Integer.parseInt(rank);
        increasedRank++;
        rank = Integer.toString(increasedRank);

        //Assert
        onView(withId(R.id.rankAppraise)).check(matches(withText(rank)));
    }

    @Test
    public void checkBalanceDec() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String skill = "Balance";
        String rank = character.getString(skill, " ");

        //Act
        onView(withId(R.id.decAppraise)).perform(click());
        int increasedRank = Integer.parseInt(rank);
        if (increasedRank > 0) {
            increasedRank--;
        }
        rank = Integer.toString(increasedRank);

        //Assert
        onView(withId(R.id.rankBalance)).check(matches(withText(rank)));
    }

    @Test
    public void checkEscapeInc() {
        //Arrange
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String skill = "Escape";
        String rank = character.getString(skill, " ");

        //Act
        onView(withId(R.id.incEscape)).perform(click());
        int increasedRank = Integer.parseInt(rank);
        increasedRank++;
        rank = Integer.toString(increasedRank);

        //Assert
        onView(withId(R.id.rankEscape)).check(matches(withText(rank)));
    }
}
