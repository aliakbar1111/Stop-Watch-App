package com.iqama.headfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iqama.headfirst.databinding.ActivityStopWatchBinding;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {

    private int seconds =0;
    private boolean isRunning;

    ActivityStopWatchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button startB, stopB, resetB;
        binding = ActivityStopWatchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        super.onCreate(savedInstanceState);
        setContentView(view);

        if (savedInstanceState!= null){
            seconds = savedInstanceState.getInt("second");
            isRunning = savedInstanceState.getBoolean("running");
        }

        runTime();

    }

    @Override
    protected void onPause() {
        super.onPause();
      isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = true;
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
                        binding.timeView.setText(time);
                        if (isRunning){
                            seconds ++;
                        }
                        handler.postDelayed(this,1000);
            }

        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("second",seconds);
        outState.putBoolean("running",isRunning);
        super.onSaveInstanceState(outState);
    }
}