package com.iqama.headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReceveMessage extends AppCompatActivity {


    Button ThirdApp;
    Handler handler;


    public static final String EXTRA_MESSAGE = "massage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receve_message);
        ThirdApp = findViewById(R.id.thirdApp);
        TextView txt = findViewById(R.id.display_msg);
        Intent intent = getIntent();
        String massage = intent.getStringExtra(EXTRA_MESSAGE);
        txt.setText(massage);


        ThirdApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Activit will start in 3 seconds",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,20,50);
                toast.show();



                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ThirdAppIntent = new Intent(ReceveMessage.this, StopWatch.class);
                        startActivity(ThirdAppIntent);
                    }
                }, 3000);
            }
        });
    }
}