package com.brianlemons.burnfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

    public static final String API_KEY = "AIzaSyAa_BhMdsxI7jmSOmptLnYojxD0DN6VNgY";
    public static final String VIDEO_ID = "heSumeWiFig";

    public static String [] exerciseDescription = {
            "Bench Press\nSets:3", "Machine Shoulder Press\nSets:3",
            "Tricep Pushdown\nSets:3",  "Push-Ups\nSets:3", "Elliptical Trainer\nSets:1"};

    public static String [] exerciseThumbnail= {"heSumeWiFig",
            "dxPWKja9j68", "plcA3Q-9RzI", "RgL5HFny_kA", "mNM01g9wLy4"};
    ListView exerciseLv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendations);

        ExerciseVideoAdapter exerciseListAdapter = new ExerciseVideoAdapter(this,exerciseDescription,exerciseThumbnail);
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
