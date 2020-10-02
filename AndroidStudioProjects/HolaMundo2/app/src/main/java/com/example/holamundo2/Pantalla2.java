package com.example.holamundo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.miMensaje);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        final Button miBotonVolver = (Button) findViewById(R.id.botonVolver);

        miBotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}