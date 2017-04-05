package com.brianlemons.burnfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ashwin on 4/4/2017.
 */

public class FoodFragment extends Fragment{
    //TODO get the activity here and redirect to the page
    // with the suggestions and recipe

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_food, container, false);

        Button nextPageButton = (Button) view.findViewById(R.id.nextPageFood);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavigationView);

        nextPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //to fix
                Intent i = new Intent(getActivity(), FoodActivity.class);
                startActivity(i);
            }
        });

        /* Use this to switch between tabs. */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.exerciseItem) {
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                    ((Activity) getActivity()).overridePendingTransition(0,0);
                } else if (item.getItemId() == R.id.foodItem) {
                } else if (item.getItemId() == R.id.exploreItem) {
                } else if (item.getItemId() == R.id.funItem) {
                }
                return false;
            }
        });

        return view;



    }

}
