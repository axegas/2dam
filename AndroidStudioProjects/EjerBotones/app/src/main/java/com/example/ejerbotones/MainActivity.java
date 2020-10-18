package com.example.ejerbotones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnRed;
    private ImageButton btnBlue;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = (ImageButton) findViewById(R.id.btnRed);
        btnBlue = (ImageButton) findViewById(R.id.btnBlue);
        textView = (TextView) findViewById(R.id.textView);

        btnRed.setOnClickListener(v -> textView.setBackgroundColor(Color.RED));
        btnBlue.setOnClickListener(v -> textView.setBackgroundColor(Color.BLUE));


    }
}