package com.fletes.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MA2 extends AppCompatActivity {

    private Button buttonR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma2);
        buttonR1 = findViewById(R.id.btnRegresar1);
        this.click();
    }

    private void click() {
        Intent intentA = new Intent(this, MainActivity.class);
        buttonR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentA);
            }
        });
    }
}