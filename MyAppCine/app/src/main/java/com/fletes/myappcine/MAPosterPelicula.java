package com.fletes.myappcine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MAPosterPelicula extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maposter_pelicula);
        imageButton = findViewById(R.id.imgBtnCerrar);
        imageView = findViewById(R.id.imgPosterPelicula);
        obtenerImgPoster();
        this.click();
    }

    private void click() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void obtenerImgPoster(){
        Bundle bundle = getIntent().getExtras();
        int imgPoster = bundle.getInt("img");
        imageView.setImageResource(imgPoster);
    }
}