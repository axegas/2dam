package com.example.operacionessencillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblResultado;
    private RadioGroup rgOperaciones;
    private EditText txtNum1;
    private EditText txtNum2;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        rgOperaciones = (RadioGroup)findViewById(R.id.rgOperaciones);
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);

        btnCalcular.setOnClickListener(v -> {
            String resultado="";
            int id = rgOperaciones.getCheckedRadioButtonId();

            try {
                switch (id) {
                    case R.id.rbSuma:
                        resultado += Integer.parseInt(String.valueOf(txtNum1.getText())) + Integer.parseInt(String.valueOf(txtNum2.getText()));
                        break;
                    case R.id.rbResta:
                        resultado += Integer.parseInt(String.valueOf(txtNum1.getText())) - Integer.parseInt(String.valueOf(txtNum2.getText()));
                        break;
                    default:
                        break;
                }
            }catch (Exception e){

            }
            lblResultado.setText(resultado);
        });
    }
}