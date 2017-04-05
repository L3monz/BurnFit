package com.brianlemons.burnfit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //make fragment or add photos for food
    private BottomNavigationView bottomNavigationView;
    TextView infoTextView;
    ListView exerciseLv;


    public static Integer [] exerciseImages = {
            R.drawable.goldstar,  R.drawable.chest, R.drawable.biceps,
            R.drawable.calves,  R.drawable.quadriceps, R.drawable.back,
            R.drawable.shoulders,  R.drawable.triceps,
            R.drawable.hamstrings,  R.drawable.trapezuis, R.drawable.abs};

    public static String [] exerciseInfo = {"Recommended\n Workout",
            "Chest", "Biceps", "Calves", "Quadriceps", "Back",
            "Shoulders", "Triceps", "Hamstrings",
            "Trapezius", "Abs"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        /* Use this to switch between tabs. */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.exerciseItem) {
                } else if (item.getItemId() == R.id.foodItem) {
                    //start the food activity
                    Intent i = new Intent(getApplicationContext(), FoodManager.class);
                    startActivity(i);
                } else if (item.getItemId() == R.id.exploreItem) {
                } else if (item.getItemId() == R.id.funItem) {
                }
                return false;
            }
        });

        ExerciseListAdapter exerciseListAdapter = new ExerciseListAdapter(this,exerciseImages,exerciseInfo);

        exerciseLv = (ListView) findViewById(R.id.exerciseList);
        exerciseLv.setAdapter(exerciseListAdapter);
        exerciseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent newIntent = new Intent(getApplicationContext(), ExerciseRecommendations.class);
                    startActivity(newIntent);


                }else if(position == 1){
                    Intent newIntent = new Intent(getApplicationContext(), ExerciseChest.class);
                    startActivity(newIntent);

                }else if(position == 2){
                    Intent newIntent = new Intent(getApplicationContext(), ExerciseBicep.class);
                    startActivity(newIntent);
                }

                else{

                    Toast.makeText(MainActivity.this,"Under Construction", Toast.LENGTH_LONG).show();

                }

            }
        });


    }
}
