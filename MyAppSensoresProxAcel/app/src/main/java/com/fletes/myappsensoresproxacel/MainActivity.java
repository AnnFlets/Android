package com.fletes.myappsensoresproxacel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonProximidad, buttonAcelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonProximidad = findViewById(R.id.btnProximidad);
        buttonAcelerometro = findViewById(R.id.btnAcelerometro);
        this.click();
    }

    private void click() {
        buttonProximidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irProximidad();
            }
        });
        buttonAcelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAcelerometro();
            }
        });
    }

    private void irProximidad(){
        Intent intent = new Intent(this, MAProximidad.class);
        startActivity(intent);
    }

    private void irAcelerometro(){
        Intent intent = new Intent(this, MAAcelerometro.class);
        startActivity(intent);
    }
}