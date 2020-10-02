package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;

    TextView elSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        elSaludo= (TextView)findViewById(R.id.miLbl);


        //Si regreso de otra actividad
        if (savedInstanceState!=null){
            String mensajePasado=savedInstanceState.getString("TEXTO");
            elSaludo.setText(mensajePasado);

        }

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
            }

        });

    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent){
        if (cod_result== RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }
    /* Proceso para entender el ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause-ClasePrincipal", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy-ClasePrincipaly", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }*/



}