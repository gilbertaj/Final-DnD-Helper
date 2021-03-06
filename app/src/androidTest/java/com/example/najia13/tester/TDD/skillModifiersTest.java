package com.example.najia13.tester.TDD;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.SkillSelection;

import org.junit.Test;

/**
 * Created by Michael on 12/4/2016.
 */

public class skillModifiersTest extends ActivityInstrumentationTestCase2<SkillSelection> {
    SkillSelection mActivity;
    TextView climb;
    String modifierTest;
    String modifier;

    @SuppressWarnings("deprecation")
    public skillModifiersTest() {
        super(SkillSelection.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        Context mContext = InstrumentationRegistry.getTargetContext();
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        editor.putString("StrModifier", "+4");

        editor.commit();
        modifierTest = "+4";
        mActivity = this.getActivity();
        climb = (TextView) getActivity().findViewById(R.id.statClimb);
        modifier = climb.getText().toString();
    }


    @Test
    public void testPoints()
    {
        assertEquals(modifier, modifierTest);
    }
}