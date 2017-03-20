package com.brianlemons.burnfit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    TextView infoTextView;
    ListView exerciseLv;


    private static Integer [] exerciseImages = {
            R.drawable.mountvernon, R.drawable.onelife, R.drawable.tridentfitness};

    public static String [] exerciseDistance = {"0.2 miles away", "0.7 miles away", "2.0 miles"};

    public static String [] exerciseInfo = {"Go for a walk or bike ride at Mount Vernon Trail.",
            "Workout at Onelife Fitness Center in Alexandria, VA",
            "Workout at Trident Crossfit Gym in Alexandria, VA"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        ExerciseListAdapter exerciseListAdapter = new ExerciseListAdapter(this,exerciseDistance,exerciseImages,exerciseInfo);
        exerciseLv = (ListView) findViewById(R.id.exerciseList);
        exerciseLv.setAdapter(exerciseListAdapter);


    }
}
