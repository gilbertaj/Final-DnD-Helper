package com.example.najia13.tester.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.jawnnypoo.physicslayout.Physics;
import com.jawnnypoo.physicslayout.PhysicsRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceActivity extends AppCompatActivity implements OnItemSelectedListener {

    PhysicsRelativeLayout physicsLayout;
    ImageView floor;
    Context mcontext = this;
    int nextIdBlock;
    int nextIdTarget;
    int myarncount;
    int gameScore;
    TextView score;
    Spinner spDiceSelection;
    Spinner spNumOfDice;

    //1 is added to fix random number generator error
    static final int D20_MAX_ROLL = 21;
    static final int D12_MAX_ROLL = 13;
    static final int D10_MAX_ROLL = 11;
    static final int D8_MAX_ROLL = 9;
    static final int D6_MAX_ROLL = 7;
    static final int D4_MAX_ROLL = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_physics);
        gameScore = 0;
        physicsLayout = (PhysicsRelativeLayout) findViewById(R.id.physicsLayout);
        score = (TextView) findViewById(R.id.tvScore);
        physicsLayout.getPhysics().enableFling();
        floor = (ImageView) findViewById(R.id.ivFloor);
        nextIdBlock = 0;
        nextIdTarget = 1;
        myarncount = 1;

        //TODO create test for spinner
        setDiceSelectionSpinner();
        setNumberOfDiceSpinner();
        addImage();

        physicsLayout.getPhysics().setOnCollisionListener(new Physics.OnCollisionListener() {
            @Override
            public void onCollisionEntered(int viewIdA, int viewIdB) {

            }

            @Override
            public void onCollisionExited(int viewIdA, int viewIdB) {

            }
        });
        physicsLayout.getPhysics().setOnFlingListener(new Physics.OnFlingListener() {
            @Override
            public void onGrabbed(View grabbedView) {
            }

            @Override
            public void onReleased(View releasedView) {
                rollDice();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        //String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    //Adds the dice image and applies the physics layout to it
    public void addImage() {
        ImageView iv = new ImageView(mcontext);
        iv.setId(nextIdBlock);
        nextIdBlock += 2;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(300, 300);
        iv.setBackgroundResource(R.drawable.d20teal);
        physicsLayout.addView(iv, params);
    }

    //Gives the dice selection spinner values and sets its layout type
    private void setDiceSelectionSpinner() {
        spDiceSelection = (Spinner) findViewById((R.id.spDiceList));
        spDiceSelection.setOnItemSelectedListener(this);
        List<String> diceTypes = new ArrayList<>();
        diceTypes.add("D20");   //Rolls between 1-20
        diceTypes.add("D12");   //Rolls between 1-12
        diceTypes.add("D10");   //Rolls between 1-10
        diceTypes.add("D8");    //Rolls between 1-8
        diceTypes.add("D6");    //Rolls between 1-6
        diceTypes.add("D4");    //Rolls between 1-4

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,R.layout.spinner_item,diceTypes);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spDiceSelection.setAdapter(dataAdapter);
    }

    //Gives the number of dice to throw spinner values and sets its layout type
    private void setNumberOfDiceSpinner() {
        spNumOfDice = (Spinner)findViewById((R.id.spNumberToRoll));
        spNumOfDice.setOnItemSelectedListener(this);
        List<Integer> numOfDice = new ArrayList<>();
        numOfDice.add(1);   //Throw 1 dice
        numOfDice.add(2);   //Throw 2 die
        numOfDice.add(3);   //Throw 3 die
        numOfDice.add(4);   //Throw 4 die
        numOfDice.add(5);   //Throw 5 die

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(
                this,R.layout.spinner_item,numOfDice);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spNumOfDice.setAdapter(dataAdapter);
    }

    //Checks which dice to roll based on the spDiceSelection spinner
    //Checks how many times to roll based on the spNumOfDice spinner
    //Runs the roll method based on the dice that's selected and stores them in an array list
    private void rollDice() {
        int rndNumber;
        int numOfRolls = spNumOfDice.getSelectedItemPosition() + 1;
        int selectedDice = spDiceSelection.getSelectedItemPosition();
        List<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < numOfRolls; i++) {
            switch (selectedDice) {
                case 0: //D20
                    rndNumber = checkNumberValidity(D20_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                case 1: //D12
                    rndNumber = checkNumberValidity(D12_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                case 2: //D10
                    rndNumber = checkNumberValidity(D10_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                case 3: //D8
                    rndNumber = checkNumberValidity(D8_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                case 4: //D6
                    rndNumber = checkNumberValidity(D6_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                case 5: //D4
                    rndNumber = checkNumberValidity(D4_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
                default:
                    rndNumber = checkNumberValidity(D20_MAX_ROLL);
                    rolls.add(rndNumber);
                    break;
            }
        }

        printScore(rolls);
    }

    //Checks to make sure the roll is not 0
    private int checkNumberValidity(int num) {
        int number;
        Random rnd = new Random();

        do {
            number = rnd.nextInt(num);
        }
        while (number == 0);

        //Assertion Statements to check that the roll is within
        //the range of the dice selected and greater than zero
        assert (number >= 1);
        assert (number < num);
        return number;
    }

    private void printScore(List<Integer> rolls) {
        //Creates a string and lists all the roll values
        String scoreString = "| ";
        for (int e : rolls) {
            scoreString += e + " | ";
        }
        score.setText(scoreString);
    }

}
