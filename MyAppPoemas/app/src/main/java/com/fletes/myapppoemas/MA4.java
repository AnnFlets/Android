package com.fletes.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MA4 extends AppCompatActivity {

    private Button buttonR3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma4);
        buttonR3 = findViewById(R.id.btnRegresar3);
        this.click();
    }

    private void click() {
        Intent intentC = new Intent(this, MainActivity.class);
        buttonR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentC);
            }
        });
    }
}