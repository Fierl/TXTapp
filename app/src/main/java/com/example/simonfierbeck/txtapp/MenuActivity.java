package com.example.simonfierbeck.txtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    protected void settingsBtnPress(View v){
        Intent i = new Intent(MenuActivity.this, SettingsActivity.class);
        startActivity(i);
    }
    protected void trainingBtnPress(View v){
        Intent i = new Intent(MenuActivity.this, TrainingMenuActivity.class);
        startActivity(i);
    }
}
