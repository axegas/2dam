package com.example.ejerradiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnColores;
    private Button btnVersion2;
    private RadioGroup rgColores;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVersion2 = (Button) findViewById(R.id.btnVersion2);
        btnColores = (Button) findViewById(R.id.btnColores);
        rgColores = (RadioGroup) findViewById(R.id.rgColores);
        textView = (TextView) findViewById(R.id.textView);

        btnColores.setOnClickListener( v -> {
            int check = rgColores.getCheckedRadioButtonId();
            switch (check){
                case R.id.rbRojo:
                    textView.setBackgroundColor(Color.RED);
                    break;
                case R.id.rbAzul:
                    textView.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.rbVerde:
                    textView.setBackgroundColor(Color.GREEN);
                    break;
            }
        });

        btnVersion2.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this,Version2.class);
            startActivity(intent);
        });


    }
}