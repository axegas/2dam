package com.example.ejerradiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Version2 extends AppCompatActivity {

    private RadioGroup rgColores;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version2);

        rgColores = (RadioGroup) findViewById(R.id.rgColores);
        textView = (TextView) findViewById(R.id.textView);

        rgColores.setOnCheckedChangeListener((group, checkedId) -> {
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

    }
}