package com.example.officialscoutingapp;

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
        Variables.drivingNA = true;
    }

    public void drivingGoodClicked(View v) {
        Button b = (Button) v;
        Variables.drivingGood = true;
    }

    public void drivingBadClicked(View v) {
        Button b = (Button) v;
        Variables.drivingBad = true;
    }

    public void drivingAverageClicked(View v) {
        Button b = (Button) v;
        Variables.drivingAverage = true;
    }






    public void defenseNAClicked(View v) {
        Button b = (Button) v;
        Variables.defenseNA = true;
    }

    public void defenseGoodClicked(View v) {
        Button b = (Button) v;
        Variables.defenseGood = true;
    }

    public void defenseBadClicked(View v) {
        Button b = (Button) v;
        Variables.defenseBad = true;
    }

    public void defenseAverageClicked(View v) {
        Button b = (Button) v;
        Variables.defenseAverage = true;
    }



}
