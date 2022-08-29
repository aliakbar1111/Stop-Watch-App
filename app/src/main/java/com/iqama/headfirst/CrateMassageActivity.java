package com.iqama.headfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrateMassageActivity extends AppCompatActivity {
    Button sendMessage, share_Button;
    EditText Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crate_massage);

        sendMessage = findViewById(R.id.sendMassage);

        Text = findViewById(R.id.massage);
        share_Button = findViewById(R.id.shareMassage);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrateMassageActivity.this, ReceveMessage.class);
                String input = Text.getText().toString();
                String message = makingMassage(input);
                intent.putExtra(ReceveMessage.EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        share_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = Text.getText().toString();
                String message = makingMassage(input);

                Intent share_Intent = new Intent(Intent.ACTION_SEND);
                share_Intent.setType("text/plain");
                share_Intent.putExtra(Intent.EXTRA_TEXT, message);

                Intent chooser = Intent.createChooser(share_Intent, getString(R.string.SEND_mas_via__));
                if (chooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }


            }
        });


    }

    String makingMassage(String massage) {
        if (massage.isEmpty()) {
            massage="You didn't enter any thing ";
            Text.setError("Plz Enter A Message");
        } else {
            return massage;
        }
        return massage;
    }
}