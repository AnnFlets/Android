package com.fletes.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MA3 extends AppCompatActivity {

    private Button buttonR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma3);
        buttonR2 = findViewById(R.id.btnRegresar2);
        this.click();
    }

    private void click() {
        Intent intentB = new Intent(this, MainActivity.class);
        buttonR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentB);
            }
        });
    }
}