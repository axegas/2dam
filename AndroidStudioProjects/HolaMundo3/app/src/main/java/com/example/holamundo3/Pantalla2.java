package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final Button volverBtn= (Button)findViewById(R.id.miVolver);


        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo=miBundleRecoger.getString("TEXTO");
        volverBtn.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent= new Intent();
                Bundle vueltaBundle=new Bundle();
                String mensajeDevuelto= "Devuelvo a Principal " + completarSaludo;
                vueltaBundle.putString("DEVUELTO", mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK, vueltaIntent);
                finish();

            }
        });

    }
    /* Proceso para entender el ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart-Pantalla2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume-Pantalla2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause-Pantalla2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop-Pantalla2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart-Pantalla2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
*/
}