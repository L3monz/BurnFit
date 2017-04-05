package com.brianlemons.burnfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ashwin on 4/4/2017.
 */

public class FoodActivity extends AppCompatActivity {
    //TODO food suggestions and recipes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_suggestions);

        /*BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.exerciseItem) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    ((Activity) getApplicationContext()).overridePendingTransition(0,0);
                } else if (item.getItemId() == R.id.foodItem) {
                } else if (item.getItemId() == R.id.exploreItem) {
                } else if (item.getItemId() == R.id.funItem) {
                }
                return false;
            }
        });*/

    }

}