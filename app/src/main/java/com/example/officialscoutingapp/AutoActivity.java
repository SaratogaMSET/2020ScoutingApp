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

public class AutoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);


        Button iniationLine = findViewById(R.id.iniationLine);
        Button bottomPort = findViewById(R.id.bottomPort);
        Button outerPort = findViewById(R.id.outerPort);
        Button innerPort = findViewById(R.id.innerPort);
        Button nextScreen = findViewById(R.id.nextScreen);
        BottomNavigationView navView = findViewById(R.id.nav_view);

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

    public void lineCrossed(View v) {
        Button b = (Button) v;
        Variables.crossedLine=true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void nextScreenClicked(View v){
        Button b = (Button) v;
        Variables.isAutoOver=true;
        Log.d("buttonId", Integer.toString(v.getId()));
    }

    public void nextScreen(){
        Button b = (Button) findViewById(R.id.nextScreen);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AutoActivity.this, TeleOpActivity.class));
            }
        });
    }

}
