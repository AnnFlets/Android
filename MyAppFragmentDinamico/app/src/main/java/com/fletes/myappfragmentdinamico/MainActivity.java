package com.fletes.myappfragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment1, fragment2, fragment3;
    private FragmentTransaction transaction;
    private Button buttonFrg1, buttonFrg2, buttonFrg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();
        buttonFrg1 = findViewById(R.id.btnFrgUnoN);
        buttonFrg2 = findViewById(R.id.btnFrgDosN);
        buttonFrg3 = findViewById(R.id.btnFrgTresN);
        //Reemplazamos el contenedor de fragmentos (fragments) por un fragment en específico
        /*getSupportFragmentManager().beginTransaction().replace(R.id.frlContenedor, fragment1).disallowAddToBackStack().commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frlContenedor, fragment2).disallowAddToBackStack().commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frlContenedor, fragment3).disallowAddToBackStack().commit();*/
        //Agregamos la cantidad de fragments que deseemos al contenedor, donde ocultamos, mostramos
        //e inicializamos a los fragments a criterio
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment3).hide(fragment3).commit();
        this.click(buttonFrg1, buttonFrg2, buttonFrg3);
    }

    private void click(Button buttonFrg1, Button buttonFrg2, Button buttonFrg3) {
        buttonFrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragment1.isAdded()){
                    transaction.hide(fragment2).hide(fragment3).show(fragment1);
                }else{
                    transaction.hide(fragment2).hide(fragment3).add(R.id.frlContenedor, fragment1);
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
        });
        buttonFrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragment2.isAdded()){
                    transaction.hide(fragment1).hide(fragment3).show(fragment2);
                }else{
                    transaction.hide(fragment1).hide(fragment3).add(R.id.frlContenedor, fragment2);
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
        });
        buttonFrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragment3.isAdded()){
                    transaction.hide(fragment1).hide(fragment2).show(fragment3);
                }else{
                    transaction.hide(fragment1).hide(fragment2).add(R.id.frlContenedor, fragment3);
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
        });
    }
}