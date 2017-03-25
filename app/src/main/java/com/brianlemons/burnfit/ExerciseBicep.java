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

public class ExerciseBicep extends AppCompatActivity {

    public static String [] exerciseDescription = {
            "Barbell Curl\nSets:4 6-8, 6-8, 8-10, 8-10", "Incline Dumbbell Curl\nSets:3 Reps:8, 8, 10",
            "Reverse Cable Curl\nSets:3 Reps:10-12, 10-12, 12-15"};

    public static String [] exerciseThumbnail= {"heSumeWiFig",
            "soxrZlIl35U", "HwB-DevuJjU"};
    ListView exerciseLv;
    TextView workOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendations);

        ExerciseVideoAdapter exerciseListAdapter = new ExerciseVideoAdapter(this,exerciseDescription,exerciseThumbnail);
        exerciseLv = (ListView) findViewById(R.id.exerciseVideos);
        workOut = (TextView) findViewById(R.id.workout);
        workOut.setText("Bicep Workouts");
        exerciseLv.setAdapter(exerciseListAdapter);
        exerciseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(YouTubeIntents.createPlayVideoIntentWithOptions(ExerciseBicep.this,
                        exerciseThumbnail[position], true, true));


            }
        });

    }
}
