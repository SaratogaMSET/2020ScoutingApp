package com.example.officialscoutingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class NotesActivity extends AppCompatActivity {

    TextView scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        scores = findViewById(R.id.scoredisp);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        Button drivingNA = findViewById(R.id.hangNA);
        Button drivingGood = findViewById(R.id.hangGood);
        Button drivingBad = findViewById(R.id.hangBad);
        Button drivingAverage = findViewById(R.id.hangAverage);


        Button defenseNA = findViewById(R.id.defenseNA);
        Button defenseGood = findViewById(R.id.defenseGood);
        Button defenseBad = findViewById(R.id.defenseBad);
        Button defenseAverage = findViewById(R.id.defenseAverage);

        // scores.setText(Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void clearAllDrive()
    {
        Variables.filledDrive = false;

        findViewById(R.id.hangNA).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DNAr = 255;
        Variables.DNAg = 255;
        Variables.DNAb = 255;
        Variables.drivingNA = false;

        findViewById(R.id.hangGood).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DGr = 255;
        Variables.DGg = 255;
        Variables.DGb = 255;
        Variables.drivingGood = false;

        findViewById(R.id.hangBad).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DBr = 255;
        Variables.DBg = 255;
        Variables.DBb = 255;
        Variables.drivingBad = false;

        findViewById(R.id.hangAverage).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DAr = 255;
        Variables.DAg = 255;
        Variables.DAb = 255;
        Variables.drivingAverage = false;
    }

    public void drivingNAClicked(View v) {
        Button b = (Button) v;



        if(Variables.DNAr == 21 && Variables.DNAg == 141 && Variables.DNAb == 14){

            findViewById(R.id.hangNA).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DNAr = 255;
            Variables.DNAg = 255;
            Variables.DNAb = 255;
            Variables.drivingNA = false;
            Variables.filledDrive = false;
        }


        else{
            clearAllDrive();
            findViewById(R.id.hangNA).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DNAr = 21;
            Variables.DNAg = 141;
            Variables.DNAb = 14;
            Variables.drivingNA = true;

            Variables.filledDrive = true;
        }
    }

    public void drivingGoodClicked(View v) {
        Button b = (Button) v;

        if(Variables.DGr == 21 && Variables.DGg == 141 && Variables.DGb == 14){

            findViewById(R.id.hangGood).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DGr = 255;
            Variables.DGg = 255;
            Variables.DGb = 255;
            Variables.drivingGood = false;
            Variables.filledDrive = false;
        }


        else{
            clearAllDrive();
            findViewById(R.id.hangGood).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DGr = 21;
            Variables.DGg = 141;
            Variables.DGb = 14;
            Variables.drivingGood = true;

            Variables.filledDrive = true;
        }
    }

    public void drivingBadClicked(View v) {
        Button b = (Button) v;

        if(Variables.DBr == 21 && Variables.DBg == 141 && Variables.DBb == 14){

            findViewById(R.id.hangBad).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DBr = 255;
            Variables.DBg = 255;
            Variables.DBb = 255;
            Variables.drivingBad = false;
            Variables.filledDrive = false;
        }


        else{
            clearAllDrive();
            findViewById(R.id.hangBad).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DBr = 21;
            Variables.DBg = 141;
            Variables.DBb = 14;
            Variables.drivingBad = true;

            Variables.filledDrive = true;
        }
    }

    public void drivingAverageClicked(View v) {
        Button b = (Button) v;

        if(Variables.DAr == 21 && Variables.DAg == 141 && Variables.DAb == 14){

            findViewById(R.id.hangAverage).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DAr = 255;
            Variables.DAg = 255;
            Variables.DAb = 255;
            Variables.drivingAverage = false;
            Variables.filledDrive = false;
        }


        else{
            clearAllDrive();
            findViewById(R.id.hangAverage).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DAr = 21;
            Variables.DAg = 141;
            Variables.DAb = 14;
            Variables.drivingAverage = true;

            Variables.filledDrive = true;
        }
    }



    public void clearAllDef()
    {
        Variables.filledDef = false;
        findViewById(R.id.defenseNA).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DefNAr = 255;
        Variables.DefNAg = 255;
        Variables.DefNAb = 255;
        Variables.defenseNA = false;

        findViewById(R.id.defenseGood).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DefGr = 255;
        Variables.DefGg = 255;
        Variables.DefGb = 255;
        Variables.defenseGood = false;

        findViewById(R.id.defenseBad).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DefBr = 255;
        Variables.DefBg = 255;
        Variables.DefBb = 255;
        Variables.defenseBad = false;

        findViewById(R.id.defenseAverage).setBackgroundColor(Color.rgb(255, 255, 255));

        Variables.DefAr = 255;
        Variables.DefAg = 255;
        Variables.DefAb = 255;
        Variables.defenseAverage = false;
    }


    public void defenseNAClicked(View v) {
        Button b = (Button) v;

        if(Variables.DefNAr == 21 && Variables.DefNAg == 141 && Variables.DefNAb == 14){

            findViewById(R.id.defenseNA).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DefNAr = 255;
            Variables.DefNAg = 255;
            Variables.DefNAb = 255;
            Variables.defenseNA = false;
            Variables.filledDef = false;
        }


        else{
            clearAllDef();
            findViewById(R.id.defenseNA).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefNAr = 21;
            Variables.DefNAg = 141;
            Variables.DefNAb = 14;
            Variables.defenseNA = true;

            Variables.filledDef = true;
        }
    }

    public void defenseGoodClicked(View v) {
        Button b = (Button) v;

        if(Variables.DefGr == 21 && Variables.DefGg == 141 && Variables.DefGb == 14){

            findViewById(R.id.defenseGood).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DefGr = 255;
            Variables.DefGg = 255;
            Variables.DefGb = 255;
            Variables.defenseGood = false;
            Variables.filledDef = false;
        }


        else{
            clearAllDef();
            findViewById(R.id.defenseGood).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefGr = 21;
            Variables.DefGg = 141;
            Variables.DefGb = 14;
            Variables.defenseGood = true;

            Variables.filledDef = true;
        }
    }

    public void defenseBadClicked(View v) {
        Button b = (Button) v;

        if(Variables.DefBr == 21 && Variables.DefBg == 141 && Variables.DefBb == 14){

            findViewById(R.id.defenseBad).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DefBr = 255;
            Variables.DefBg = 255;
            Variables.DefBb = 255;
            Variables.defenseBad = false;
            Variables.filledDef = false;
        }


        else{
            clearAllDef();
            findViewById(R.id.defenseBad).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefBr = 21;
            Variables.DefBg = 141;
            Variables.DefBb = 14;
            Variables.defenseBad = true;

            Variables.filledDef = true;
        }
    }

    public void defenseAverageClicked(View v) {
        Button b = (Button) v;

        if(Variables.DefAr == 21 && Variables.DefAg == 141 && Variables.DefAb == 14){

            findViewById(R.id.defenseAverage).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DefAr = 255;
            Variables.DefAg = 255;
            Variables.DefAb = 255;
            Variables.defenseAverage = false;
            Variables.filledDef = false;
        }


        else {
            clearAllDef();
            findViewById(R.id.defenseAverage).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefAr = 21;
            Variables.DefAg = 141;
            Variables.DefAb = 14;
            Variables.defenseAverage = true;
            Variables.filledDef = true;
        }
    }



    // clear all hang things
    public void clearAll()
    {
        Variables.filledHang = false;
        int blah = Color.rgb(255, 255, 255);
        Variables.hangedGotUp = false;
        findViewById(R.id.button11).setBackgroundColor(blah);
        Variables.hangedAttemped = false;
        findViewById(R.id.button12).setBackgroundColor(blah);
        Variables.hangedCarried = false;
        findViewById(R.id.button13).setBackgroundColor(blah);
        Variables.hangedAttemptedCarry = false;
        findViewById(R.id.button14).setBackgroundColor(blah);
        Variables.hangedParked = false;
        findViewById(R.id.button15).setBackgroundColor(blah);
    }

    public void hangedGotUpClicked(View v) {
        Button b = (Button) v;
        boolean x = Variables.hangedGotUp;
        clearAll();
        if(x) return;
        findViewById(R.id.button11).setBackgroundColor(Color.rgb(21, 141, 14));
        Variables.hangedGotUp = true;
        Variables.filledHang = true;
    }

    public void hangedAttempedClicked(View v) {
        Button b = (Button) v;
        boolean x = Variables.hangedAttemped;
        clearAll();
        if(x) return;
        findViewById(R.id.button12).setBackgroundColor(Color.rgb(21, 141, 14));
        Variables.hangedAttemped = true;
        Variables.filledHang = true;
    }

    public void hangedCarriedClicked(View v) {
        Button b = (Button) v;
        boolean x = Variables.hangedCarried;
        clearAll();
        if(x) return;
        findViewById(R.id.button13).setBackgroundColor(Color.rgb(21, 141, 14));
        Variables.hangedCarried = true;
        Variables.filledHang = true;
    }

    public void hangedAttemptedCarry(View v) {
        Button b = (Button) v;
        boolean x = Variables.hangedAttemptedCarry;
        clearAll();
        if(x) return;
        findViewById(R.id.button14).setBackgroundColor(Color.rgb(21, 141, 14));
        Variables.hangedAttemptedCarry = true;
        Variables.filledHang = true;
    }

    public void hangedParkedClicked(View v) {
        Button b = (Button) v;
        boolean x = Variables.hangedParked;
        clearAll();
        if(x) return;
        findViewById(R.id.button15).setBackgroundColor(Color.rgb(21, 141, 14));
        Variables.hangedParked = true;
        Variables.filledHang = true;
    }

    public void clearIn(){
        Variables.filledInt = false;
        Variables.groundIntake = false;
        findViewById(R.id.intakeButton).setBackgroundColor(0xFFFFFFFF);
    }

    public void intake(View v) {
        Button b = (Button) v;
        if(Variables.groundIntake) clearIn();
        else
        {
            Variables.groundIntake = true;
            findViewById(R.id.intakeButton).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.filledInt = true;
        }
    }

    public void clearBal()
    {
        Variables.filledBal = false;
        Variables.balanced = false;
        findViewById(R.id.balbutton).setBackgroundColor(0xFFFFFFFF);
    }

    public void balanced(View v)
    {
        Button b = (Button) v;
        if(Variables.balanced) clearBal();
        else
        {
            Variables.balanced = true;
            findViewById(R.id.balbutton).setBackgroundColor(Color.rgb(21, 141, 14));
            Variables.filledBal = true;
        }
    }

    public void clearStrafe()
    {
        Variables.filledStrafe = false;
        Variables.strafe = false;
        findViewById(R.id.strafe).setBackgroundColor(0xFFFFFFFF);
    }

    public void strafe(View v)
    {
        Button b = (Button) v;
        if(Variables.strafe) clearStrafe();
        else
        {
            Variables.strafe = true;
            findViewById(R.id.strafe).setBackgroundColor(Color.rgb(21, 141, 14));
            Variables.filledStrafe = true;
        }
    }


    public void submit(View v) {
        Button b = (Button) v;
        boolean x = validateFields();
        if(!x)
        {
            Log.d("Error", "fields aren't filled");
            findViewById(R.id.submit).setBackgroundColor(0xFFDEDEDE );
        }
        else{
            findViewById(R.id.submit).setBackgroundColor(0xFF00FF00);


            //file stuff
            File directory = getExternalFilesDir(null);
            String filename = "ScoutingData" + ".txt";

            try {

                File entry = new File(directory, filename);
                //checks if user has created file yet or not
                if(!entry.exists()){
                    entry.createNewFile();
                    //create toast if needed for debugging
                }
                JSONObject item = new JSONObject();
                //put key, value variabless
                if(Variables.crossedLine) item.put("Crossed Initiation Line", 1);
                else item.put("Crossed Initiation Line", 0);
                item.put("Inner Port Auto", Variables.innerPort);
                item.put("Outer Port Auto", Variables.outerPort);
                item.put("Bottom Port Auto", Variables.bottomPort);
                item.put("Inner Port TeleOp", Variables.innerPortTeleOp);
                item.put("Outer Port TeleOp", Variables.outerPortTeleOp);
                item.put("Bottom Port TeleOp", Variables.bottomPortTeleOp);
                if (Variables.rotControlSuccessful) item.put("Rotation Control", 1);
                else item.put("Rotation Control", 0);
                if (Variables.posControlSuccessful) item.put("Position Control", 1);
                else item.put("Position Control", 0);
                if(Variables.hangedGotUp || Variables.hangedAttemped) item.put("Hang", 0);
                else if(Variables.hangedParked) item.put("Hang", 1);
                if (Variables.hangedAttemptedCarry) item.put("Buddy Hang", "attempted carry");
                else if (Variables.hangedCarried) item.put("Buddy Hang", "carried");
                if(Variables.defenseNA) item.put("Played Defense", 0);
                else if(Variables.defenseBad) item.put("Played Defense", 1);
                else if(Variables.defenseAverage) item.put("Played Defense", 2);
                else if(Variables.defenseGood) item.put("Played Defense", 3);
                if(Variables.groundIntake) item.put("Ground Intake", 1);
                else item.put("Ground Intake", 0);
                if(Variables.strafe) item.put("Strafed", 1);
                else item.put("Strafed", 0);
                //actually speed of hang variables, j the name is diff.
                if(Variables.drivingNA) item.put("Speed Hang", 0);
                else if(Variables.drivingBad) item.put("Speed Hang", 1);
                else if(Variables.drivingAverage) item.put("Speed Hang", 2);
                else if(Variables.drivingGood) item.put("Speed Hang", 3);



                FileOutputStream fos = new FileOutputStream(entry, true);
                fos.write(item.toString(4).getBytes());
                fos.write(",\n".getBytes());
                fos.close();

                startActivity(new Intent(getBaseContext(), OpeningActivity.class));
                Log.d("status", "New Loop has started");

            } catch(Exception e) {

            }

        }
    }

    public boolean validateFields()
    {
        return Variables.filledDef && Variables.filledDrive && Variables.filledHang &&
                Variables.filledInt && Variables.filledBal && Variables.filledStrafe;
    }
}
