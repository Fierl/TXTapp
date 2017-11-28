package com.example.simonfierbeck.txtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.simonfierbeck.txtapp.TrainingMenuActivity.trainingTimer.changeTimer;


/**
 * Created by Simon Fierbeck on 16.10.2017.
 */

public class TrainingMenuActivity extends AppCompatActivity {
    String tag = "Simon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_training);

        //fill Spinner with values
        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{15, 30, 45, 60};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                String items = mySpinner.getSelectedItem().toString();
                trainingTimer.timer = Integer.parseInt(items);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
    }


     protected void onClickStart(View v){
         Intent i = new Intent(TrainingMenuActivity.this,TrainingActivity.class);
         startActivity(i);
     }



     protected void onClickBack(View v){
         Intent i = new Intent(TrainingMenuActivity.this,MenuActivity.class);
         startActivity(i);
     }


    public static class trainingTimer{
        static int timer = 15;

        public static void changeTimer(int i){
            timer = i;
        }
     }

}
