package com.brianlemons.burnfit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.Map;

/**
 * Created by brianlemons on 3/24/17.
 */


public class ExerciseVideoAdapter extends ArrayAdapter<String> implements YouTubeThumbnailView.OnInitializedListener {
    private final Activity context;
    private final String[] exerciseDescription;
    private final String[] exerciseThumbnail;


    public ExerciseVideoAdapter(Activity context, String[] exerciseDescription,
                                String[] exerciseThumbnail) {
        super(context,R.layout.activity_exercise, exerciseDescription);
        this.context = context;
        this.exerciseDescription = exerciseDescription;
        this.exerciseThumbnail = exerciseThumbnail;

    }

    static class VideoHolder {
        YouTubeThumbnailView thumb;
        TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String videoId = exerciseThumbnail[position];

        if (convertView == null) {
            VideoHolder holder;
            //Create the row
            final LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_exercise, parent, false);

            //Create the video holder
            holder = new VideoHolder();

            //Set the title
            holder.title = (TextView) convertView.findViewById(R.id.descriptionThumbnail);
            holder.title.setText(exerciseDescription[position]);

            //Initialise the thumbnail
            holder.thumb = (YouTubeThumbnailView) convertView.findViewById(R.id.imageExerciseThumbnail);
            holder.thumb.setTag(exerciseThumbnail[position]);
            holder.thumb.initialize(context.getString(R.string.DEVELOPER_KEY), this);

            convertView.setTag(holder);
        }
        return convertView;
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {
        loader.setVideo((String) view.getTag());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView thumbnailView, YouTubeInitializationResult errorReason) {
        String errorMessage = errorReason.toString();
        if(errorMessage == "SERVICE_MISSING"){
            errorMessage = "User Needs YouTube App.";
        }
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
    }
}

