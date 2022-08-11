package com.fletes.myapplistapaises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MAPais extends AppCompatActivity {

    private TextView textViewNombre, textViewPoblacion;
    private ImageView imageView;
    private Button button;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapais);
        textViewNombre = findViewById(R.id.txtNomPais);
        textViewPoblacion = findViewById(R.id.txtPobPais);
        imageView = findViewById(R.id.imgPais);
        button = findViewById(R.id.btnRegresar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.obtenerInfo();
        this.click();
    }

    private void obtenerInfo() {
        Bundle bundle = getIntent().getExtras();
        int imagenP = bundle.getInt("img");
        int nombreP = bundle.getInt("nom");
        int poblacionP = bundle.getInt("pob");
        imageView.setImageResource(imagenP);
        textViewNombre.setText(nombreP);
        textViewPoblacion.setText(poblacionP);
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarPrincipal();
            }
        });
    }

    private void regresarPrincipal(){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemLike:
                Toast.makeText(this, "Me gusta", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemDislike:
                Toast.makeText(this, "No me gusta", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}