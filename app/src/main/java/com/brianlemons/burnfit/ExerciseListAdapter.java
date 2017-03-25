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
    private final Integer[] exerciseImages;
    private final String[] exerciseInfo;

    public ExerciseListAdapter(Activity context, Integer[] exerciseImages,
                               String[] exerciseInfo) {
        super(context,R.layout.exercise_item, exerciseInfo);
        this.context = context;
        this.exerciseImages = exerciseImages;
        this.exerciseInfo = exerciseInfo;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View exerciseView = inflater.inflate(R.layout.exercise_item, null, true);
        ImageView image = (ImageView) exerciseView.findViewById(R.id.exercisePicture);
        TextView info = (TextView) exerciseView.findViewById(R.id.exerciseInfo);

        image.setImageResource(exerciseImages[position]);
        info.setText(exerciseInfo[position]);
        return exerciseView;
    }
}
