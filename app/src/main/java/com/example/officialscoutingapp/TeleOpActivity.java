package com.example.officialscoutingapp;

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

public class TeleOpActivity extends AppCompatActivity {

    Stack<Integer> currMoves;

    TextView scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);
        scores = findViewById(R.id.scoredisp);

        currMoves = new Stack<Integer>();

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

        update();
    }

    public void outerClicked(View v) {
        Button b = (Button) v;
        Variables.outerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.outerPort);
        update();
    }

    public void bottomClicked(View v){
        Button b = (Button) v;
        Variables.bottomPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.bottomPort);
        update();
    }

    public void innerClicked(View v) {
        Button b = (Button) v;
        Variables.innerPort+=1;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.innerPort);
        update();
    }

    public void rotAttemptedClicked(View v) {
        Button b = (Button) v;
        Variables.rotControlAttempted = true;
        Variables.rotControlSuccessful = false;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.rotControlAttempted).setBackgroundColor(Color.rgb(255, 239, 0));
        findViewById(R.id.rotControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
        currMoves.push(R.id.rotControlAttempted);
        update();
    }

    public void rotSuccesfulClicked(View v) {
        Button b = (Button) v;
        Variables.rotControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.rotControlAttempted).setBackgroundColor(Color.rgb(0, 255, 0));
        findViewById(R.id.rotControlSuccesful).setBackgroundColor(Color.rgb(0, 255, 0));
        currMoves.push(R.id.rotControlSuccesful);
        update();
    }

    public void posAttemptedClicked(View v) {
        Button b = (Button) v;
        Variables.posControlAttempted = true;
        Variables.posControlSuccessful = false;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.posControlAttempted).setBackgroundColor(Color.rgb(255, 239, 0));
        findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
        currMoves.push(R.id.posControlAttempted);
        update();
    }

    public void posSuccesfulClicked(View v) {
        Button b = (Button) v;
        Variables.posControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.posControlAttempted).setBackgroundColor(Color.rgb(0, 255, 0));
        findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(0, 255, 0));
        currMoves.push(R.id.posControlSuccesful);
        update();
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
        update();
    }

    public void removeAccordingly(int latest)
    {
        if(latest == R.id.initiationLine)
        {
            Log.d("status", "team did not actually cross init. line");
            Variables.crossedLine=false;
            findViewById(R.id.initiationLine).setBackgroundColor(0xFFDFEEED);
        } else if(latest == R.id.bottomPort)
        {
            Variables.bottomPort--;
        } else if(latest == R.id.innerPort)
        {
            Variables.innerPort--;
        } else if(latest == R.id.outerPort)
        {
            Variables.outerPort--;
        } else if(latest == R.id.rotControlAttempted)
        {
            Variables.rotControlAttempted = false;
            Variables.rotControlSuccessful = false;
            findViewById(R.id.rotControlAttempted).setBackgroundColor(0xFFDFEEED);
            findViewById(R.id.rotControlSuccesful).setBackgroundColor(0xFFDFEEED);
        } else if(latest == R.id.rotControlSuccesful)
        {
            Variables.rotControlSuccessful = false;
            if(Variables.rotControlAttempted) {
                findViewById(R.id.rotControlAttempted).setBackgroundColor(Color.rgb(255, 239, 0));
                findViewById(R.id.rotControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
            } else {
                findViewById(R.id.rotControlAttempted).setBackgroundColor(0xFFDFEEED);
                findViewById(R.id.rotControlSuccesful).setBackgroundColor(0xFFDFEEED);
            }
        } else if(latest == R.id.posControlAttempted)
        {
            Variables.posControlAttempted = false;
            Variables.posControlSuccessful = false;
            findViewById(R.id.posControlAttempted).setBackgroundColor(0xFFDFEEED);
            findViewById(R.id.posControlSuccesful).setBackgroundColor(0xFFDFEEED);
        } else if(latest == R.id.posControlSuccesful)
        {
            Variables.posControlSuccessful = false;
            if(Variables.posControlAttempted) {
                findViewById(R.id.posControlAttempted).setBackgroundColor(Color.rgb(255, 239, 0));
                findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
            } else {
                findViewById(R.id.posControlAttempted).setBackgroundColor(0xFFDFEEED);
                findViewById(R.id.posControlSuccesful).setBackgroundColor(0xFFDFEEED);
            }
        }
        update();
    }

    public void update()
    {
        scores.setText(Variables.bottomPort + " bottom, " + Variables.outerPort + " outer, " + Variables.innerPort + " inner.");
    }

}
