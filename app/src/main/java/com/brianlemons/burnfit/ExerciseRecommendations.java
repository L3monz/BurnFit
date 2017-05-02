package com.brianlemons.burnfit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

import java.lang.reflect.Field;

public class ExerciseRecommendations extends AppCompatActivity {

    public static String [] exerciseDescription = {
            "Bench Press\nSets:3 Reps:10", "Elliptical Trainer\nSets:1 Reps:20 minutes",
            "Push-Ups\nSets:3 Reps:10", "Machine Shoulder Press\nSets:3 Reps:10",
            "Tricep Pushdown\nSets:3 Reps:12"
            };

    public static String [] exerciseThumbnail= {"heSumeWiFig", "mNM01g9wLy4", "RgL5HFny_kA",
            "dxPWKja9j68", "plcA3Q-9RzI" };
    ListView exerciseLv;
    TextView workOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_recommendations);

        ExerciseVideoAdapter exerciseListAdapter = new ExerciseVideoAdapter(this,exerciseDescription,exerciseThumbnail);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        /* Use this to switch between tabs. */
        removeShiftMode(bottomNavigationView);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        bottomNavigationView.getMenu().getItem(1).setChecked(false);
        bottomNavigationView.getMenu().getItem(2).setChecked(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(false);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.exerciseItem) {
                } else if (item.getItemId() == R.id.foodItem) {
                    //start the food activity
                    Intent i = new Intent(getApplicationContext(), FoodManager.class);
                    startActivity(i);
                    overridePendingTransition(0,0);

                } else if (item.getItemId() == R.id.exploreItem) {
                    Intent i = new Intent(getApplicationContext(), ExploreMain.class);
                    startActivity(i);
                    overridePendingTransition(0,0);
                } else if (item.getItemId() == R.id.funItem) {
                    Intent intent = new Intent(getApplicationContext(), Events.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                return false;
            }
        });

        workOut = (TextView) findViewById(R.id.workout);
        workOut.setText("Beginner Workout");
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
    static void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }
}
