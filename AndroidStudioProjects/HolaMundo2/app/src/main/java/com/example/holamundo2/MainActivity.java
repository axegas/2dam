package com.example.holamundo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,Pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajeSaludo = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO",mensajeSaludo);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
                elSaludo.setText(mensajeSaludo.toUpperCase());
                showToast("Pulsado");
            }
        });
    }

    protected void showToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }
}