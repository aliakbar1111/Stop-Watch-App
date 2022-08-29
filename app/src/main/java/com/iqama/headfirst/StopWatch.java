package com.iqama.headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {

    private int seconds =0;
    private boolean isRunning;
    TextView watch_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button startB, stopB, resetB;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        watch_View = findViewById(R.id.time_view);
        runTime();

    }


    public void onClickStart(View view) {
        isRunning = true;

    }

    public void onClickStop(View view) {
        isRunning = false;
    }

    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
    }
    void runTime(){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                    int hours = seconds/3600;
                    int minutes = (seconds%3600)/60;
                    int secs = seconds%60;
                    String time = String.format(Locale.getDefault(),
                            "%d:%02d:%02d", hours, minutes, secs);
                        watch_View.setText(time);
                        if (isRunning){
                            seconds ++;
                        }
                        handler.postDelayed(this,1000);
            }

        });
    }


}