package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.checkbox_daxter;
import static com.example.android.quizapp.R.id.checkbox_knuckles;
import static com.example.android.quizapp.R.id.checkbox_luigi;
import static com.example.android.quizapp.R.id.checkbox_ninty;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void quizResults(View view) {
        RadioButton ninty = (RadioButton) findViewById(checkbox_ninty);
        boolean nintySelected = ninty.isChecked();

        CheckBox knuckles = (CheckBox) findViewById(checkbox_knuckles);
        boolean knucklesSelected = knuckles.isChecked();

        CheckBox daxter = (CheckBox) findViewById(checkbox_daxter);
        boolean daxterSelected = daxter.isChecked();

        CheckBox luigi = (CheckBox) findViewById(checkbox_luigi);
        boolean luigiChecked = luigi.isChecked();

        RadioButton shenmueTrue = (RadioButton) findViewById(R.id.shenmue_false_1);
        boolean shenmueSelected = shenmueTrue.isChecked();

        RadioButton namcoTrue = (RadioButton) findViewById(R.id.namco_true);
        boolean namcoSelected = namcoTrue.isChecked();

        EditText microTrue = (EditText) findViewById(R.id.autoCompleteTextView1);
        String microNewMachine = microTrue.getText().toString();
        boolean micro = microNewMachine.matches("Xbox One X");

        if (nintySelected && shenmueSelected && namcoSelected && luigiChecked && knucklesSelected && !daxterSelected && micro) {
            winToastMessage();
        } else {
            looseToastMessage2();
        }

    }


    private void winToastMessage() {
        Context context = getApplicationContext();
        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();
        CharSequence CongratulationsText = "Wooohoo!! " + yourName + " you are a true hardcore gamer!!";
        int duration = Toast.LENGTH_LONG;

        Toast successToastResult = Toast.makeText(context, CongratulationsText, duration);
        successToastResult.show();

    }


    private void looseToastMessage2() {
        Context context = getApplicationContext();
        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();
        CharSequence looseText = "You can do better than that!! " + yourName + " attempt to answer the questions again!!";
        int duration = Toast.LENGTH_LONG;

        Toast looseToastResult = Toast.makeText(context, looseText, duration);
        looseToastResult.show();
    }

}
