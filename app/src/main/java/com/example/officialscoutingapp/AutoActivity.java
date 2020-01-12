package com.example.officialscoutingapp;

import android.content.Intent;
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

import java.util.Stack;

public class AutoActivity extends AppCompatActivity {

    private Stack<Integer> currMoves;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        Button iniationLine = findViewById(R.id.initiationLine);
        Button bottomPort = findViewById(R.id.bottomPort);
        Button outerPort = findViewById(R.id.outerPort);
        Button innerPort = findViewById(R.id.innerPort);
        Button nextScreen = findViewById(R.id.nextScreen);
        Button undo = findViewById(R.id.undoButton);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        currMoves = new Stack<Integer>();

        if(Variables.isAutoOver==true){
            nextScreen();
        }


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
        currMoves.push(R.id.outerPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
    }

    public void bottomClicked(View v){
        Button b = (Button) v;
        Variables.bottomPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.bottomPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
    }

    public void innerClicked(View v) {
        Button b = (Button) v;
        Variables.innerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.innerPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
    }

    public void lineCrossed(View v) {
        Button b = (Button) v;
        Variables.crossedLine=true;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.initiationLine);
        Log.d("status", "team has crossed init. line");
    }

    public void undoPressed(View v) {
        Button b = (Button) v;
        if(currMoves.isEmpty())
        {
            Log.d("Error", "There's nothing to undo!");
        }
        int latest = currMoves.pop();
        Log.d("buttonId", Integer.toString(v.getId()));
        removeAccordingly(latest);
    }

    public void removeAccordingly(int latest)
    {
        if(latest == R.id.initiationLine)
        {
            Log.d("status", "team did not actually cross init. line");
            Variables.crossedLine=false;
        } else if(latest == R.id.bottomPort)
        {
            Variables.bottomPort--;
        } else if(latest == R.id.innerPort)
        {
            Variables.innerPort--;
        } else if(latest == R.id.outerPort)
        {
            Variables.outerPort--;
        }
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
    }

    public void nextScreenClicked(View v){
        Button b = (Button) v;
        Variables.isAutoOver=true;
        Log.d("buttonId", Integer.toString(v.getId()));
        nextScreen();
    }

    public void nextScreen(){
        Button b = (Button) findViewById(R.id.nextScreen);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), TeleOpActivity.class));
                Log.d("status", "TeleOp has started");
            }
        });
    }

}
