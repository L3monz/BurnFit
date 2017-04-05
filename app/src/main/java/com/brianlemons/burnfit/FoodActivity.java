package com.brianlemons.burnfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ashwin on 4/4/2017.
 */

public class FoodActivity extends AppCompatActivity {
    //TODO food suggestions and recipes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_suggestions);

        /*Button nextPageButton = (Button) findViewById(R.id.nextPageFood);
        nextPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //to fix
                //Intent i = new Intent(getApplicationContext(), FoodActivity.class);
            }
        });*/
    }

}