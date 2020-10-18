package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ConstraintLayout extends AppCompatActivity {

    private Button botonPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        botonPrueba = (Button) findViewById(R.id.botonPrueba);

        botonPrueba.setOnClickListener(v -> {
            Intent salir = new Intent(this, MainActivity.class);
            setResult(Activity.RESULT_OK, salir);
            finish();
        });
    }
}