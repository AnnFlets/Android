package com.fletes.myapprepaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonS = findViewById(R.id.btnConoceSuma);
        this.click();
    }

    private void click() {
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aperturaSuma();
            }
        });
    }
    private void aperturaSuma(){
        Intent intent = new Intent(this, MASuma.class);
    }
}