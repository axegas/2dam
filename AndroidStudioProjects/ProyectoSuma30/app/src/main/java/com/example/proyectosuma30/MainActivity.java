package com.example.proyectosuma30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button btnSuma;
    private ImageView im;

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
        im = (ImageView) findViewById(R.id.ivVista);

        btnSuma.setOnClickListener(v -> {
            Double num1d = Double.parseDouble(num1.getText().toString());
            Double num2d = Double.parseDouble(num2.getText().toString());
            Intent intent = new Intent(MainActivity.this, Resultado.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("num1", num1d);
            bundle.putDouble("num2", num2d);
            intent.putExtras(bundle);
            startActivityForResult(intent, COD_RESULTADO);
        });

        im.setOnClickListener(v -> {
            if (im.getX() == 0) {
                im.setX(400);
                im.setY(400);
            }
            else
                im.setX(0);
        });

    }

    public void onActivityResult(int cod_resp, int cod_result, Intent intent) {
        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            String resultado = otroBundle.getString("correcto");
            tvResultado.setText(resultado);
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1:onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A1:onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "A1:onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A1:onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "A1:onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "A1:onDestroy", Toast.LENGTH_SHORT).show();
    }
}