package com.fletes.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MAImagen extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maimagen);
        imageView = findViewById(R.id.imgVisor);
        this.obtenerImg();
    }

    private void obtenerImg(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("img");
        imageView.setImageResource(imagen);
    }
}