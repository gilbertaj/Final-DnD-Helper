package com.example.najia13.tester.TDD;

/**
 * Created by Andrew on 12/4/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.CharacterActivity;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.core.AllOf.allOf;

public class attributeSubtractTest extends ActivityInstrumentationTestCase2<CharacterActivity> {
    Context mContext = InstrumentationRegistry.getTargetContext();
    CharacterActivity mActivity;
    private TextView strength;

    @SuppressWarnings("deprecation")
    public attributeSubtractTest() {
        super(CharacterActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Strength", Integer.toString(10));
        editor.commit();
        super.setUp();
        mActivity = this.getActivity();

        strength = (TextView) getActivity().findViewById(R.id.tvStrength);
    }

    @Test
    public void test() {
        String string = strength.getText().toString();
        String subString = "";

        for (int i = 10; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                break;
            }
            subString = subString + string.charAt(i);
        }

        int before = Integer.parseInt(subString);

        onView(allOf(ViewMatchers.withId(R.id.bStrSubtract))).perform(click());

        string = strength.getText().toString();
        subString = "";

        for (int i = 10; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                break;
            }
            subString = subString + string.charAt(i);
        }

        int after = Integer.parseInt(subString) + 1;
        assertEquals(before, after);
    }
}