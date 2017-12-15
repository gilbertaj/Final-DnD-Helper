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

public class setAbilityModifiersTest  extends ActivityInstrumentationTestCase2<GenerateAttributes> {
    GenerateAttributes mActivity;
    TextView strengthMod;
    String testString;

    @SuppressWarnings("deprecation")
    public setAbilityModifiersTest() {
        super(GenerateAttributes.class);
    }

    public void setUp() throws Exception {
        super.setUp();

        testString = "-5";
        mActivity = this.getActivity();

        onView(allOf(ViewMatchers.withId(R.id.normal))).perform(click());
        strengthMod = (TextView) getActivity().findViewById(R.id.strengthMod);
    }


    @Test
    public void testPoints() {
        assertNotSame(testString, strengthMod);
    }
}