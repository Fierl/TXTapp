package com.example.simonfierbeck.txtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Simon Fierbeck on 14.10.2017.
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    protected void onClickBack(View v){
        Intent i = new Intent(SettingsActivity.this, MenuActivity.class);
        startActivity(i);
    }

}
