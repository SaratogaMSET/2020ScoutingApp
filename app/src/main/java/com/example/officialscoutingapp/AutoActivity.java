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

import java.util.Stack;

public class AutoActivity extends AppCompatActivity {

    private Stack<Integer> currMoves;

    TextView scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        Button iniationLine = findViewById(R.id.initiationLine);
        Button bottomPort = findViewById(R.id.bottomPort);
        Button outerPort = findViewById(R.id.outerPort);
        Button innerPort = findViewById(R.id.innerPort);
        Button nextScreen = findViewById(R.id.nextScreen);
        Button undo = findViewById(R.id.undoButton);
        scores = findViewById(R.id.scoredisp);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // scores.setText(Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");

        update();
        currMoves = new Stack<Integer>();

        if(Variables.isAutoOver==true){
            Button next = (Button) findViewById(R.id.nextScreen);
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), TeleOpActivity.class);
                    startActivityForResult(myIntent, 0);
                }

            });
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

    private boolean autoupd = false;
    public void outerClicked(View v) {
        Button b = (Button) v;
        // check if initiationline has been added or not
        Variables.outerPort+=1;
        Variables.shotsShot++;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.outerPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
        update();
    }

    public void bottomClicked(View v){
        Button b = (Button) v;
        Variables.bottomPort+=1;
        Variables.shotsShot++;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.bottomPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
        update();
    }

    public void missedClicked(View v)
    {
        Button b = (Button) v;
        Variables.shotsShot++;
        currMoves.push(R.id.upperattempted);
        update();
    }

    public void innerClicked(View v) {
        Button b = (Button) v;
        Variables.shotsShot++;
        Variables.innerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.innerPort);
        Log.d("status of team", Variables.bottomPort + " in bottom, " + Variables.outerPort + " on outside, and " + Variables.innerPort + " inside.");
        update();
    }

    public void lineCrossed(View v) {
        Button b = (Button) v;
        if(Variables.crossedLine)
        {
            // Log.d("error", "Undo first before changing");
            Variables.crossedLine = false;
            findViewById(R.id.initiationLine).setBackgroundColor(0xFFDFEEED);
            currMoves.push(-R.id.initiationLine);
            return;
        }
        Variables.crossedLine=true;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.initiationLine);
        Log.d("status", "team has crossed init. line");
        findViewById(R.id.initiationLine).setBackgroundColor(Color.rgb(255, 210, 0));
    }

    public void undoPressed(View v) {
        Button b = (Button) v;
        if(currMoves.isEmpty())
        {
            Log.d("Error", "There's nothing to undo!");
            return;
        }
        int latest = currMoves.pop();
        Log.d("buttonId", Integer.toString(v.getId()));
        removeAccordingly(latest);
        update();
    }

    public void removeAccordingly(int latest)
    {
        if(latest == R.id.initiationLine)
        {
            Log.d("status", "team did not actually cross init. line");
            Variables.crossedLine=false;
            findViewById(R.id.initiationLine).setBackgroundColor(0xFFDFEEED);
        }
        else if(latest == -R.id.initiationLine)
        {
            Log.d("status", "i think they did cross actually");
            Variables.crossedLine=true;
            findViewById(R.id.initiationLine).setBackgroundColor(Color.rgb(255, 210, 0));
        }
        else if(latest == R.id.bottomPort)
        {
            Variables.bottomPort--;
            Variables.shotsShot--;
        }
        else if(latest == R.id.upperattempted)
        {
            Variables.shotsShot--;
        }
        else if(latest == R.id.innerPort)
        {
            Variables.innerPort--;
            Variables.shotsShot--;
        }

        else if(latest == R.id.outerPort)
        {
            Variables.outerPort--;
            Variables.shotsShot--;
        }
        update();
    }

    public void nextScreenClicked(View v){
        Button b = (Button) v;
        Variables.isAutoOver=true;
        Log.d("buttonId", Integer.toString(v.getId()));
        nextScreen();
    }

    public void nextScreen(){
        Button b = (Button) findViewById(R.id.nextScreen);
        startActivity(new Intent(getBaseContext(), TeleOpActivity.class));
        Log.d("status", "TeleOp has started");
    }

    public void update()
    {
        scores.setText(Variables.bottomPort + " bottom, " + Variables.outerPort + " outer, " + Variables.innerPort + " inner. " + Variables.shotsShot + " in total");
    }

}
