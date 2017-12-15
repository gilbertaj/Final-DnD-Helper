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

public class getPointsTest extends ActivityInstrumentationTestCase2<SkillSelection>
{
    String point;
    String pointValue;
    SkillSelection mActivity;
    TextView pointTotal;

    @SuppressWarnings("deprecation")
    public getPointsTest()
    {
        super(SkillSelection.class);
    }

    public void setUp() throws Exception
    {
        super.setUp();
        Context mContext = InstrumentationRegistry.getTargetContext();
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        editor.putString("Skill", "8");
        editor.putString("IntModifier", "+4");
        point = "48";
        editor.commit();

        mActivity = this.getActivity();
        pointTotal = (TextView) getActivity().findViewById(R.id.points);
        pointValue = pointTotal.getText().toString();
    }


    @Test
    public void testPoints()
    {
        assertEquals(point, pointValue);
    }
}
