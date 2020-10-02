package com.example.proysuma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button btnSuma;
    private TextView tvResultado;
    private int COD_RESULTADO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnSuma.setOnClickListener(v->{
            Double num1d = Double.parseDouble(num1.getText().toString());
            Double num2d = Double.parseDouble(num2.getText().toString());
            Intent intent = new Intent(MainActivity.this,Resultado.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("num1",num1d);
            bundle.putDouble("num2",num2d);
            intent.putExtras(bundle);
            startActivityForResult(intent,COD_RESULTADO);
        });
    }

    public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            String resultado = otroBundle.getString("correcto");
            tvResultado.setText(resultado);
            Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();
        }
    }
}