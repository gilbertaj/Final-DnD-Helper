package com.example.najia13.tester.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.najia13.tester.R;

public class SpellDetail extends AppCompatActivity {
    TextView name;
    TextView description;
    String spellName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_detail);
        name = (TextView) findViewById(R.id.SpellDetailName);
        description = (TextView) findViewById(R.id.SpellDetailDescription);
        spellName = getIntent().getStringExtra("Name");

        setTextFields();
    }

    public void setTextFields() {
        name.setText(spellName);
        String text = "";
        if(spellName.equalsIgnoreCase("Acid Splash")) {
            text = "You fire a small orb of acid at the target. You must succeed on a ranged " +
                    "touch attack to hit your target. The orb deals 1d3 points of acid damage. " +
                    "This acid disappears after 1 round.";
        }
        if(spellName.equalsIgnoreCase("Alarm")) {
            text = "Alarm creates a subtle ward on an area you select. Once the spell effect is in " +
                    "place, it thereafter sounds a mental or audible alarm each time a creature of " +
                    "Tiny or larger size enters the warded area or touches it. A creature that " +
                    "speaks the password (determined by you at the time of casting) does not set " +
                    "off the alarm. You decide at the time of casting whether the alarm will be " +
                    "mental or audible in nature.\n" +
                    "\n" +
                    "Mental Alarm: A mental alarm alerts you (and only you) so long as you remain " +
                    "within 1 mile of the warded area. You note a single mental “ping” that " +
                    "awakens you from normal sleep but does not otherwise disturb concentration. " +
                    "A silence spell has no effect on a mental alarm.\n" +
                    "\n" +
                    "Audible Alarm: An audible alarm produces the sound of a hand bell, and anyone " +
                    "within 60 feet of the warded area can hear it clearly. Reduce the distance by " +
                    "10 feet for each interposing closed door and by 20 feet for each substantial " +
                    "interposing wall.\n" +
                    "\n" +
                    "In quiet conditions, the ringing can be heard faintly as far as 180 feet away." +
                    " The sound lasts for 1 round. Creatures within a silence spell cannot hear the " +
                    "ringing.\n" +
                    "\n" +
                    "Ethereal or astral creatures do not trigger the alarm.\n" +
                    "\n" +
                    "Alarm can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Animal Messenger")) {
            text = "You compel a Tiny animal to go to a spot you designate. The most common use for" +
                    " this spell is to get an animal to carry a message to your allies. The animal" +
                    " cannot be one tamed or trained by someone else, including such creatures as " +
                    "familiars and animal companions.\n" +
                    "\n" +
                    "Using some type of food desirable to the animal as a lure, you call the animal" +
                    " to you. It advances and awaits your bidding. You can mentally impress on the" +
                    " animal a certain place well known to you or an obvious landmark. The " +
                    "directions must be simple, because the animal depends on your knowledge " +
                    "and can’t find a destination on its own. You can attach a small item or " +
                    "note to the messenger. The animal then goes to the designated location and " +
                    "waits there until the duration of the spell expires, whereupon it resumes " +
                    "its normal activities.\n" +
                    "\n" +
                    "During this period of waiting, the messenger allows others to approach it and" +
                    " remove any scroll or token it carries. The intended recipient gains no " +
                    "special ability to communicate with the animal or read any attached message " +
                    "(if it’s written in a language he doesn’t know, for example).";
        }
        if(spellName.equalsIgnoreCase("Arcane Mark")) {
            text = "This spell allows you to inscribe your personal rune or mark, which can consist" +
                    " of no more than six characters. The writing can be visible or invisible. An " +
                    "arcane mark spell enables you to etch the rune upon any substance without harm" +
                    " to the material upon which it is placed. If an invisible mark is made, a " +
                    "detect magic spell causes it to glow and be visible, though not necessarily " +
                    "understandable.\n" +
                    "\n" +
                    "See invisibility, true seeing, a gem of seeing, or a robe of eyes likewise " +
                    "allows the user to see an invisible arcane mark. A read magic spell reveals " +
                    "the words, if any. The mark cannot be dispelled, but it can be removed by " +
                    "the caster or by an erase spell.\n" +
                    "\n" +
                    "If an arcane mark is placed on a living being, the effect gradually fades in " +
                    "about a month.\n" +
                    "\n" +
                    "Arcane mark must be cast on an object prior to casting instant summons on the " +
                    "same object (see that spell description for details).";
        }
        if(spellName.equalsIgnoreCase("Bless")) {
            text = "Bless fills your allies with courage. Each ally gains a +1 morale bonus on " +
                    "attack rolls and on saving throws against fear effects.\n" +
                    "\n" +
                    "Bless counters and dispels bane.";
        }
        if(spellName.equalsIgnoreCase("Bless Water")) {
            text = "This transmutation imbues a flask (1 pint) of water with positive energy, " +
                    "turning it into holy water.";
        }
        if(spellName.equalsIgnoreCase("Bless Weapon")) {
            text = "This transmutation makes a weapon strike true against evil foes. The weapon is " +
                    "treated as having a +1 enhancement bonus for the purpose of bypassing the DR " +
                    "of evil creatures or striking evil incorporeal creatures (though the spell " +
                    "doesn’t grant an actual enhancement bonus). The weapon also becomes good-aligned," +
                    " which means it can bypass the DR of certain creatures. (This effect overrides" +
                    " and suppresses any other alignment the weapon might have.) Individual arrows " +
                    "or bolts can be transmuted, but affected projectile weapons (such as bows) " +
                    "don’t confer the benefit to the projectiles they shoot.\n" +
                    "\n" +
                    "In addition, all critical hit rolls against evil foes are automatically " +
                    "successful, so every threat is a critical hit. This last effect does not " +
                    "apply to any weapon that already has a magical effect related to critical " +
                    "hits, such as a keen weapon or a vorpal sword.";
        }
        if(spellName.equalsIgnoreCase("Calm Animals")) {
            text = "This spell soothes and quiets animals, rendering them docile and harmless. Only ordinary animals (those with Intelligence scores of 1 or 2) can be affected by this spell. All the subjects must be of the same kind, and no two may be more than 30 feet apart. The maximum number of HD of animals you can affect is equal to 2d4 + caster level.\n" +
                    "\n" +
                    "The affected creatures remain where they are and do not attack or flee. They are not helpless and defend themselves normally if attacked. Any threat breaks the spell on the threatened creatures.";
        }
        if(spellName.equalsIgnoreCase("Charm Animal")) {
            text = "This spell functions like charm person, except that it affects a creature of the animal type.";
        }
        if(spellName.equalsIgnoreCase("Create Water")) {
            text = "This spell generates wholesome, drinkable water, just like clean rain water. Water can be created in an area as small as will actually contain the liquid, or in an area three times as large—possibly creating a downpour or filling many small receptacles. This water disappears after 1 day if not consumed.\n" +
                    "\n" +
                    "Note: Conjuration spells can't create substances or objects within a creature. Water weighs about 8 pounds per gallon. One cubic foot of water contains roughly 8 gallons and weighs about 60 pounds.";
        }
        if(spellName.equalsIgnoreCase("Cure Minor Wounds")) {
            text = "When laying your hand upon a living creature, you channel positive energy that cures 1d8 points of damage +1 point per caster level (maximum +5). Since undead are powered by negative energy, this spell deals damage to them instead of curing their wounds. An undead creature can apply Spell Resistance, and can attempt a Will save to take half damage.";
        }
        if(spellName.equalsIgnoreCase("Dancing Lights")) {
            text = "Depending on the version selected, you create up to four lights that resemble lanterns or torches (and cast that amount of light), or up to four glowing spheres of light (which look like will-o'-wisps), or one faintly glowing, vaguely humanoid shape. The dancing lights must stay within a 10-foot-radius area in relation to each other but otherwise move as you desire (no concentration required): forward or back, up or down, straight or turning corners, or the like. The lights can move up to 100 feet per round. A light winks out if the distance between you and it exceeds the spell's range.\n" +
                    "\n" +
                    "You can only have one dancing lights spell active at any one time. If you cast this spell while another casting is still in effect, the previous casting is dispelled. If you make this spell permanent, it does not count against this limit.\n" +
                    "\n" +
                    "Dancing lights can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Daze")) {
            text = "This spell clouds the mind of a humanoid creature with 4 or fewer Hit Dice so that it takes no actions. Humanoids of 5 or more HD are not affected. A dazed subject is not stunned, so attackers get no special advantage against it. After a creature has been dazed by this spell, it is immune to the effects of this spell for 1 minute.";
        }
        if(spellName.equalsIgnoreCase("Delay Poison")) {
            text = "The subject becomes temporarily immune to poison. Any poison in its system or any poison to which it is exposed during the spell's duration does not affect the subject until the spell's duration has expired. Delay poison does not cure any damage that poison may have already done.";
        }
        if(spellName.equalsIgnoreCase("Detect Animals/Plants")) {
            text = "You can detect a particular kind of animal or plant in a cone emanating out from you in whatever direction you face. You must think of a kind of animal or plant when using the spell, but you can change the animal or plant kind each round. The amount of information revealed depends on how long you search a particular area or focus on a specific kind of animal or plant.\n" +
                    "\n" +
                    "1st Round: Presence or absence of that kind of animal or plant in the area.\n" +
                    "\n" +
                    "2nd Round: Number of individuals of the specified kind in the area and the condition of the healthiest specimen.\n" +
                    "\n" +
                    "3rd Round: The condition (see below) and location of each individual present. If an animal or a plant is outside your line of sight, then you discern its direction but not its exact location.\n" +
                    "\n" +
                    "Conditions: For purposes of this spell, the categories of condition are as follows:\n" +
                    "\n" +
                    "Normal: Has at least 90% of full normal hit points, free of disease.\n" +
                    "\n" +
                    "Fair: 30% to 90% of full normal hit points remaining.\n" +
                    "\n" +
                    "Poor: Less than 30% of full normal hit points remaining, afflicted with a disease, or suffering from a debilitating injury.\n" +
                    "\n" +
                    "Weak: 0 or fewer hit points remaining, afflicted with a disease that has reduced an ability score to 5 or less, or crippled.\n" +
                    "\n" +
                    "If a creature falls into more than one category, the spell indicates the weaker of the two.\n" +
                    "\n" +
                    "Each round you can turn to detect a kind of animal or plant in a new area. The spell can penetrate barriers, but 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt blocks it.";
        }
        if(spellName.equalsIgnoreCase("Detect Magic")) {
            text = "You detect magical auras. The amount of information revealed depends on how long you study a particular area or subject.\n" +
                    "\n" +
                    "1st Round: Presence or absence of magical auras.\n" +
                    "\n" +
                    "2nd Round: Number of different magical auras and the power of the most potent aura.\n" +
                    "\n" +
                    "3rd Round: The strength and location of each aura. If the items or creatures bearing the auras are in line of sight, you can make Knowledge (arcana) skill checks to determine the school of magic involved in each. (Make one check per aura: DC 15 + spell level, or 15 + 1/2 caster level for a nonspell effect.) If the aura emanates from a magic item, you can attempt to identify its properties (see Spellcraft).\n" +
                    "\n" +
                    "Magical areas, multiple types of magic, or strong local magical emanations may distort or conceal weaker auras.\n" +
                    "\n" +
                    "Aura Strength: An aura's power depends on a spell's functioning spell level or an item's caster level; see the accompanying table. If an aura falls into more than one category, detect magic indicates the stronger of the two.\n" +
                    "\n" +
                    "Lingering Aura: A magical aura lingers after its original source dissipates (in the case of a spell) or is destroyed (in the case of a magic item). If detect magic is cast and directed at such a location, the spell indicates an aura strength of dim (even weaker than a faint aura). How long the aura lingers at this dim level depends on its original power:\n" +
                    "Original Strength\tDuration of Lingering Aura\n" +
                    "Faint\t1d6 rounds\n" +
                    "Moderate\t1d6 minutes\n" +
                    "Strong\t1d6 × 10 minutes\n" +
                    "Overwhelming\t1d6 days\n" +
                    "\n" +
                    "Outsiders and elementals are not magical in themselves, but if they are summoned, the conjuration spell registers. Each round, you can turn to detect magic in a new area. The spell can penetrate barriers, but 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt blocks it.\n" +
                    "\n" +
                    "Detect magic can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Detect Poison")) {
            text = "You determine whether a creature, object, or area has been poisoned or is poisonous. You can determine the exact type of poison with a DC 20 Wisdom check. A character with the Craft (alchemy) skill may try a DC 20 Craft (alchemy) check if the Wisdom check fails, or may try the Craft (alchemy) check prior to the Wisdom check. The spell can penetrate barriers, but 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt blocks it.";
        }
        if(spellName.equalsIgnoreCase("Detect Snares/Pits")) {
            text = "You can detect simple pits, deadfalls, and snares as well as mechanical traps constructed of natural materials. The spell does not detect complex traps, including trapdoor traps.\n" +
                    "\n" +
                    "Detect snares and pits does detect certain natural hazards—quicksand (a snare), a sinkhole (a pit), or unsafe walls of natural rock (a deadfall). It does not reveal other potentially dangerous conditions. The spell does not detect magic traps (except those that operate by pit, deadfall, or snaring; see the spell snare), nor mechanically complex ones, nor those that have been rendered safe or inactive.\n" +
                    "\n" +
                    "The amount of information revealed depends on how long you study a particular area.\n" +
                    "\n" +
                    "1st Round: Presence or absence of hazards.\n" +
                    "\n" +
                    "2nd Round: Number of hazards and the location of each. If a hazard is outside your line of sight, then you discern its direction but not its exact location.\n" +
                    "\n" +
                    "Each Additional Round: The general type and trigger for one particular hazard closely examined by you.\n" +
                    "\n" +
                    "Each round, you can turn to examine a new area. The spell can penetrate barriers, but 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt blocks it.";
        }
        if(spellName.equalsIgnoreCase("Detect Undead")) {
            text = "You can detect the aura that surrounds undead creatures. The amount of information revealed depends on how long you study a particular area.\n" +
                    "\n" +
                    "1st Round: Presence or absence of undead auras.\n" +
                    "\n" +
                    "2nd Round: Number of undead auras in the area and the strength of the strongest undead aura present. If you are of good alignment, and the strongest undead aura's strength is overwhelming (see below), and the creature has HD of at least twice your character level, you are stunned for 1 round and the spell ends.\n" +
                    "\n" +
                    "3rd Round: The strength and location of each undead aura. If an aura is outside your line of sight, then you discern its direction but not its exact location.\n" +
                    "\n" +
                    "Aura Strength: The strength of an undead aura is determined by the HD of the undead creature, as given on the table below.\n" +
                    "\n" +
                    "Lingering Aura: An undead aura lingers after its original source is destroyed. If detect undead is cast and directed at such a location, the spell indicates an aura strength of dim (even weaker than a faint aura). How long the aura lingers at this dim level depends on its original power, as given on the table below.\n" +
                    "HD\tStrength\tLingering Aura Duration\n" +
                    "1 or lower\tFaint\t1d6 rounds\n" +
                    "2–4\tModerate\t1d6 minutes\n" +
                    "5–10\tStrong\t1d6 × 10 minutes\n" +
                    "11 or higher\tOverwhelming\t1d6 days\n" +
                    "\n" +
                    "Each round, you can turn to detect undead in a new area. The spell can penetrate barriers, but 1 foot of stone, 1 inch of common metal, a thin sheet of lead, or 3 feet of wood or dirt blocks it.";
        }
        if(spellName.equalsIgnoreCase("Disrupt Undead")) {
            text = "You direct a ray of positive energy. You must make a ranged touch attack to hit, and if the ray hits an undead creature, it deals 1d6 points of damage to it.";
        }
        if(spellName.equalsIgnoreCase("Divine Favor")) {
            text = "Calling upon the strength and wisdom of a deity, you gain a +1 luck bonus on attack and weapon damage rolls for every three caster levels you have (at least +1, maximum +3). The bonus doesn't apply to spell damage.";
        }
        if(spellName.equalsIgnoreCase("Endure Elements")) {
            text = "A creature protected by endure elements suffers no harm from being in a hot or cold environment. It can exist comfortably in conditions between –50 and 140 degrees Fahrenheit without having to make Fortitude saves. The creature's equipment is likewise protected.\n" +
                    "\n" +
                    "Endure elements doesn't provide any protection from fire or cold damage, nor does it protect against other environmental hazards such as smoke, lack of air, and so forth.";
        }
        if(spellName.equalsIgnoreCase("Entangle")) {
            text = "This spell causes tall grass, weeds, and other plants to wrap around creatures in the area of effect or those that enter the area. Creatures that fail their save gain the entangled condition. Creatures that make their save can move as normal, but those that remain in the area must save again at the end of your turn. Creatures that move into the area must save immediately. Those that fail must end their movement and gain the entangled condition. Entangled creatures can attempt to break free as a move action, making a Strength or Escape Artist check. The DC for this check is equal to the DC of the spell. The entire area of effect is considered difficult terrain while the effect lasts.\n" +
                    "\n" +
                    "If the plants in the area are covered in thorns, those in the area take 1 point of damage each time they fail a save against the entangle or fail a check made to break free. Other effects, depending on the local plants, might be possible at GM discretion.";
        }
        if(spellName.equalsIgnoreCase("Hide from Animals")) {
            text = "Animals cannot sense the warded creatures. Even extraordinary or supernatural sensory capabilities, such as blindsense, blindsight, scent, and tremorsense, cannot detect or locate warded creatures. Animals simply act as though the warded creatures are not there. If a warded character touches an animal or attacks any creature, even with a spell, the spell ends for all recipients.";
        }
        if(spellName.equalsIgnoreCase("Flare")) {
            text = "This cantrip creates a burst of light. If you cause the light to burst in front of a single creature, that creature is dazzled for 1 minute unless it makes a successful Fortitude save. Sightless creatures, as well as creatures already dazzled, are not affected by flare.";
        }
        if(spellName.equalsIgnoreCase("Ghost Sound")) {
            text = "Ghost sound allows you to create a volume of sound that rises, recedes, approaches, or remains at a fixed place. You choose what type of sound ghost sound creates when casting it and cannot thereafter change the sound's basic character.\n" +
                    "\n" +
                    "The volume of sound created depends on your level. You can produce as much noise as four normal humans per caster level (maximum 40 humans). Thus, talking, singing, shouting, walking, marching, or running sounds can be created. The noise a ghost sound spell produces can be virtually any type of sound within the volume limit. A horde of rats running and squeaking is about the same volume as eight humans running and shouting. A roaring lion is equal to the noise from 16 humans, while a roaring dragon is equal to the noise from 32 humans. Anyone who hears a ghost sound receives a Will save to disbelieve.\n" +
                    "\n" +
                    "Ghost sound can enhance the effectiveness of a silent image spell.\n" +
                    "\n" +
                    "Ghost sound can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Guidance")) {
            text = "This spell imbues the subject with a touch of divine guidance. The creature gets a +1 competence bonus on a single attack roll, saving throw, or skill check. It must choose to use the bonus before making the roll to which it applies.";
        }
        if(spellName.equalsIgnoreCase("Inflict Minor Wounds")) {
            text = "When laying your hand upon a creature, you channel negative energy that deals 1d8 points of damage + 1 point per caster level (maximum +5).\n" +
                    "\n" +
                    "Since undead are powered by negative energy, this spell cures such a creature of a like amount of damage, rather than harming it.";
        }
        if(spellName.equalsIgnoreCase("Jump")) {
            text = "The subject gets a +10 enhancement bonus on Acrobatics checks made to attempt high jumps or long jumps. The enhancement bonus increases to +20 at caster level 5th, and to +30 (the maximum) at caster level 9th.";
        }
        if(spellName.equalsIgnoreCase("Know Direction")) {
            text = "When you cast this spell, you instantly know the direction of north from your current position. The spell is effective in any environment in which \"north\" exists, but it may not work in extraplanar settings. Your knowledge of north is correct at the moment of casting, but you can get lost again within moments if you don't find some external reference point to help you keep track of direction.";
        }
        if(spellName.equalsIgnoreCase("Light")) {
            text = "This spell causes a touched object to glow like a torch, shedding normal light in a 20-foot radius from the point touched, and increasing the light level for an additional 20 feet by one step, up to normal light (darkness becomes dim light, and dim light becomes normal light). In an area of normal or bright light, this spell has no effect. The effect is immobile, but it can be cast on a movable object.\n" +
                    "\n" +
                    "You can only have one light spell active at any one time. If you cast this spell while another casting is still in effect, the previous casting is dispelled. If you make this spell permanent (through permanency or a similar effect), it does not count against this limit. Light can be used to counter or dispel any darkness spell of equal or lower spell level.";
        }
        if(spellName.equalsIgnoreCase("Longstrider")) {
            text = "This spell gives you a +10 foot enhancement bonus to your base speed. It has no effect on other modes of movement, such as burrow, climb, fly, or swim.";
        }
        if(spellName.equalsIgnoreCase("Lullaby")) {
            text = "Any creature within the area that fails a Will save becomes drowsy and inattentive, taking a –5 penalty on Perception checks and a –2 penalty on Will saves against sleep effects while the lullaby is in effect. Lullaby lasts for as long as the caster concentrates, plus up to 1 round per caster level thereafter.";
        }
        if(spellName.equalsIgnoreCase("Mage Hand")) {
            text = "You point your finger at an object and can lift it and move it at will from a distance. As a move action, you can propel the object as far as 15 feet in any direction, though the spell ends if the distance between you and the object ever exceeds the spell's range.";
        }
        if(spellName.equalsIgnoreCase("Magic Fang")) {
            text = "Magic fang gives one natural weapon or unarmed strike of the subject a +1 enhancement bonus on attack and damage rolls. The spell can affect a slam attack, fist, bite, or other natural weapon. The spell does not change an unarmed strike's damage from nonlethal damage to lethal damage.\n" +
                    "\n" +
                    "Magic fang can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Magic Weapon")) {
            text = "Magic weapon gives a weapon a +1 enhancement bonus on attack and damage rolls. An enhancement bonus does not stack with a masterwork weapon's +1 bonus on attack rolls.\n" +
                    "\n" +
                    "You can't cast this spell on a natural weapon, such as an unarmed strike (instead, see magic fang). A monk's unarmed strike is considered a weapon, and thus it can be enhanced by this spell.";
        }
        if(spellName.equalsIgnoreCase("Mending")) {
            text = "This spell repairs damaged objects, restoring 1d4 hit points to the object. If the object has the broken condition, this condition is removed if the object is restored to at least half its original hit points. All of the pieces of an object must be present for this spell to function. Magic items can be repaired by this spell, but you must have a caster level equal to or higher than that of the object. Magic items that are destroyed (at 0 hit points or less) can be repaired with this spell, but this spell does not restore their magic abilities. This spell does not affect creatures (including constructs). This spell has no effect on objects that have been warped or otherwise transmuted, but it can still repair damage done to such items.";
        }
        if(spellName.equalsIgnoreCase("Message")) {
            text = "You can whisper messages and receive whispered replies. Those nearby can hear these messages with a DC 25 Perception check. You point your finger at each creature you want to receive the message. When you whisper, the whispered message is audible to all targeted creatures within range. Magical silence, 1 foot of stone, 1 inch of common metal (or a thin sheet of lead), or 3 feet of wood or dirt blocks the spell. The message does not have to travel in a straight line. It can circumvent a barrier if there is an open path between you and the subject, and the path's entire length lies within the spell's range. The creatures that receive the message can whisper a reply that you hear. The spell transmits sound, not meaning; it doesn't transcend language barriers. To speak a message, you must mouth the words and whisper.";
        }
        if(spellName.equalsIgnoreCase("Open/Close")) {
            text = "You can open or close (your choice) a door, chest, box, window, bag, pouch, bottle, barrel, or other container. If anything resists this activity (such as a bar on a door or a lock on a chest), the spell fails. In addition, the spell can only open and close things weighing 30 pounds or less. Thus, doors, chests, and similar objects sized for enormous creatures may be beyond this spell's ability to affect.";
        }
        if(spellName.equalsIgnoreCase("Pass without Trace")) {
            text = "The subject or subjects of this spell do not leave footprints or a scent trail while moving. Tracking the subjects is impossible by nonmagical means.";
        }
        if(spellName.equalsIgnoreCase("Prestidigitation")) {
            text = "Prestidigitations are minor tricks that novice spellcasters use for practice. Once cast, a prestidigitation spell enables you to perform simple magical effects for 1 hour. The effects are minor and have severe limitations. A prestidigitation can slowly lift 1 pound of material. It can color, clean, or soil items in a 1-foot cube each round. It can chill, warm, or flavor 1 pound of nonliving material. It cannot deal damage or affect the concentration of spellcasters. Prestidigitation can create small objects, but they look crude and artificial. The materials created by a prestidigitation spell are extremely fragile, and they cannot be used as tools, weapons, or spell components. Finally, prestidigitation lacks the power to duplicate any other spell effects. Any actual change to an object (beyond just moving, cleaning, or soiling it) persists only 1 hour.";
        }
        if(spellName.equalsIgnoreCase("Protection From Chaos/Evil")) {
            text = "The bonuses to AC and on saves increase to +4. Any evil creature attempting to possess or exercise mental control over the target must attempt a Will save against this spell. If it fails, the creature takes 1d6 points of damage per 2 caster levels (maximum 5d6) from mental feedback. An evil creature that uses spell resistance to bypass the spell's protection against contact must successfully save or take this damage once each round it attacks the protected target.";
        }
        if(spellName.equalsIgnoreCase("Purify Food and Drink")) {
            text = "This spell makes spoiled, rotten, diseased, poisonous, or otherwise contaminated food and water pure and suitable for eating and drinking. This spell does not prevent subsequent natural decay or spoilage. Unholy water and similar food and drink of significance is spoiled by purify food and drink, but the spell has no effect on creatures of any type nor upon magic potions. Water weighs about 8 pounds per gallon. One cubic foot of water contains roughly 8 gallons and weighs about 60 pounds.";
        }
        if(spellName.equalsIgnoreCase("Ray of Frost")) {
            text = "A ray of freezing air and ice projects from your pointing finger. You must succeed on a ranged touch attack with the ray to deal damage to a target. The ray deals 1d3 points of cold damage.";
        }
        if(spellName.equalsIgnoreCase("Read Magic")) {
            text = "You can decipher magical inscriptions on objects—books, scrolls, weapons, and the like—that would otherwise be unintelligible. This deciphering does not normally invoke the magic contained in the writing, although it may do so in the case of a cursed or trapped scroll. Furthermore, once the spell is cast and you have read the magical inscription, you are thereafter able to read that particular writing without recourse to the use of read magic. You can read at the rate of one page (250 words) per minute. The spell allows you to identify a glyph of warding with a DC 13 Spellcraft check, a greater glyph of warding with a DC 16 Spellcraft check, or any symbol spell with a Spellcraft check (DC 10 + spell level).\n" +
                    "\n" +
                    "Read magic can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Resistance")) {
            text = "You imbue the subject with magical energy that protects it from harm, granting it a +1 resistance bonus on saves.\n" +
                    "\n" +
                    "Resistance can be made permanent with a permanency spell.";
        }
        if(spellName.equalsIgnoreCase("Resist Energy")) {
            text = "This abjuration grants a creature limited protection from damage of whichever one of five energy types you select: acid, cold, electricity, fire, or sonic. The subject gains resist energy 10 against the energy type chosen, meaning that each time the creature is subjected to such damage (whether from a natural or magical source), that damage is reduced by 10 points before being applied to the creature's hit points. The value of the energy resistance granted increases to 20 points at 7th level and to a maximum of 30 points at 11th level. The spell protects the recipient's equipment as well.\n" +
                    "\n" +
                    "Resist energy absorbs only damage. The subject could still suffer unfortunate side effects.\n" +
                    "\n" +
                    "Resist energy overlaps (and does not stack with) protection from energy. If a character is warded by protection from energy and resist energy, the protection spell absorbs damage until its power is exhausted.";
        }
        if(spellName.equalsIgnoreCase("Restoration, Lesser")) {
            text = "Lesser restoration dispels any magical effects reducing one of the subject's ability scores or cures 1d4 points of temporary ability damage to one of the subject's ability scores. It also eliminates any fatigue suffered by the character, and improves an exhausted condition to fatigued. It does not restore permanent ability drain.";
        }
        if(spellName.equalsIgnoreCase("Speak with Animals")) {
            text = "You can ask questions of and receive answers from animals, but the spell doesn't make them any more friendly than normal. Wary and cunning animals are likely to be terse and evasive, while the more stupid ones make inane comments. If an animal is friendly toward you, it may do some favor or service for you.";
        }
        if(spellName.equalsIgnoreCase("Summon Instrument")) {
            text = "This spell summons one handheld musical instrument of your choice. This instrument appears in your hands or at your feet (your choice). The instrument is typical for its type. Only one instrument appears per casting, and it will play only for you. You can't summon an instrument too large to be held in two hands. The summoned instrument disappears at the end of this spell.";
        }
        if(spellName.equalsIgnoreCase("Summon Nature's Ally I")) {
            text = "This spell summons to your side a natural creature (typically an animal, fey, magical beast, outsider with the elemental subtype, or a giant). The summoned ally appears where you designate and acts immediately, on your turn. It attacks your opponents to the best of its ability. If you can communicate with the creature, you can direct it not to attack, to attack particular enemies, or to perform other actions as you command.\n" +
                    "\n" +
                    "A summoned monster cannot summon or otherwise conjure another creature, nor can it use any teleportation or planar travel abilities. Creatures cannot be summoned into an environment that cannot support them. Creatures summoned using this spell cannot use spells or spell-like abilities that duplicate spells that have expensive material components (such as wish).\n" +
                    "\n" +
                    "The spell conjures one of the creatures from the 1st Level list on Table 10–2. You choose which kind of creature to summon, and you can change that choice each time you cast the spell. All the creatures on the table are neutral unless otherwise noted.\n" +
                    "\n" +
                    "When you use a summoning spell to summon a creature with an alignment or elemental subtype, it is a spell of that type. All creatures summoned with this spell without alignment subtypes have an alignment that matches yours, regardless of their usual alignment. Summoning these creatures makes the summoning spell's type match your alignment. ";
            text = text + "Dire rat\t—\n" +
                    "Dog\t—\n" +
                    "Dolphin\t—\n" +
                    "Eagle\t—\n" +
                    "Giant centipede\t—\n" +
                    "Fire beetle\t—\n" +
                    "Mite (gremlin)\t—\n" +
                    "Poisonous frog\t—\n" +
                    "Pony (horse)\t—\n" +
                    "Stirge\t—\n" +
                    "Viper (snake)";
        }
        if(spellName.equalsIgnoreCase("Touch of Fatigue")) {
            text = "You channel negative energy through your touch, fatiguing the target. You must succeed on a touch attack to strike a target. The subject is immediately fatigued for the spell's duration.\n" +
                    "\n" +
                    "This spell has no effect on a creature that is already fatigued. Unlike with normal fatigue, the effect ends as soon as the spell's duration expires.";
        }
        if(spellName.equalsIgnoreCase("Virtue")) {
            text = "With a touch, you infuse a creature with a tiny surge of life, granting the subject 1 temporary hit point.";
        }
        if(spellName.equalsIgnoreCase("Conjure Elemental")) {
            text = "You call forth an elemental servant.\n" +
                    "Choose an area of air, earth, fire, or water that fills a 10-foot cube within range. An elemental of challenge rating 5 or lower appropriate to the area you chose appears in an unoccupied space within 10 feet of it. For example, a fire elemental emerges from a bonfire, and an earth elemental rises up from the ground. The elemental disappears when it drops to 0 hit points or when the spell ends.\n" +
                    "\n" +
                    "The elemental is friendly to you and your companions for the duration. Roll initiative for the elemental, which has its own turns. It obeys any verbal commands that you issue to it (no action required by you). If you don’t issue any commands to the elemental, it defends itself from hostile creatures but otherwise takes no actions.\n" +
                    "\n" +
                    "If your concentration is broken, the elemental doesn’t disappear. Instead, you lose control of the elemental, it becom es hostile toward you and your companions, and it might attack. An uncontrolled elemental can’t be dismissed by you, and it disappears 1 hour after you summoned it. The DM has the elemental’s statistics. ";
        }
        if(spellName.equalsIgnoreCase("Maze")) {
            text = "You banish the subject into an extradimensional labyrinth. Each round on its turn, it may attempt a DC 20 Intelligence check to escape the labyrinth as a full-round action. If the subject doesn't escape, the maze disappears after 10 minutes, freeing the subject.\n" +
                    "\n" +
                    "On escaping or leaving the maze, the subject reappears where it had been when the maze spell was cast. If this location is filled with a solid object, the subject appears in the nearest open space. Spells and abilities that move a creature within a plane, such as teleport and dimension door, do not help a creature escape a maze spell, although a plane shift spell allows it to exit to whatever plane is designated in that spell. Minotaurs are not affected by this spell.";
        }
        if(spellName.equalsIgnoreCase("Magic Circle")) {
            text = "All creatures within the area gain the effects of a protection from evil spell, and evil summoned creatures cannot enter the area either. Creatures in the area, or who later enter the area, receive only one attempt to suppress effects that are controlling them. If successful, such effects are suppressed as long as they remain in the area. Creatures that leave the area and come back are not protected. You must overcome a creature's spell resistance in order to keep it at bay (as in the third function of protection from evil), but the deflection and resistance bonuses and the protection from mental control apply regardless of enemies' spell resistance.\n" +
                    "\n" +
                    "This spell has an alternative version that you may choose when casting it. A magic circle against evil can be focused inward rather than outward. When focused inward, the spell binds a nongood called creature (such as those called by the lesser planar binding, planar binding, and greater planar binding spells) for a maximum of 24 hours per caster level, provided that you cast the spell that calls the creature within 1 round of casting the magic circle. The creature cannot cross the circle's boundaries. If a creature too large to fit into the spell's area is the subject of the spell, the spell acts as a normal protection from evil spell for that creature only.\n" +
                    "\n" +
                    "A magic circle leaves much to be desired as a trap. If the circle of powdered silver laid down in the process of spellcasting is broken, the effect immediately ends. The trapped creature can do nothing that disturbs the circle, directly or indirectly, but other creatures can. If the called creature has spell resistance, it can test the trap once a day. If you fail to overcome its spell resistance, the creature breaks free, destroying the circle. A creature capable of any form of dimensional travel (astral projection, blink, dimension door, etherealness, gate, plane shift, shadow walk, teleport, and similar abilities) can simply leave the circle through such means. You can prevent the creature's extradimensional escape by casting a dimensional anchor spell on it, but you must cast the spell before the creature acts. If you are successful, the anchor effect lasts as long as the magic circle does. The creature cannot reach across the magic circle, but its ranged attacks (ranged weapons, spells, magical abilities, and the like) can. The creature can attack any target it can reach with its ranged attacks except for the circle itself.\n" +
                    "\n" +
                    "You can add a special diagram (a two-dimensional bounded figure with no gaps along its circumference, augmented with various magical sigils) to make the magic circle more secure. Drawing the diagram by hand takes 10 minutes and requires a DC 20 Spellcraft check. You do not know the result of this check. If the check fails, the diagram is ineffective. You can take 10 when drawing the diagram if you are under no particular time pressure to complete the task. This task also takes 10 full minutes. If time is no factor at all, and you devote 3 hours and 20 minutes to the task, you can take 20.\n" +
                    "\n" +
                    "A successful diagram allows you to cast a dimensional anchor spell on the magic circle during the round before casting any summoning spell. The anchor holds any called creatures in the magic circle for 24 hours per caster level. A creature cannot use its spell resistance against a magic circle prepared with a diagram, and none of its abilities or attacks can cross the diagram. If the creature tries a Charisma check to break free of the trap (see the lesser planar binding spell), the DC increases by 5. The creature is immediately released if anything disturbs the diagram—even a straw laid across it. The creature itself cannot disturb the diagram either directly or indirectly, as noted above.\n" +
                    "\n" +
                    "This spell is not cumulative with protection from evil and vice versa.";
        }
        if(spellName.equalsIgnoreCase("Gaseous Form")) {
            text = "The subject and all its gear become insubstantial, misty, and translucent. Its material armor (including natural armor) becomes worthless, though its size, Dexterity, deflection bonuses, and armor bonuses from force effects still apply. The subject gains DR 10/magic and becomes immune to poison, sneak attacks, and critical hits. It can't attack or cast spells with verbal, somatic, material, or focus components while in gaseous form. This does not rule out the use of certain spells that the subject may have prepared using the feats Silent Spell, Still Spell, and Eschew Materials. The subject also loses supernatural abilities while in gaseous form. If it has a touch spell ready to use, that spell is discharged harmlessly when the gaseous form spell takes effect.\n" +
                    "\n" +
                    "A gaseous creature can't run, but it can fly at a speed of 10 feet and automatically succeeds on all Fly skill checks. It can pass through small holes or narrow openings, even mere cracks, with all it was wearing or holding in its hands, as long as the spell persists. The creature is subject to the effects of wind, and it can't enter water or other liquid. It also can't manipulate objects or activate items, even those carried along with its gaseous form. Continuously active items remain active, though in some cases their effects may be moot.";
        }
        if(spellName.equalsIgnoreCase("Telekinesis")) {
            text = "You move objects or creatures by concentrating on them. Depending on the version selected, the spell can provide a gentle, sustained force, perform a variety of combat maneuvers, or exert a single short, violent thrust.\n" +
                    "\n" +
                    "Sustained Force: A sustained force moves an object weighing no more than 25 pounds per caster level (maximum 375 pounds at 15th level) up to 20 feet per round. A creature can negate the effect on an object it possesses with a successful Will save or with spell resistance.\n" +
                    "\n" +
                    "This version of the spell can last 1 round per caster level, but it ends if you cease concentration. The weight can be moved vertically, horizontally, or in both directions. An object cannot be moved beyond your range. The spell ends if the object is forced beyond the range. If you cease concentration for any reason, the object falls or stops.\n" +
                    "\n" +
                    "An object can be telekinetically manipulated as if with one hand. For example, a lever or rope can be pulled, a key can be turned, an object rotated, and so on, if the force required is within the weight limitation. You might even be able to untie simple knots, though delicate activities such as these require DC 15 Intelligence checks.\n" +
                    "\n" +
                    "Combat Maneuver: Alternatively, once per round, you can use telekinesis to perform a bull rush, disarm, grapple (including pin), or trip. Resolve these attempts as normal, except that they don't provoke attacks of opportunity, you use your caster level in place of your Combat Maneuver Bonus, and you add your Intelligence modifier (if a wizard) or Charisma modifier (if a sorcerer) in place of your Strength or Dexterity modifier. No save is allowed against these attempts, but spell resistance applies normally. This version of the spell can last 1 round per caster level, but it ends if you cease concentration.\n" +
                    "\n" +
                    "Violent Thrust: Alternatively, the spell energy can be spent in a single round. You can hurl one object or creature per caster level (maximum 15) that are within range and all within 10 feet of each other toward any target within 10 feet per level of all the objects. You can hurl up to a total weight of 25 pounds per caster level (maximum 375 pounds at 15th level).\n" +
                    "\n" +
                    "You must succeed on attack rolls (one per creature or object thrown) to hit the target with the items, using your base attack bonus + your Intelligence modifier (if a wizard) or Charisma modifier (if a sorcerer). Weapons cause standard damage (with no Strength bonus; note that arrows or bolts deal damage as daggers of their size when used in this manner). Other objects cause damage ranging from 1 point per 25 pounds (for less dangerous objects) to 1d6 points of damage per 25 pounds (for hard, dense objects). Objects and creatures that miss their target land in a square adjacent to the target.\n" +
                    "\n" +
                    "Creatures who fall within the weight capacity of the spell can be hurled, but they are allowed Will saves (and spell resistance) to negate the effect, as are those whose held possessions are targeted by the spell.\n" +
                    "\n" +
                    "If a telekinesed creature is hurled against a solid surface, it takes damage as if it had fallen 10 feet (1d6 points).";
        }
        if(spellName.equalsIgnoreCase("Evard's Black Tentacle")) {
            text = "This spell causes a field of rubbery black tentacles to appear, burrowing up from the floor and reaching for any creature in the area.\n" +
                    "\n" +
                    "Every creature within the area of the spell is the target of a combat maneuver check made to grapple each round at the beginning of your turn, including the round that black tentacles is cast. Creatures that enter the area of effect are also automatically attacked. The tentacles do not provoke attacks of opportunity. When determining the tentacles’ CMB, the tentacles use your caster level as their base attack bonus and receive a +4 bonus due to their Strength and a +1 size bonus. Roll only once for the entire spell effect each round and apply the result to all creatures in the area of effect.\n" +
                    "\n" +
                    "If the tentacles succeed in grappling a foe, that foe takes 1d6+4 points of damage and gains the grappled condition. Grappled opponents cannot move without first breaking the grapple. All other movement is prohibited unless the creature breaks the grapple first. The black tentacles spell receives a +5 bonus on grapple checks made against opponents it is already grappling, but cannot move foes or pin foes. Each round that black tentacles succeeds on a grapple check, it deals an additional 1d6+4 points of damage. The CMD of black tentacles, for the purposes of escaping the grapple, is equal to 10 + its CMB.\n" +
                    "\n" +
                    "The tentacles created by this spell cannot be damaged, but they can be dispelled as normal. The entire area of effect is considered difficult terrain while the tentacles last.";
        }
        if(spellName.equalsIgnoreCase("DruidCraft")) {
            text = "Whispering to the spirits of nature, you create one of the following effects within range:\n" +
                    "\n" +
                    "• You create a tiny, harmless sensory effect that predicts what the weather will be at your location for the next 24 hours. The effect might manifest as a golden orb  for clear skies, a cloud for rain, falling snowflakes for snow, and so on. This effect persists for 1 round.\n" +
                    "• You instantly make a flower blossom, a seed pod open, or a leaf bud bloom.\n" +
                    "• You create an instantaneous, harmless sensory effect, such as falling leaves, a puff of wind, the sound of a small animal, or the faint odor of skunk. The effect  must fit in a 5-foot cube.\n" +
                    "• You instantly light or snuff out a candle, a torch, or a small campfire. ";
        }
        if(spellName.equalsIgnoreCase("Hex")) {
            text = "You place a curse on a creature that you can see within range. Until the spell ends, you deal an extra 1d6 necrotic damage to the target whenever you hit it with an attack. Also, choose one ability when you cast the spell. The target has disadvantage on ability checks made with the chosen ability.\n" +
                    "\n" +
                    "If the target drops to 0 hit points before this spell ends, you can use a bonus action on a subsequent turn of yours to curse a new creature.\n" +
                    "\n" +
                    "A remove curse cast on the target ends this spell early. ";
        }
        if(spellName.equalsIgnoreCase("Witch Bolt")) {
            text = "A beam of crackling, blue energy lances out toward a creature within range, forming a sustained arc of lightning between you and the target.\n" +
                    "Make a ranged spell attack against that creature. On a hit, the target takes 1d12 lightning damage, and on each of your turns for the duration, you can use your action to deal 1d12 lightning damage to the target automatically. The spell ends if you use your action to do anything else. The spell also ends if the target is ever outside the spell’s range or if it has total cover from you. ";
        }
        if(spellName.equalsIgnoreCase("Time Stop")) {
            text = "You briefly stop the flow of time for everyone but yourself. No time passes for other creatures, while you take 1d4 + 1 turns in a row, during which you can use actions and move as normal.\n" +
                    "\n" +
                    "This spell ends if one of the actions you use during this period, or any effects that you create during this period, affects a creature other than you or an object being worn or carried by someone other than you. In addition, the spell ends if you move to a place more than 1,000 feet from the location where you cast it. ";
        }
        description.setText(text);
    }
}
