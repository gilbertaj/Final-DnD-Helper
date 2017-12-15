package com.example.najia13.tester.TDD;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.SkillSelection;

import org.junit.Test;
/**
 * Created by Michael on 12/4/2016.
 */

public class boldTextTest extends ActivityInstrumentationTestCase2<SkillSelection> {
    SkillSelection mActivity;
    TextView diplomacy;

    @SuppressWarnings("deprecation")
    public boldTextTest()
    {
        super(SkillSelection.class);
    }

    public void setUp() throws Exception
    {
        super.setUp();
        Context mContext = InstrumentationRegistry.getTargetContext();
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        editor.putString("Class", "Rogue");
        editor.putString("Class", "Cleric");
        editor.commit();

        mActivity = this.getActivity();
        diplomacy = (TextView) getActivity().findViewById(R.id.tvDiplomacy);
    }


    @Test
    public void testPoints()
    {
        assert(diplomacy.getTypeface().getStyle()== Typeface.BOLD);
    }


}
