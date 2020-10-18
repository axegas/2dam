package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnLinearLayout;
    private ImageButton btnGridLayout;
    private ImageButton btnConstraintLayout;
    private ImageButton btnTableLayout;

    private final int LINEAR_LAYOUT = 1;
    private final int GRID_LAYOUT = 2;
    private final int CONSTRARINT_LAYOUT = 3;
    private final int TABLE_LAYOUT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearLayout = (ImageButton) findViewById(R.id.btnLinearLayout);
        btnGridLayout = (ImageButton) findViewById(R.id.btnGridLayout);
        btnConstraintLayout = (ImageButton) findViewById(R.id.btnConstraintLayout);
        btnTableLayout = (ImageButton) findViewById(R.id.btnTableLayout);

        btnLinearLayout.setOnClickListener( v -> click(btnLinearLayout));
        btnGridLayout.setOnClickListener( v -> click(btnGridLayout));
        btnConstraintLayout.setOnClickListener( v -> click(btnConstraintLayout));
        btnTableLayout.setOnClickListener( v -> click(btnTableLayout));
    }

    private void click(View v) {
        Intent intent;
        Class c = MainActivity.class;
        int requestCode = 0;
        switch (v.getId()) {
            case R.id.btnLinearLayout:
                c = LinearLayout.class;
                requestCode = LINEAR_LAYOUT;
                break;
            case R.id.btnGridLayout:
                c = GridLayout.class;
                requestCode = GRID_LAYOUT;
                break;
            case R.id.btnConstraintLayout:
                c = ConstraintLayout.class;
                requestCode = CONSTRARINT_LAYOUT;
                break;
            case R.id.btnTableLayout:
                c = TableLayout.class;
                requestCode = TABLE_LAYOUT;
                break;
        }
        intent = new Intent(MainActivity.this, c);
        startActivityForResult(intent, requestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String act = "";
        switch (requestCode) {
            case LINEAR_LAYOUT:
                act = "LinearLayout";
                break;
            case GRID_LAYOUT:
                act = "GridLayout";
                break;
            case CONSTRARINT_LAYOUT:
                act = "ConstraintLayout";
                break;
            case TABLE_LAYOUT:
                act = "TableLayout";
                break;
        }
        Toast.makeText(this,"Regresamos de un " + act, Toast.LENGTH_LONG).show();
    }
}