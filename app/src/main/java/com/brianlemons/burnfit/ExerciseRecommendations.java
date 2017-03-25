package com.brianlemons.burnfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class ExerciseRecommendations extends AppCompatActivity {

    public static String [] exerciseDescription = {
            "Bench Press\nSets:3 Reps:10", "Machine Shoulder Press\nSets:3 Reps:10",
            "Tricep Pushdown\nSets:3 Reps:12",  "Push-Ups\nSets:3 Reps:10",
            "Elliptical Trainer\nSets:1 Reps:20 minutes"};

    public static String [] exerciseThumbnail= {"heSumeWiFig",
            "dxPWKja9j68", "plcA3Q-9RzI", "RgL5HFny_kA", "mNM01g9wLy4"};
    ListView exerciseLv;
    TextView workOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendations);

        ExerciseVideoAdapter exerciseListAdapter = new ExerciseVideoAdapter(this,exerciseDescription,exerciseThumbnail);
        workOut = (TextView) findViewById(R.id.workout);
        workOut.setText("Recommendations");
        exerciseLv = (ListView) findViewById(R.id.exerciseVideos);
        exerciseLv.setAdapter(exerciseListAdapter);
        exerciseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(YouTubeIntents.createPlayVideoIntentWithOptions(ExerciseRecommendations.this,
                        exerciseThumbnail[position], true, true));


            }
        });



    }
}
