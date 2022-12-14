package com.iqama.headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.iqama.headfirst.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Spinner color;
    TextView brands;
    Button button;
    Button second_app;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        color = findViewById(R.id.spinner);
        brands = findViewById(R.id.textId);
        button = findViewById(R.id.find_beer);
        second_app =  findViewById(R.id.seconApp);

        second_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CrateMassageActivity.class);
                startActivity(intent);
            }
        });
        binding.goToStopWatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StopWatch.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String beerType = String.valueOf(color.getSelectedItem());
                expert ex = new expert();
                ArrayList<String> brandList = ex.getBrands(beerType);
                StringBuilder brandFormatted = new StringBuilder();

                for (String brand : brandList) {
                    brandFormatted.append(brand).append("\n");
                }
                brands.setText(brandFormatted);
            }
        });


    }
}