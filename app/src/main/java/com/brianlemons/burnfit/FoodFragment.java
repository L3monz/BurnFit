package com.brianlemons.burnfit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ashwin on 4/4/2017.
 */

public class FoodFragment extends Fragment{
    //TODO get the activity here and redirect to the page
    // TODO with the suggestions and recipe

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        Button nextPageButton = (Button) view.findViewById(R.id.nextPageFood);
        nextPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

}
