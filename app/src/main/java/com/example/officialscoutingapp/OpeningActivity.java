package com.example.officialscoutingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.ref.WeakReference;

public class OpeningActivity extends AppCompatActivity {

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


//        View view = ActivityCompat.requireViewById(this, R.id.nav_host_fragment);
//        NavController navController2 = findViewNavController(view);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


    private static NavController findViewNavController(@NonNull View view) {
        while (view != null) {
            NavController controller = getViewNavController(view);
            if (controller != null) {
                return controller;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @Nullable
    private static NavController getViewNavController(@NonNull View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        NavController controller = null;
        if (tag instanceof WeakReference) {
            controller = ((WeakReference<NavController>) tag).get();
        } else if (tag instanceof NavController) {
            controller = (NavController) tag;
        }
        return controller;
    }





    public void redness(View v)
    {
        if(Variables.redalliance) findViewById(R.id.redb).setBackgroundColor(Color.rgb(0, 0, 255));
        if(!Variables.redalliance) findViewById(R.id.redb).setBackgroundColor(Color.rgb(255, 0, 0));
        Log.d("string", String.valueOf(Variables.redalliance));
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
