package com.example.officialscoutingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TeleOpActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button iniationLine = findViewById(R.id.initiationLine);
        Button bottomPort = findViewById(R.id.bottomPort);
        Button outerPort = findViewById(R.id.outerPort);
        Button innerPort = findViewById(R.id.innerPort);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void outerClicked(View v) {
        Button b = (Button) v;
        Variables.outerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void bottomClicked(View v){
        Button b = (Button) v;
        Variables.bottomPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));

    }

    public void innerClicked(View v) {
        Button b = (Button) v;
        Variables.innerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void rotAttemptedClicked(View v) {
        Button b = (Button) v;
        Variables.rotControlAttempted = true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void rotSuccesfulClicked(View v) {
        Button b = (Button) v;
        Variables.rotControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void posAttemptedClicked(View v) {
        Button b = (Button) v;
        Variables.posControlAttempted = true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void posSuccesfulClicked(View v) {
        Button b = (Button) v;
        Variables.posControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }




}
