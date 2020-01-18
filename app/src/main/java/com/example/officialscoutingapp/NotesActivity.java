package com.example.officialscoutingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotesActivity extends AppCompatActivity {

    TextView scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        scores = findViewById(R.id.scoredisp);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        Button drivingNA = findViewById(R.id.drivingNA);
        Button drivingGood = findViewById(R.id.drivingGood);
        Button drivingBad = findViewById(R.id.drivingBad);
        Button drivingAverage = findViewById(R.id.drivingAverage);


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

    public void drivingNAClicked(View v) {
        Button b = (Button) v;



        if(Variables.DNAr == 21 && Variables.DNAg == 141 && Variables.DNAb == 14){

            findViewById(R.id.drivingNA).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DNAr = 255;
            Variables.DNAg = 255;
            Variables.DNAb = 255;
            Variables.drivingNA = false;
        }


        else{
            findViewById(R.id.drivingNA).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DNAr = 21;
            Variables.DNAg = 141;
            Variables.DNAb = 14;
            Variables.drivingNA = true;

        }


    }

    public void drivingGoodClicked(View v) {
        Button b = (Button) v;

        if(Variables.DGr == 21 && Variables.DGg == 141 && Variables.DGb == 14){

            findViewById(R.id.drivingGood).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DGr = 255;
            Variables.DGg = 255;
            Variables.DGb = 255;
            Variables.drivingGood = false;
        }


        else{
            findViewById(R.id.drivingGood).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DGr = 21;
            Variables.DGg = 141;
            Variables.DGb = 14;
            Variables.drivingGood = true;

        }


    }

    public void drivingBadClicked(View v) {
        Button b = (Button) v;

        if(Variables.DBr == 21 && Variables.DBg == 141 && Variables.DBb == 14){

            findViewById(R.id.drivingBad).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DBr = 255;
            Variables.DBg = 255;
            Variables.DBb = 255;
            Variables.drivingBad = false;
        }


        else{
            findViewById(R.id.drivingBad).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DBr = 21;
            Variables.DBg = 141;
            Variables.DBb = 14;
            Variables.drivingBad = true;

        }

    }

    public void drivingAverageClicked(View v) {
        Button b = (Button) v;

        if(Variables.DAr == 21 && Variables.DAg == 141 && Variables.DAb == 14){

            findViewById(R.id.drivingAverage).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DAr = 255;
            Variables.DAg = 255;
            Variables.DAb = 255;
            Variables.drivingAverage = false;
        }


        else{
            findViewById(R.id.drivingAverage).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DAr = 21;
            Variables.DAg = 141;
            Variables.DAb = 14;
            Variables.drivingAverage = true;

        }

    }






    public void defenseNAClicked(View v) {
        Button b = (Button) v;

        if(Variables.DefNAr == 21 && Variables.DefNAg == 141 && Variables.DefNAb == 14){

            findViewById(R.id.defenseNA).setBackgroundColor(Color.rgb(255, 255, 255));

            Variables.DefNAr = 255;
            Variables.DefNAg = 255;
            Variables.DefNAb = 255;
            Variables.defenseNA = false;
        }


        else{
            findViewById(R.id.defenseNA).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefNAr = 21;
            Variables.DefNAg = 141;
            Variables.DefNAb = 14;
            Variables.defenseNA = true;

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
        }


        else{
            findViewById(R.id.defenseGood).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefGr = 21;
            Variables.DefGg = 141;
            Variables.DefGb = 14;
            Variables.defenseGood = true;

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
        }


        else{
            findViewById(R.id.defenseBad).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefBr = 21;
            Variables.DefBg = 141;
            Variables.DefBb = 14;
            Variables.defenseBad = true;

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
        }


        else{
            findViewById(R.id.defenseAverage).setBackgroundColor(Color.rgb(21, 141, 14));

            Variables.DefAr = 21;
            Variables.DefAg = 141;
            Variables.DefAb = 14;
            Variables.defenseAverage = true;

        }

    }






    public void hangedGotUpClicked(View v) {
        Button b = (Button) v;
        Variables.hangedGotUp = true;
    }

    public void hangedAttempedClicked(View v) {
        Button b = (Button) v;
        Variables.hangedAttemped = true;
    }

    public void hangedCarriedClicked(View v) {
        Button b = (Button) v;
        Variables.hangedCarried = true;
    }

    public void hangedAttemptedCarry(View v) {
        Button b = (Button) v;
        Variables.hangedAttemptedCarry = true;
    }

    public void hangedParkedClicked(View v) {
        Button b = (Button) v;
        Variables.hangedParked = true;
    }



}
