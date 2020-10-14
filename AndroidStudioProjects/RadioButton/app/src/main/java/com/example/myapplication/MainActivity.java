package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblResultado;
    private RadioGroup rg;
    private EditText txtNum1;
    private EditText txtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblResultado = (TextView)findViewById(R.id.lblResultado);
        rg = (RadioGroup)findViewById(R.id.gruporb);

        //rg.clearCheck();

        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);





        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String resultado="";

                /*
                if( group.getCheckedRadioButtonId()==R.id.radio1)
                    textoOpcion +="OPCION 1 con ID:" + checkedId;
                else if( group.getCheckedRadioButtonId()==R.id.radio2)
                    textoOpcion +="OPCION 2 con ID:" + checkedId ;
                 */

                //OTRA VERSION (calculadora):

                try {
                    switch (group.getCheckedRadioButtonId()) {
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
                txtNum2.setText("");
                txtNum1.setText("");
            }
        });
    }

}
