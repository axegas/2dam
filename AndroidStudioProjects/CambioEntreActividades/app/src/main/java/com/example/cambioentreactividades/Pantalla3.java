package com.example.cambioentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Pantalla3 extends AppCompatActivity {

    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        volver = (Button) findViewById(R.id.btnVolver3);

        volver.setOnClickListener(v -> {
            Intent salir = new Intent(this, MainActivity.class);
            setResult(Activity.RESULT_OK, salir);
            finish();
        });
    }
}