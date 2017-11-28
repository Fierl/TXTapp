package com.example.simonfierbeck.txtapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.example.simonfierbeck.txtapp.TrainingActivity.Result.increaseAllChars;
import static java.security.AccessController.getContext;

/**
 * Created by Simon Fierbeck on 16.10.2017.
 */

public class TrainingActivity extends AppCompatActivity {
    String Tag = "Simon";
    String text = "All you do is stupid Poo.";
    String[] splitStr = text.split("\\s+");
    int tokenCounter = 0;
    Spannable token = new SpannableString(splitStr[tokenCounter]);
    Spannable nextToken = new SpannableString(splitStr[tokenCounter + 1]);
    int userCounter = 0;

    public TrainingActivity() throws FileNotFoundException {
        Log.i(Tag,"Hehe");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        //initialize the UI elements
        final TextView countdown = (TextView) findViewById(R.id.countdown);
        final EditText userInput = (EditText) findViewById(R.id.userInput);
        final TextView textField = (TextView) findViewById(R.id.charField);
        final TextView prevTextField = (TextView) findViewById(R.id.prevCharField);
        final TextView nextTextField = (TextView) findViewById(R.id.nextCharField);
        final TextView counterField = (TextView) findViewById(R.id.counter);
        //InputStream iS = view.getRessource().openRawRessource(R.raw.ExampleBook);

        //initialize TextViews with tokens
        textField.setText(token);
        nextTextField.setText(nextToken);
        prevTextField.setText("");
        textField.setTextSize((float) 20);
        prevTextField.setAlpha((float)0.5);
        nextTextField.setAlpha((float)0.5);


        //checking user input and char
        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (userInput.length() != 0 && text.length() != userCounter
                        && userInput.getText().charAt(0) == token.charAt(userCounter)) {
                    Result.increaseResult();
                    token.setSpan(new ForegroundColorSpan(Color.GREEN), userCounter, userCounter + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textField.setText(token);
                    userCounter++;
                    increaseAllChars();
                    if (token.length() == userCounter) {
                        prevTextField.setText(token);
                        tokenCounter++;
                        changeTextView(textField, 0);
                        if (splitStr.length > tokenCounter + 1) {
                            changeTextView(nextTextField, 1);
                        } else {
                            nextTextField.setText("");
                        }
                        userCounter = 0;
                        token = new SpannableString(splitStr[tokenCounter]);
                        textField.setTextSize((float) 20);
                    }
                }else if (userInput.length() != 0 && text.length() != userCounter
                            && userInput.getText().charAt(0) != token.charAt(userCounter)) {
                    token.setSpan(new ForegroundColorSpan(Color.RED), userCounter, userCounter + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textField.setText(token);
                    userCounter++;
                    increaseAllChars();
                    if (token.length() == userCounter) {
                        prevTextField.setText(token);
                        tokenCounter++;
                        changeTextView(textField, 0);
                        if (splitStr.length > tokenCounter + 1) {
                            changeTextView(nextTextField, 1);
                        } else {
                            nextTextField.setText("");
                        }
                        userCounter = 0;
                        token = new SpannableString(splitStr[tokenCounter]);
                        textField.setTextSize((float) 20);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //setting Countdown, using onTick to change TextViews

        new CountDownTimer(1000 * TrainingMenuActivity.trainingTimer.timer, 500) {


            public void onTick(long millisUntilFinished) {
                countdown.setText("seconds remaining: " + millisUntilFinished / 1000);
                userInput.setText("");
                counterField.setText(Integer.toString(Result.counter));
            }

            public void onFinish() {
                Intent i = new Intent(TrainingActivity.this,ResultActivity.class);
                startActivity(i);;
            }
        }.start();

    }

        /*
        Change the textView to the next token of the String
        Position has to be -1,0,1
         */
        private void changeTextView(TextView tV, int position){
        token = new SpannableString(splitStr[tokenCounter + position]);
        tV.setText(token);
    }


    public static class Result{
        static int counter = 0;
        static int allChars = 0;
        public static void increaseResult(){
            counter++;
        }
        public static void increaseAllChars(){allChars++;}
    }
}
