package com.fletes.myappcuentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.imgBtnCuento);
        this.click();
    }

    private void click() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irCuentos();
            }
        });
    }

    private void irCuentos(){
        Intent intent = new Intent(this, MACuentos.class);
        this.startActivity(intent);
    }
}