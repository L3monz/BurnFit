package com.brianlemons.burnfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeIntents;

/**
 * Created by brianlemons on 3/25/17.
 */

public class ExerciseChest extends AppCompatActivity {

    public static String [] exerciseDescription = {
            "Bench Press\nSets:3 Reps: 10", "Incline Dumbbell Press\nSets:3 Reps: 8",
            "Push-Ups\nSets:3 Reps: 12"};

    public static String [] exerciseThumbnail= {"heSumeWiFig",
            "8iPEnn-ltC8", "RgL5HFny_kA"};
    ListView exerciseLv;
    TextView workOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendations);

        ExerciseVideoAdapter exerciseListAdapter = new ExerciseVideoAdapter(this,exerciseDescription,exerciseThumbnail);
        exerciseLv = (ListView) findViewById(R.id.exerciseVideos);
        workOut = (TextView) findViewById(R.id.workout);
        workOut.setText("Chest Workouts");
        exerciseLv.setAdapter(exerciseListAdapter);
        exerciseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(YouTubeIntents.createPlayVideoIntentWithOptions(ExerciseChest.this,
                        exerciseThumbnail[position], true, true));


            }
        });

    }

}
