package com.example.proysuma;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVolver;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        Bundle bundle = getIntent().getExtras();
        Double num1 = bundle.getDouble("num1");
        Double num2 = bundle.getDouble("num2");

        resultado = "El resultado de la suma es: " + Double.toString(num1+num2);
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
}