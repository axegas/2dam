package com.example.proyectosuma30;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        Bundle bundle = getIntent().getExtras();
        Double num1 = bundle.getDouble("num1");
        Double num2 = bundle.getDouble("num2");

        String resultado = "El resultado de la suma es: " + Double.toString(num1+num2);
        tvResultado.setText(resultado);
        showAlert(resultado);

        btnVolver.setOnClickListener(v -> {
            Intent vueltaIntent= new Intent();
            Bundle vueltaBundle=new Bundle();
            vueltaBundle.putString("correcto", "Resultado correcto!");
            vueltaIntent.putExtras(vueltaBundle);
            setResult(RESULT_OK, vueltaIntent);
            finish();
        });
    }

    protected void showAlert( CharSequence text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A2:onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A2:onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "A2:onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A2:onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "A2:onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "A2:onDestroy", Toast.LENGTH_SHORT).show();
    }
}