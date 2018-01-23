package com.example.android.quizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start_quiz);
     //   Button one = (Button) this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                mp.start();
                Intent myIntent = new Intent(MainActivity.this,
                        quiz.class);
                startActivity(myIntent);

            }
        });

    }
}
