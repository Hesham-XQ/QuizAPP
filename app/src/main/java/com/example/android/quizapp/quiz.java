package com.example.android.quizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

EditText edit ;
String j = "Japan" ;
    String j1 = "JAPAN" ;
    String j2 = "japan" ;
    CheckBox right1 , right2 , wrong1 , wrong2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        edit = (EditText) findViewById(R.id.edit);

        right1 = (CheckBox) findViewById(R.id.right1);
        right2 = (CheckBox) findViewById(R.id.right2);
        wrong1 = (CheckBox) findViewById(R.id.wrong1);
        wrong2 = (CheckBox) findViewById(R.id.wrong2);

    }


    public void getResults(View view) {

        boolean rightcheck = right1.isChecked();
        String editAnswer = edit.getText().toString();
        //play sound when button clicked
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.switchon);

        mp.start();

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





           /*score calculation*/
            int score = calculateScore(answerArray , editAnswer);

            String resultMessage = "-";


            resultMessage = resultSummary(score, nameValue);

        /*displaying score*/
            displayScore(resultMessage);

        // display score as toast message
            Toast scoreMessage = Toast.makeText(this, "your score = " + String.valueOf(score) + " out of 10", Toast.LENGTH_LONG);
            scoreMessage.show();
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
    private int calculateScore(boolean scoreArray[] , String editAnswer) {
        int methodScore = 0;
        for (int i = 0; i < 9; i++) {
            if (scoreArray[i]) {
                methodScore = methodScore + 1;
            }
        }

        if (editAnswer.equals(j) || editAnswer.equals(j1) || editAnswer.equals(j2) ){
            methodScore = methodScore + 1;
        }



        if (wrong1.isChecked() || wrong2.isChecked()){

            return methodScore;

        }

        else if (right1.isChecked() && right2.isChecked())
        {
            methodScore = methodScore + 1;
        }


        return methodScore;
    }



    private void displayScore(String message) {
        TextView resultText = (TextView) findViewById(R.id.result_display);
        resultText.setText(message);
    }


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


        // to clear the edit text field
        edit.setText("");

        //to check the right answers
        right1.setChecked(false);
        right2.setChecked(false);
        wrong1.setChecked(false);
        wrong2.setChecked(false);
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


        //to write the answer in the edit text field
        edit.setText(j1);

        //to check the right answers
        right1.setChecked(true);
        right2.setChecked(true);
        wrong1.setChecked(false);
        wrong2.setChecked(false);

         //informative toast
        Toast infoMessage = Toast.makeText(this, getString(R.string.rightanswers), Toast.LENGTH_LONG);
        infoMessage.show();
    }


}
