package com.example.proyectocheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkBoxCycling;
    private CheckBox chkBoxTeaching;
    private CheckBox chkBoxBlogging;
    private Button getHobby;
    private TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
        //version 1: evento sobre boton.
        getHobby.setOnClickListener((v)-> getHobbyClick(v));

        //version 2:evento sobre checkbox
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());

    }

    public void initialUISetup(){
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        getHobby = (Button) findViewById(R.id.btnHobby);
        txtHobby = (TextView) findViewById(R.id.txtHobby);
    }

    public void getHobbyClick(View v)
    {
        String strMessage = "";
        if(chkBoxCycling.isChecked())
        {
            strMessage+="Cycling ";
        }
        if(chkBoxTeaching.isChecked())
        {
            strMessage+="Teaching ";
        }
        if(chkBoxBlogging.isChecked())
        {
            strMessage+="Blogging ";
        }
        showTextNotification(strMessage);
    }


    public void showTextNotification(String msgToDisplay)
    {
        //version 1: mensaje en el textview
        txtHobby.setText(msgToDisplay);

        //version 2: mensaje en un toast
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

            //version 2 mejorada: comprobar todos los checkbox a la vez
           String result = "";
            if(chkBoxBlogging.isChecked()){
                result+="Blogging ";
            }
            if(chkBoxCycling.isChecked()){
                result+="Cycling ";
            }
            if(chkBoxTeaching.isChecked()){
                result+="Teaching ";
            }
            showTextNotification(result);

            //version 2: clase interna
            /*
            if(isChecked){
                if(buttonView==chkBoxCycling){
                    showTextNotification("Cycling");
                }if(buttonView==chkBoxTeaching){
                    showTextNotification("Teaching");
                }if(buttonView==chkBoxBlogging){
                    showTextNotification("Blogging");
                }
            }*/
        }

    }// clase interna

}

