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

public class TeleOpActivity extends AppCompatActivity {

    Stack<Integer> currMoves;

    TextView scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);
        scores = findViewById(R.id.scoredisp);

        currMoves = new Stack<Integer>();

        Button iniationLine = findViewById(R.id.initiationLine);
        Button bottomPortTeleOp = findViewById(R.id.bottomPortTeleOp);
        Button outerPortTeleOp = findViewById(R.id.outerPortTeleOp);
        Button innerPortTeleOp = findViewById(R.id.innerPortTeleOp);
        Button nextScreen = findViewById(R.id.nextScreen);
        BottomNavigationView navView = findViewById(R.id.nav_view);


        if(Variables.isTeleOpOver==true){
            Button next = (Button) findViewById(R.id.nextScreen);
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), NotesActivity.class);
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

        update();
    }

    public void outerClicked(View v) {
        Button b = (Button) v;
        Variables.outerPortTeleOp+=1;
        Variables.shotsShot++;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.outerPortTeleOp);
        update();
    }

    public void bottomClicked(View v){
        Button b = (Button) v;
        Variables.bottomPortTeleOp+=1;
        Variables.shotsShot++;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.bottomPortTeleOp);
        update();
    }

    public void innerClicked(View v) {
        Button b = (Button) v;
        Variables.innerPortTeleOp += 1;
        Variables.shotsShot++;
        Log.d("buttonId", Integer.toString(v.getId()));
        currMoves.push(R.id.innerPortTeleOp);
        update();
    }

    public void rotSuccesfulClicked(View v) {
        Button b = (Button) v;
        if(Variables.rotControlSuccessful)
        {
            Variables.rotControlSuccessful = false;
            if(Variables.rotControlAttempted) {
                findViewById(R.id.rotControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
            } else {
                findViewById(R.id.rotControlSuccesful).setBackgroundColor(0xFFDFEEED);
            }
            currMoves.push(-R.id.rotControlSuccesful);
            return;
        }
        Variables.rotControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.rotControlSuccesful).setBackgroundColor(Color.rgb(0, 255, 0));
        currMoves.push(R.id.rotControlSuccesful);
        update();
    }

    public void posSuccesfulClicked(View v) {
        Button b = (Button) v;
        if(Variables.posControlSuccessful)
        {
            Variables.posControlSuccessful = false;
            if(Variables.posControlAttempted) {
                findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(232, 17, 45));
            } else {
                findViewById(R.id.posControlSuccesful).setBackgroundColor(0xFFDFEEED);
            }
            currMoves.push(-R.id.posControlSuccesful);
            return;
        }
        Variables.posControlSuccessful = true;
        Log.d("buttonId", Integer.toString(v.getId()));
        findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(0, 255, 0));
        currMoves.push(R.id.posControlSuccesful);
        update();
    }

    public void missedPressed(View v) {
        Button b = (Button) v;
        Variables.shotsShot++;
        currMoves.push(R.id.upperattempted);
        update();
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

    public void removeAccordingly(int latest) {
        if (latest == R.id.initiationLine) {
            Log.d("status", "team did not actually cross init. line");
            Variables.crossedLine = false;
            findViewById(R.id.initiationLine).setBackgroundColor(0xFFDFEEED);
        } else if (latest == R.id.bottomPortTeleOp) {
            Variables.shotsShot--;
            Variables.bottomPortTeleOp--;
        } else if (latest == R.id.innerPortTeleOp) {
            Variables.shotsShot--;
            Variables.innerPortTeleOp--;
        } else if (latest == R.id.outerPortTeleOp) {
            Variables.shotsShot--;
            Variables.outerPortTeleOp--;
        } else if (latest == R.id.upperattempted)
        {
            Variables.shotsShot--;
        } else if(latest == R.id.rotControlSuccesful)
        {
            Variables.rotControlSuccessful = false;
            findViewById(R.id.rotControlSuccesful).setBackgroundColor(0xFFDFEEED);
        }
        else if(latest == -R.id.posControlSuccesful)
        {
            Variables.posControlSuccessful = true;
            findViewById(R.id.posControlSuccesful).setBackgroundColor(Color.rgb(0, 255, 0));
            update();
        }
        update();
    }

    public void update()
    {
        scores.setText(Variables.bottomPortTeleOp + " bottom, " + Variables.outerPortTeleOp + " outer, " + Variables.innerPortTeleOp + " inner. " + Variables.shotsShot + " in total");
    }


    public void nextScreenClicked(View v){
        Button b = (Button) v;
        Variables.isTeleOpOver=true;
        Log.d("buttonId", Integer.toString(v.getId()));
        nextScreen();
    }

    public void nextScreen(){
        Button b = (Button) findViewById(R.id.nextScreen);
        startActivity(new Intent(getBaseContext(), NotesActivity.class));
        Log.d("status", "Notes has started");
    }

}
