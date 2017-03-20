package com.brianlemons.burnfit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by brianlemons on 3/19/17.
 */

public class ExerciseListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] exerciseDistance;
    private final Integer[] exerciseImages;
    private final String[] exerciseInfo;



    public ExerciseListAdapter(Activity context, String[] exerciseDistance, Integer[] exerciseImages,
                               String[] exerciseInfo) {
        super(context,R.layout.exercise_item,exerciseDistance);
        this.context = context;
        this.exerciseDistance = exerciseDistance;
        this.exerciseImages = exerciseImages;
        this.exerciseInfo = exerciseInfo;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View exerciseView = inflater.inflate(R.layout.exercise_item, null, true);
        TextView distance = (TextView) exerciseView.findViewById(R.id.distance);
        ImageView image = (ImageView) exerciseView.findViewById(R.id.exercisePicture);
        TextView info = (TextView) exerciseView.findViewById(R.id.exerciseInfo);

        distance.setText(exerciseDistance[position]);
        image.setImageResource(exerciseImages[position]);
        info.setText(exerciseInfo[position]);
        return exerciseView;
    }
}
