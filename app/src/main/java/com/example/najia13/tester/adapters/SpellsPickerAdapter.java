package com.example.najia13.tester.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.najia13.tester.R;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/9/16.
 */
public class SpellsPickerAdapter extends RecyclerView.Adapter<SpellsPickerAdapter.ViewHolder> {

    public static Context mContext;
    private static List<String> mStrings;
    private static List<Boolean> mFavorites;
    private static OnClickListener sOnFavoriteCallback;

    public SpellsPickerAdapter(List<String> mstrings, Context context, OnClickListener callback) {
        mContext = context;
        this.mStrings = (mstrings != null) ? mstrings : new ArrayList<String>();
        this.mFavorites = new ArrayList<>();
        for (int i = 0; i < mstrings.size(); i++) {
            mFavorites.add(false);
        }
        this.sOnFavoriteCallback = callback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stringName;
        private TextView stringDescription;
        private MaterialIconView check;


        public ViewHolder(final View itemView) {
            super(itemView);
            stringName = (TextView) itemView.findViewById(R.id.itemName);
            stringDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            check = (MaterialIconView) itemView.findViewById(R.id.checkDark);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sOnFavoriteCallback.onClick(getAdapterPosition());
                }
            });
        }
    }

    public static void reset(View view, int position) {
        MaterialIconView check = (MaterialIconView) view;

        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        String charClass = character.getString("Class", " ");

        if (charClass == "Bard") {
            checkBardSpells(position);
        } else if (charClass == "Cleric") {
            checkClericSpells(position);
        } else if (charClass == "Druid") {
            checkDruidSpells(position);
        } else if (charClass == "Paladin") {
            checkPaladinSpells(position);
        } else if (charClass == "Ranger") {
            checkRangerSpells(position);
        } else if (charClass == "Sorcerer") {
            checkSorcererSpells(position);
        } else {
            checkDefaultSpells(position);
        }



        if (mFavorites.get(position)) {
            check.setColor(Color.GRAY);
            mFavorites.set(position, false);
        } else {
            check.setColor(Color.parseColor("#009688"));
            mFavorites.set(position, true);
        }
    }

    private static void checkBardSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Dancing Lights
                boolean dancingLights = character.getBoolean("Dancing Lights", false);
                editor.putBoolean("Dancing Lights", !(dancingLights));
                editor.commit();
                break;
            case 1: //Daze
                boolean daze = character.getBoolean("Daze", false);
                editor.putBoolean("Daze", !(daze));
                editor.commit();
                break;
            case 2: //Detect Magic
                boolean detectMagic = character.getBoolean("Detect Magic", false);
                editor.putBoolean("Detect Magic", !(detectMagic));
                editor.commit();
                break;
            case 3: //Flare
                boolean flare = character.getBoolean("Flare", false);
                editor.putBoolean("Flare", !(flare));
                editor.commit();
                break;
            case 4: //Ghost Sound
                boolean ghostSound = character.getBoolean("Ghost Sound", false);
                editor.putBoolean("Ghost Sound", !(ghostSound));
                editor.commit();
                break;
            case 5: //Know Direction
                boolean knowDirection = character.getBoolean("Know Direction", false);
                editor.putBoolean("Know Direction", !(knowDirection));
                editor.commit();
                break;
            case 6: //Light
                boolean light = character.getBoolean("Light", false);
                editor.putBoolean("Light", !(light));
                editor.commit();
                break;
            case 7: //Lullaby
                boolean lullaby = character.getBoolean("Lullaby", false);
                editor.putBoolean("Lullaby", !(lullaby));
                editor.commit();
                break;
            case 8: //Mage Hand
                boolean mageHand = character.getBoolean("Mage Hand", false);
                editor.putBoolean("Mage Hand", !(mageHand));
                editor.commit();
                break;
            case 9: //Mending
                boolean mending = character.getBoolean("Mending", false);
                editor.putBoolean("Mending", !(mending));
                editor.commit();
                break;
            case 10: //Message
                boolean message = character.getBoolean("Message", false);
                editor.putBoolean("Message", !(message));
                editor.commit();
                break;
            case 11: //Open/Close
                boolean openClose = character.getBoolean("Open/Close", false);
                editor.putBoolean("Open/Close", !(openClose));
                editor.commit();
                break;
            case 12: //Prestidigitation
                boolean prestidigitation = character.getBoolean("Prestidigitation", false);
                editor.putBoolean("Prestidigitation", !(prestidigitation));
                editor.commit();
                break;
            case 13: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 14: //Resistance
                boolean resistance = character.getBoolean("Resistance", false);
                editor.putBoolean("Resistance", !(resistance));
                editor.commit();
                break;
            case 15: //Summon Instrument
                boolean summonInstrument = character.getBoolean("Summon Instrument", false);
                editor.putBoolean("Summon Instrument", !(summonInstrument));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkClericSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Create Water
                boolean createWater = character.getBoolean("Create Water", false);
                editor.putBoolean("Create Water", !(createWater));
                editor.commit();
                break;
            case 1: //Cure Minor Wounds
                boolean cureMinorWounds = character.getBoolean("Cure Minor Wounds", false);
                editor.putBoolean("Cure Minor Wounds", !(cureMinorWounds));
                editor.commit();
                break;
            case 2: //Detect Magic
                boolean detectMagic = character.getBoolean("Detect Magic", false);
                editor.putBoolean("Detect Magic", !(detectMagic));
                editor.commit();
                break;
            case 3: //Detect Poison
                boolean detectPoison = character.getBoolean("Detect Poison", false);
                editor.putBoolean("Detect Poison", !(detectPoison));
                editor.commit();
                break;
            case 4: //Guidance
                boolean guidance = character.getBoolean("Guidance", false);
                editor.putBoolean("Guidance", !(guidance));
                editor.commit();
                break;
            case 5: //Inflict Minor Wounds
                boolean inflictMinorWounds = character.getBoolean("Inflict Minor Wounds", false);
                editor.putBoolean("Inflict Minor Wounds", !(inflictMinorWounds));
                editor.commit();
                break;
            case 6: //Light
                boolean light = character.getBoolean("Light", false);
                editor.putBoolean("Light", !(light));
                editor.commit();
                break;
            case 7: //Mending
                boolean mending = character.getBoolean("Mending", false);
                editor.putBoolean("Mending", !(mending));
                editor.commit();
                break;
            case 8: //Purify Food and Drink
                boolean purifyFoodAndDrink = character.getBoolean("Purify Food And Drink", false);
                editor.putBoolean("Purify Food And Drink", !(purifyFoodAndDrink));
                editor.commit();
                break;
            case 9: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 10: //Resistance
                boolean resistance = character.getBoolean("Resistance", false);
                editor.putBoolean("Resistance", !(resistance));
                editor.commit();
                break;
            case 11: //Virtue
                boolean virtue = character.getBoolean("Virtue", false);
                editor.putBoolean("Virtue", !(virtue));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkDruidSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Create Water
                boolean createWater = character.getBoolean("Create Water", false);
                editor.putBoolean("Create Water", !(createWater));
                editor.commit();
                break;
            case 1: //Cure Minor Wounds
                boolean cureMinorWounds = character.getBoolean("Cure Minor Wounds", false);
                editor.putBoolean("Cure Minor Wounds", !(cureMinorWounds));
                editor.commit();
                break;
            case 2: //Detect Magic
                boolean detectMagic = character.getBoolean("Detect Magic", false);
                editor.putBoolean("Detect Magic", !(detectMagic));
                editor.commit();
                break;
            case 3: //Detect Poison
                boolean detectPoison = character.getBoolean("Detect Poison", false);
                editor.putBoolean("Detect Poison", !(detectPoison));
                editor.commit();
                break;
            case 4: //Flare
                boolean flare = character.getBoolean("Flare", false);
                editor.putBoolean("Flare", !(flare));
                editor.commit();
                break;
            case 5: //Guidance
                boolean guidance = character.getBoolean("Guidance", false);
                editor.putBoolean("Guidance", !(guidance));
                editor.commit();
                break;
            case 6: //Know Direction
                boolean knowDirection = character.getBoolean("Know Direction", false);
                editor.putBoolean("Know Direction", !(knowDirection));
                editor.commit();
                break;
            case 7: //Light
                boolean light = character.getBoolean("Light", false);
                editor.putBoolean("Light", !(light));
                editor.commit();
                break;
            case 8: //Mending
                boolean mending = character.getBoolean("Mending", false);
                editor.putBoolean("Mending", !(mending));
                editor.commit();
                break;
            case 9: //Purify Food and Drink
                boolean purifyFoodAndDrink = character.getBoolean("Purify Food And Drink", false);
                editor.putBoolean("Purify Food And Drink", !(purifyFoodAndDrink));
                editor.commit();
                break;
            case 10: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 11: //Resistance
                boolean resistance = character.getBoolean("Resistance", false);
                editor.putBoolean("Resistance", !(resistance));
                editor.commit();
                break;
            case 12: //Virtue
                boolean virtue = character.getBoolean("Virtue", false);
                editor.putBoolean("Virtue", !(virtue));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkPaladinSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Bless
                boolean bless = character.getBoolean("Bless", false);
                editor.putBoolean("Bless", !(bless));
                editor.commit();
                break;
            case 1: //Bless Water
                boolean blessWater = character.getBoolean("Bless Water", false);
                editor.putBoolean("Bless Water", !(blessWater));
                editor.commit();
                break;
            case 2: //Bless Weapon
                boolean blessWeapon = character.getBoolean("Bless Weapon", false);
                editor.putBoolean("Bless Weapon", !(blessWeapon));
                editor.commit();
                break;
            case 3: //Create Water
                boolean createWater = character.getBoolean("Create Water", false);
                editor.putBoolean("Create Water", !(createWater));
                editor.commit();
                break;
            case 4: //Cure Minor Wounds
                boolean cureMinorWounds = character.getBoolean("Cure Minor Wounds", false);
                editor.putBoolean("Cure Minor Wounds", !(cureMinorWounds));
                editor.commit();
                break;
            case 5: //Detect Poison
                boolean detectPoison = character.getBoolean("Detect Poison", false);
                editor.putBoolean("Detect Poison", !(detectPoison));
                editor.commit();
                break;
            case 6: //Detect Undead
                boolean detectUndead = character.getBoolean("Detect Undead", false);
                editor.putBoolean("Detect Undead", !(detectUndead));
                editor.commit();
                break;
            case 7: //Divine Favor
                boolean divineFavor = character.getBoolean("Divine Favor", false);
                editor.putBoolean("Divine Favor", !(divineFavor));
                editor.commit();
                break;
            case 8: //Endure Elements
                boolean endureElements = character.getBoolean("Endure Elements", false);
                editor.putBoolean("Endure Elements", !(endureElements));
                editor.commit();
                break;
            case 9: //Magic Weapon
                boolean magicWeapon = character.getBoolean("Magic Weapon", false);
                editor.putBoolean("Magic Weapon", !(magicWeapon));
                editor.commit();
                break;
            case 10: //Protection from Chaos/Evil
                boolean protectionFromChaosEvil = character.getBoolean("Protection From Chaos/Evil",
                        false);
                editor.putBoolean("Protection From Chaos/Evil", !(protectionFromChaosEvil));
                editor.commit();
                break;
            case 11: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 12: //Resistance
                boolean resistance = character.getBoolean("Resistance", false);
                editor.putBoolean("Resistance", !(resistance));
                editor.commit();
                break;
            case 13: //Restoration, Lesser
                boolean restorationLesser = character.getBoolean("Restoration, Lesser", false);
                editor.putBoolean("Restoration, Lesser", !(restorationLesser));
                editor.commit();
                break;
            case 14: //Virtue
                boolean virtue = character.getBoolean("Virtue", false);
                editor.putBoolean("Virtue", !(virtue));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkRangerSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Alarm
                boolean alarm = character.getBoolean("Alarm", false);
                editor.putBoolean("Alarm", !(alarm));
                editor.commit();
                break;
            case 1: //Animal Messenger
                boolean animalMessenger = character.getBoolean("Animal Messenger", false);
                editor.putBoolean("Animal Messenger", !(animalMessenger));
                editor.commit();
                break;
            case 2: //Calm Animals
                boolean calmAnimals = character.getBoolean("Calm Animals", false);
                editor.putBoolean("Calm Animals", !(calmAnimals));
                editor.commit();
                break;
            case 3: //Charm Animal
                boolean charmAnimal = character.getBoolean("Charm Animal", false);
                editor.putBoolean("Charm Animal", !(charmAnimal));
                editor.commit();
                break;
            case 4: //Delay Poison
                boolean delayPoison = character.getBoolean("Delay Poison", false);
                editor.putBoolean("Delay Poison", !(delayPoison));
                editor.commit();
                break;
            case 5: //Detect Animals or Plants
                boolean detectAnimalsPlants = character.getBoolean("Detect Animals/Plants", false);
                editor.putBoolean("Detect Animals/Plants", !(detectAnimalsPlants));
                editor.commit();
                break;
            case 6: //Detect Poison
                boolean detectPoison = character.getBoolean("Detect Poison", false);
                editor.putBoolean("Detect Poison", !(detectPoison));
                editor.commit();
                break;
            case 7: //Detect Snares and Pits
                boolean detectSnaresPits = character.getBoolean("Detect Snares/Pits", false);
                editor.putBoolean("Detect Snares/Pits", !(detectSnaresPits));
                editor.commit();
                break;
            case 8: //Endure Elements
                boolean endureElements = character.getBoolean("Endure Elements", false);
                editor.putBoolean("Endure Elements", !(endureElements));
                editor.commit();
                break;
            case 9: //Entangle
                boolean entangle = character.getBoolean("Entangle", false);
                editor.putBoolean("Entangle", !(entangle));
                editor.commit();
                break;
            case 10: //Hide from Animals
                boolean hideFromAnimals = character.getBoolean("Hide From Animals", false);
                editor.putBoolean("Hide From Animals", !(hideFromAnimals));
                editor.commit();
                break;
            case 11: //Jump
                boolean jump = character.getBoolean("Jump", false);
                editor.putBoolean("Jump", !(jump));
                editor.commit();
                break;
            case 12: //Longstrider
                boolean longstrider = character.getBoolean("Longstrider", false);
                editor.putBoolean("Longstrider", !(longstrider));
                editor.commit();
                break;
            case 13: //Magic Fang
                boolean magicFang = character.getBoolean("Magic Fang", false);
                editor.putBoolean("Magic Fang", !(magicFang));
                editor.commit();
                break;
            case 14: //Pass without Trace
                boolean passWithoutTrace = character.getBoolean("Pass Without Trace", false);
                editor.putBoolean("Pass Without Trace", !(passWithoutTrace));
                editor.commit();
                break;
            case 15: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 16: //Resist Energy
                boolean resistEnergy = character.getBoolean("Resist Energy", false);
                editor.putBoolean("Resist Energy", !(resistEnergy));
                editor.commit();
                break;
            case 17: //Speak with Animals
                boolean speakWithAnimals = character.getBoolean("Speak With Animals", false);
                editor.putBoolean("Speak With Animals", !(speakWithAnimals));
                editor.commit();
                break;
            case 18: //Summon Nature's Ally I
                boolean summonNatureAllyI = character.getBoolean("Summon Nature's Ally I", false);
                editor.putBoolean("Summon Nature's Ally I", !(summonNatureAllyI));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkSorcererSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Resistance
                boolean resistance = character.getBoolean("Resistance", false);
                editor.putBoolean("Resistance", !(resistance));
                editor.commit();
                break;
            case 1: //Acid Splash
                boolean acidSplash = character.getBoolean("Acid Splash", false);
                editor.putBoolean("Acid Splash", !(acidSplash));
                editor.commit();
                break;
            case 2: //Delay Poison
                boolean delayPoison = character.getBoolean("Delay Poison", false);
                editor.putBoolean("Delay Poison", !(delayPoison));
                editor.commit();
                break;
            case 3: //Detect Magic
                boolean detectMagic = character.getBoolean("Detect Magic", false);
                editor.putBoolean("Detect Magic", !(detectMagic));
                editor.commit();
                break;
            case 4: //Read Magic
                boolean readMagic = character.getBoolean("Read Magic", false);
                editor.putBoolean("Read Magic", !(readMagic));
                editor.commit();
                break;
            case 5: //Daze
                boolean daze = character.getBoolean("Daze", false);
                editor.putBoolean("Daze", !(daze));
                editor.commit();
                break;
            case 6: //Dancing Lights
                boolean dancingLights = character.getBoolean("Dancing Lights", false);
                editor.putBoolean("Dancing Lights", !(dancingLights));
                editor.commit();
                break;
            case 7: //Flare
                boolean flare = character.getBoolean("Flare", false);
                editor.putBoolean("Flare", !(flare));
                editor.commit();
                break;
            case 8: //Light
                boolean light = character.getBoolean("Light", false);
                editor.putBoolean("Light", !(light));
                editor.commit();
                break;
            case 9: //Ray of Frost
                boolean rayOfFrost = character.getBoolean("Ray Of Frost", false);
                editor.putBoolean("Ray Of Frost", !(rayOfFrost));
                editor.commit();
                break;
            case 10: //Ghost Sound
                boolean ghostSound = character.getBoolean("Ghost Sound", false);
                editor.putBoolean("Ghost Sound", !(ghostSound));
                editor.commit();
                break;
            case 11: //Disrupt Undead
                boolean disruptUndead = character.getBoolean("Disrupt Undead", false);
                editor.putBoolean("Disrupt Undead", !(disruptUndead));
                editor.commit();
                break;
            case 12: //Touch of Fatigue
                boolean touchOfFatigue = character.getBoolean("Touch Of Fatigue", false);
                editor.putBoolean("Touch Of Fatigue", !(touchOfFatigue));
                editor.commit();
                break;
            case 13: //Mage Hand
                boolean mageHand = character.getBoolean("Mage Hand", false);
                editor.putBoolean("Mage Hand", !(mageHand));
                editor.commit();
                break;
            case 14: //Mending
                boolean mending = character.getBoolean("Mending", false);
                editor.putBoolean("Mending", !(mending));
                editor.commit();
                break;
            case 15: //Message
                boolean message = character.getBoolean("Message", false);
                editor.putBoolean("Message", !(message));
                editor.commit();
                break;
            case 16: //Open/Close
                boolean openClose = character.getBoolean("Open/Close", false);
                editor.putBoolean("Open/Close", !(openClose));
                editor.commit();
                break;
            case 17: //Arcane Mark
                boolean arcaneMark = character.getBoolean("Arcane Mark", false);
                editor.putBoolean("Arcane Mark", !(arcaneMark));
                editor.commit();
                break;
            case 18: //Prestidigitation
                boolean prestidigitation = character.getBoolean("Prestidigitation", false);
                editor.putBoolean("Prestidigitation", !(prestidigitation));
                editor.commit();
                break;
            default:
                break;
        }
    }

    private static void checkDefaultSpells(int position) {
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Conjure Elemental
                boolean conjureElemental = character.getBoolean("Conjure Elemental", false);
                editor.putBoolean("Conjure Elemental", !(conjureElemental));
                editor.commit();
                break;
            case 1: //Maze
                boolean maze = character.getBoolean("Maze", false);
                editor.putBoolean("Maze", !(maze));
                editor.commit();
                break;
            case 2: //Magic Circle
                boolean magicCircle = character.getBoolean("Magic Circle", false);
                editor.putBoolean("Magic Circle", !(magicCircle));
                editor.commit();
                break;
            case 3: //Gaseous Form
                boolean gaseousForm = character.getBoolean("Gaseous Form", false);
                editor.putBoolean("Gaseous Form", !(gaseousForm));
                editor.commit();
                break;
            case 4: //Telekinesis
                boolean telekinesis = character.getBoolean("Telekinesis", false);
                editor.putBoolean("Telekinesis", !(telekinesis));
                editor.commit();
                break;
            case 5: //Evard's Black Tentacle
                boolean blackTentacle = character.getBoolean("Evard's Black Tentacle", false);
                editor.putBoolean("Evard's Black Tentacle", !(blackTentacle));
                editor.commit();
                break;
            case 6: //DruidCraft
                boolean druidCraft = character.getBoolean("Druid Craft", false);
                editor.putBoolean("Druid Craft", !(druidCraft));
                editor.commit();
                break;
            case 7: //Hex
                boolean hex = character.getBoolean("Hex", false);
                editor.putBoolean("Hex", !(hex));
                editor.commit();
                break;
            case 8: //Witch Bolt
                boolean witchBolt = character.getBoolean("Witch Bolt", false);
                editor.putBoolean("Witch Bolt", !(witchBolt));
                editor.commit();
                break;
            case 9: //Time Stop
                boolean timeStop = character.getBoolean("Time Stop", false);
                editor.putBoolean("Time Stop", !(timeStop));
                editor.commit();
                break;
            default:
                break;
        }
    }

    @Override
    public SpellsPickerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_spells_list_picker, parent, false);
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SpellsPickerAdapter.ViewHolder viewHolder, int position) {
        final String currentString = mStrings.get(position);

        TextView name = viewHolder.stringName;
        TextView description = viewHolder.stringDescription;

        if (mFavorites.get(position)) {
            viewHolder.check.setColor(Color.parseColor("#009688"));
        } else {
            viewHolder.check.setColor(Color.GRAY);
        }

        final ViewHolder vH = viewHolder;

        final int index = position;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                final View view = view1;
                reset(vH.check, index);
            }
        });

        name.setText(currentString);
        //description.setText();
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    public interface OnClickListener {
        void onClick(int position);
    }

}