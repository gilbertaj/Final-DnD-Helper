package com.example.najia13.tester.TDD;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.SkillSelection;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Michael on 12/4/2016.
 */

public class skillAddTest extends ActivityInstrumentationTestCase2<SkillSelection> {
    SkillSelection mActivity;
    TextView diplomacy;
    String rank;
    String rankTest;

    @SuppressWarnings("deprecation")
    public skillAddTest()
    {
        super(SkillSelection.class);
    }

    public void setUp() throws Exception
    {
        super.setUp();
        Context mContext = InstrumentationRegistry.getTargetContext();
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        editor.putString("IntModifier", "+4");
        editor.commit();

        mActivity = this.getActivity();
        onView(allOf(ViewMatchers.withId(R.id.incDiplomacy))).perform(click());
        diplomacy = (TextView) getActivity().findViewById(R.id.rankDiplomacy);
        rank = diplomacy.getText().toString();
        rankTest = "1";
    }


    @Test
    public void testPoints()
    {
        assertEquals(rank, rankTest);
    }


}
