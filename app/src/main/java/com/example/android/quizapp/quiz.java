package com.example.android.quizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;

/**
 * Created by SAMO on 1/15/2018.
 */

public class quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
    }

    public void getResults(View view) {

        EditText txt = findViewById(R.id.name);
        String nameValue = txt.getText().toString();


        if (TextUtils.isEmpty(txt.getText())) {
            /**
             *   You can Toast a message here that the Username is Empty
             **/

            txt.setError("First name is required!");

                /*Error toast*/
            Toast resetMessage = Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG);
            resetMessage.show();
                /*scroll to the top*/
            ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrollview);
            scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        } else {
            //play sound when button clicked
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.switchon);

            mp.start();



        /*
        creates an array of answers
         */
            boolean answerArray[];
            answerArray = new boolean[10];
            RadioButton answer = (RadioButton) findViewById(R.id.answer_1);
            answerArray[0] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_2);
            answerArray[1] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_3);
            answerArray[2] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_4);
            answerArray[3] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_5);
            answerArray[4] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_6);
            answerArray[5] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_7);
            answerArray[6] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_8);
            answerArray[7] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_9);
            answerArray[8] = answer.isChecked();
            answer = (RadioButton) findViewById(R.id.answer_10);
            answerArray[9] = answer.isChecked();



           /*score calculation*/
            int score = calculateScore(answerArray);

            String resultMessage = "-";


            resultMessage = resultSummary(score, nameValue);

        /*displaying score*/
            displayScore(resultMessage);
        }
    }


    private String resultSummary(int score, String nameValue) {
        String resultMessage = getString(R.string.examiner_name, nameValue);
        resultMessage += "\n" + getString(R.string.score, score);
        resultMessage += "\n" + getString(R.string.thank_you);
        return resultMessage;

    }

    /*
   method calculating the overall score
    */
    private int calculateScore(boolean scoreArray[]) {
        int methodScore = 0;
        for (int i = 0; i < 10; i++) {
            if (scoreArray[i]) {
                methodScore = methodScore + 1;
            }
        }
        return methodScore;
    }
/*
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

    private void displayScore(String message) {
        TextView resultText = (TextView) findViewById(R.id.result_display);
        resultText.setText(message);
    }
    /*
    method displaying score on the screen
    *
    private void displayScore (int finalScore) {

        Toast scoreMessage = Toast.makeText(this,"your score = " , Toast.LENGTH_LONG);
        scoreMessage.show();
    }
*/

    public void resetQuiz(View view) {
        /*
         this part scrolls the screen back to the top of the view
         */
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrollview);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);
        /*
        this part resets the RadioGroups
        */
        RadioGroup choiceGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup3);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup4);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup5);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup6);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup7);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup8);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup9);
        choiceGroup.clearCheck();
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup10);
        choiceGroup.clearCheck();
        /*informative toast*/
        Toast resetMessage = Toast.makeText(this, getString(R.string.reset), Toast.LENGTH_LONG);
        resetMessage.show();

        //play sound when button clicked
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.switchon);

        mp.start();


    }


    /*
      * method that will show the user the correct answers
      * */
    public void correctAnswers(View view) {

        //play sound when button clicked
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.switchon);

        mp.start();

         /*
         this part scrolls the screen back to the top of the view
         */
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrollview);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);
        /*
        * this part sets the radio buttons for each RadioGroup to correct answer
        * */

        RadioGroup choiceGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        choiceGroup.check(R.id.answer_1);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        choiceGroup.check(R.id.answer_2);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup3);
        choiceGroup.check(R.id.answer_3);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup4);
        choiceGroup.check(R.id.answer_4);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup5);
        choiceGroup.check(R.id.answer_5);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup6);
        choiceGroup.check(R.id.answer_6);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup7);
        choiceGroup.check(R.id.answer_7);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup8);
        choiceGroup.check(R.id.answer_8);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup9);
        choiceGroup.check(R.id.answer_9);
        choiceGroup = (RadioGroup) findViewById(R.id.radioGroup10);
        choiceGroup.check(R.id.answer_10);
         /*informative toast*/
        Toast infoMessage = Toast.makeText(this, getString(R.string.rightanswers), Toast.LENGTH_LONG);
        infoMessage.show();
    }


}
