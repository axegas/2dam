package com.example.cambioentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvPantalla1;
    private Button btnPantalla2;
    private Button btnPantalla3;

    private final int PANTALLA_2 = 2;
    private final int PANTALLA_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPantalla1 = (TextView) findViewById(R.id.tvPantalla1);
        btnPantalla2 = (Button) findViewById(R.id.btnPantalla2);
        btnPantalla3 = (Button) findViewById(R.id.btnPantalla3);

        btnPantalla2.setOnClickListener(v -> click(btnPantalla2));
        btnPantalla3.setOnClickListener(v -> click(btnPantalla3));
    }

    private void click(View v){
        int id = v.getId();
        Class c = MainActivity.class;
        Intent intent;
        int requestCode = 0;
        switch (id){
            case R.id.btnPantalla2:
                c = Pantalla2.class;
                requestCode = PANTALLA_2;
                break;
            case R.id.btnPantalla3:
                c = Pantalla3.class;
                requestCode = PANTALLA_3;
                break;
        }
        intent = new Intent(MainActivity.this, c);
        startActivityForResult(intent, requestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tvPantalla1.setText("Pantalla 1, vuelta de la pantalla " + requestCode);
    }
}