package com.example.najia13.tester.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.SpellDetail;
import com.example.najia13.tester.activities.spells.ConjureElemental;
import com.example.najia13.tester.activities.spells.MagicCircle;
import com.example.najia13.tester.activities.spells.Maze;
import com.example.najia13.tester.adapters.SpellsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/9/16.
 */

public class SpellsFragment extends Fragment implements SpellsAdapter.OnClickListener {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View mview;
    private SpellsAdapter adapter;
    private List<String> spellList;

    public SpellsFragment() {
        // Required empty public constructor
    }

    public static SpellsFragment newInstance() {
        SpellsFragment fragment = new SpellsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_spells_list, container, false);

        setDisplayList();
        viewRecycler();

        swipeRefreshLayout = (SwipeRefreshLayout) mview.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

        return mview;
    }

    public void refreshItems() {
        setDisplayList();
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        viewRecycler();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) mview.findViewById(R.id.spellList);
        adapter = new SpellsAdapter(spellList, getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setDisplayList() {
        String[] spells = getSpellDisplayList();
        boolean[] spellsBoolList = getSpellBooleans();

        spellList = new ArrayList<>();
        int index = 0;
        for (boolean spellExists : spellsBoolList) {
            if (spellExists) {
                spellList.add(spells[index]);
            }
            index++;
        }
    }

    private String[] getSpellDisplayList() {
        String[] spells = {
          "Acid Splash",                //0
          "Alarm",                      //1
          "Animal Messenger",           //2
          "Arcane Mark",                //3
          "Bless",                      //4
          "Bless Water",                //5
          "Bless Weapon",               //6
          "Calm Animals",               //7
          "Charm Animal",               //8
          "Create Water",               //9
          "Cure Minor Wounds",          //10
          "Dancing Lights",             //11
          "Daze",                       //12
          "Delay Poison",               //13
          "Detect Animals/Plants",      //14
          "Detect Magic",               //15
          "Detect Poison",              //16
          "Detect Snares/Pits",         //17
          "Detect Undead",              //18
          "Disrupt Undead",             //19
          "Divine Favor",               //20
          "Endure Elements",            //21
          "Entangle",                   //22
          "Hide from Animals",          //23
          "Flare",                      //24
          "Ghost Sound",                //25
          "Guidance",                   //26
          "Inflict Minor Wounds",       //27
          "Jump",                       //28
          "Know Direction",             //29
          "Light",                      //30
          "Longstrider",                //31
          "Lullaby",                    //32
          "Mage Hand",                  //33
          "Magic Fang",                 //34
          "Magic Weapon",               //35
          "Mending",                    //36
          "Message",                    //37
          "Open/Close",                 //38
          "Pass without Trace",         //39
          "Prestidigitation",           //40
          "Protection From Chaos/Evil", //41
          "Purify Food and Drink",      //42
          "Ray of Frost",               //43
          "Read Magic",                 //44
          "Resistance",                 //45
          "Resist Energy",              //46
          "Restoration, Lesser",        //47
          "Speak with Animals",         //48
          "Summon Instrument",          //49
          "Summon Nature's Ally I",     //50
          "Touch of Fatigue",           //51
          "Virtue",                     //52
          "Conjure Elemental",          //53
          "Maze",                       //54
          "Magic Circle",               //55
          "Gaseous Form",               //56
          "Telekinesis",                //57
          "Evard's Black Tentacle",     //58
          "DruidCraft",                 //59
          "Hex",                        //60
          "Witch Bolt",                 //61
          "Time Stop"                   //62
        };

        return spells;
    }

    private String[] getFullSpellList() {
        String[] fullSpellList = {
          "AcidSplash",                 //0
          "Alarm",                      //1
          "AnimalMessenger",            //2
          "ArcaneMark",                 //3
          "Bless",                      //4
          "BlessWater",                 //5
          "BlessWeapon",                //6
          "CalmAnimals",                //7
          "CharmAnimal",                //8
          "CreateWater",                //9
          "CureMinorWounds",            //10
          "DancingLights",              //11
          "Daze",                       //12
          "DelayPoison",                //13
          "DetectAnimalsPlants",        //14
          "DetectMagic",                //15
          "DetectPoison",               //16
          "DetectSnaresPits",           //17
          "DetectUndead",               //18
          "DisruptUndead",              //19
          "DivineFavor",                //20
          "EndureElements",             //21
          "Entangle",                   //22
          "HideFromAnimals",            //23
          "Flare",                      //24
          "GhostSound",                 //25
          "Guidance",                   //26
          "InflictMinorWounds",         //27
          "Jump",                       //28
          "KnowDirection",              //29
          "Light",                      //30
          "Longstrider",                //31
          "Lullaby",                    //32
          "MageHand",                   //33
          "MagicFang",                  //34
          "MagicWeapon",                //35
          "Mending",                    //36
          "Message",                    //37
          "OpenClose",                  //38
          "PassWithoutTrace",           //39
          "Prestidigitation",           //40
          "ProtectionFromChaos/Evil",   //41
          "PurifyFoodAndDrink",         //42
          "RayOfFrost",                 //43
          "ReadMagic",                  //44
          "Resistance",                 //45
          "ResistEnergy",               //46
          "RestorationLesser",          //47
          "SpeakWithAnimals",           //48
          "SummonInstrument",           //49
          "SummonNatureAllyI",          //50
          "TouchOfFatigue",             //51
          "Virtue",                     //52
          "ConjureElemental",           //53
          "Maze",                       //54
          "GaseousForm",                //55
          "Telekinesis",                //56
          "BlackTentacle",              //57
          "DruidCraft",                 //58
          "Hex",                        //59
          "WitchBolt",                  //60
          "TimeStop"                    //61
        };

        return fullSpellList;
    }

    private boolean[] getSpellBooleans() {
        SharedPreferences character = this.getActivity().getSharedPreferences("Character", 0);
        String[] fullSpellList = getSpellDisplayList();
        boolean[] spellsBoolList = new boolean[fullSpellList.length];
        int index = 0;
        for (String spell : fullSpellList) {
            spellsBoolList[index] = (character.getBoolean(spell, false));
            index++;
        }

        return spellsBoolList;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(int position) {
//        String[] spellDisplayList = getSpellDisplayList();
//        if (spellList.get(position).equalsIgnoreCase(spellDisplayList[53])) {
//            Intent intent = new Intent(recyclerView.getContext(), ConjureElemental.class);
//            startActivity(intent);
//        }
//        if (spellList.get(position).equalsIgnoreCase(spellDisplayList[54])) {
//            Intent intent = new Intent(recyclerView.getContext(), Maze.class);
//            startActivity(intent);
//        }
//        if (spellList.get(position).equalsIgnoreCase(spellDisplayList[55])) {
//            Intent intent = new Intent(recyclerView.getContext(), MagicCircle.class);
//            startActivity(intent);
//        }
        String extra = spellList.get(position);
        Intent intent = new Intent(recyclerView.getContext(), SpellDetail.class);
        intent.putExtra("Name", extra);
        startActivity(intent);
    }
}
