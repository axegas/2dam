package com.example.ejemploactividadhermosa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    private TextView txtIgual;
    private Button btnSuma;
    private Button btnRaiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        txtIgual = (TextView) findViewById(R.id.txtIgual);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnRaiz = (Button) findViewById(R.id.btnRaiz);

        btnSuma.setOnClickListener(this::onClick);
        btnRaiz.setOnClickListener(this::onClick);

    }

    private void onClick(View e) {
        double num1 = Double.parseDouble(String.valueOf(txt1.getText()));
        double res = 0;
        switch (e.getId()){
            case R.id.btnSuma:
                double num2 = Double.parseDouble(String.valueOf(txt2.getText()));
                res = num1 + num2;
                break;
            case R.id.btnRaiz:
                res = Math.sqrt(num1);
                break;
            default:
                break;
        }
        txtIgual.setText(Double.toString(res));
    }
}