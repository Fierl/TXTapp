package com.example.simonfierbeck.txtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Simon Fierbeck on 26.10.2017.
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTitle = (TextView) findViewById(R.id.resultTitle);
        TextView result = (TextView) findViewById(R.id.result);
        if(TrainingActivity.Result.counter == TrainingActivity.Result.allChars){
            resultTitle.setText("Shizzle ma nizzle");
        }else if(TrainingActivity.Result.counter >= TrainingActivity.Result.allChars / 2){
            resultTitle.setText("Nicely Done!");
        }else{
            resultTitle.setText("Better luck next time fella");
        }
        result.setText(Integer.toString(TrainingActivity.Result.counter) + "/" + TrainingActivity.Result.allChars);
    }
    public void changeToMenu(View v){
        Intent i = new Intent(ResultActivity.this,MenuActivity.class);
        startActivity(i);
    }
    public void changeToTraining(View v){
        TrainingActivity.Result.counter = 0;
        Intent i = new Intent(ResultActivity.this,TrainingMenuActivity.class);
        startActivity(i);
    }
}
