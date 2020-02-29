package com.example.officialscoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        BottomNavigationView navView = findViewById(R.id.nav_view);




        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    public void redness(View v)
    {
        if(Variables.redalliance) findViewById(R.id.redb).setBackgroundColor(0xff00dd00);
        if(Variables.redalliance) findViewById(R.id.redb).setBackgroundColor(0xffffd900);
        Variables.redalliance = !Variables.redalliance;
    }

    public void updateNum(View v)
    {
        Variables.teamnum = findViewById(R.id.numfield).toString();
        Log.d("string", Variables.teamnum);
    }

    public void updateName(View v)
    {
        Variables.scouter = findViewById(R.id.scfield).toString();
        Log.d("name..", Variables.scouter);
    }

    public void nextScreen(View v){
        startActivity(new Intent(getBaseContext(), AutoActivity.class));
        Log.d("status", "Auto has started");
    }
}
