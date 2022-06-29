package com.fletes.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables globales que representarán a los elementos views
    private TextView textViewContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establecer las view que se van a utilizar identificándolas por medio de su id
        textViewContador = findViewById(R.id.txtContador);
    }

    private void mas(){
        this.contador++;
        this.textViewContador.setText(String.valueOf(contador));
    }

    private void menos(){
        this.contador--;
        this.textViewContador.setText(String.valueOf(contador));
    }

    private void reiniciar(){
        this.contador = 0;
        this.textViewContador.setText(String.valueOf(contador));
        Toast.makeText(this, "El contador se reinició a 0", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        //Es como el getSource(), identifica de donde viene el click
        if(view.getId() == R.id.btnMas){
            this.mas();
        }
        if(view.getId() == R.id.btnMenos){
            this.menos();
        }
        if(view.getId() == R.id.btnReiniciar){
            this.reiniciar();
        }
    }
}