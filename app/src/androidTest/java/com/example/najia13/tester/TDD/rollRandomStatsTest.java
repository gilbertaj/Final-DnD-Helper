package com.example.najia13.tester.TDD;


import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.attributes.GenerateAttributes;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Michael on 12/4/2016.
 */

public class rollRandomStatsTest extends ActivityInstrumentationTestCase2<GenerateAttributes> {
    GenerateAttributes mActivity;
    TextView strength;
    String testString;

    @SuppressWarnings("deprecation")
    public rollRandomStatsTest()
    {
        super(GenerateAttributes.class);
    }

    public void setUp() throws Exception
    {
        super.setUp();

        testString = "0";
        mActivity = this.getActivity();

        onView(allOf(ViewMatchers.withId(R.id.normal))).perform(click());
        strength = (TextView) getActivity().findViewById(R.id.etStrength);
    }


    @Test
    public void testPoints()
    {
        assertNotSame(testString, strength);
    }


}
