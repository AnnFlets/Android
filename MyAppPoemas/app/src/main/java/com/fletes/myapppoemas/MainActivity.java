package com.fletes.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.boton1);
        button2 = findViewById(R.id.boton2);
        button3 = findViewById(R.id.boton3);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton1:
                Intent intent1 = new Intent(this, MA2.class);
                startActivity(intent1);
                break;
            case R.id.boton2:
                Intent intent2 = new Intent(this, MA3.class);
                startActivity(intent2);
                break;
            case R.id.boton3:
                Intent intent3 = new Intent(this, MA4.class);
                startActivity(intent3);
                break;
        }
    }
}