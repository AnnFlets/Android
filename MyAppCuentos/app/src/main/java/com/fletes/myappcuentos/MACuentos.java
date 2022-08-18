package com.fletes.myappcuentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MACuentos extends AppCompatActivity {

    private Button buttonAtras, buttonSiguiente;
    private Fragment fragmentA, fragmentB, fragmentC, fragmentD, fragmentE;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macuentos);
        buttonAtras = findViewById(R.id.btnAtras);
        buttonSiguiente = findViewById(R.id.btnSiguiente);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentD = new FragmentD();
        fragmentE = new FragmentE();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentA).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentB).hide(fragmentB).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentC).hide(fragmentC).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentD).hide(fragmentD).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentE).hide(fragmentE).commit();
        this.click();
    }

    private void click() {
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragmentA.isVisible()){
                    if(fragmentE.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).show(fragmentE);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).add(R.id.flContenedor, fragmentE);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentB.isVisible()){
                    if(fragmentA.isAdded()){
                        transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentA);
                    }else{
                        transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentA);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentC.isVisible()){
                    if(fragmentB.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentB);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentB);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentD.isVisible()){
                    if(fragmentC.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).show(fragmentC);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentC);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentE.isVisible()){
                    if(fragmentD.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).show(fragmentD);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).add(R.id.flContenedor, fragmentD);
                        transaction.addToBackStack(null);
                    }
                }
                transaction.commit();
            }
        });
        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                if(fragmentA.isVisible()){
                    if(fragmentB.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentB);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentB);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentB.isVisible()){
                    if(fragmentC.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).show(fragmentC);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentC);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentC.isVisible()){
                    if(fragmentC.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).show(fragmentD);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).add(R.id.flContenedor, fragmentD);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentD.isVisible()){
                    if(fragmentD.isAdded()){
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).show(fragmentE);
                    }else{
                        transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).add(R.id.flContenedor, fragmentE);
                        transaction.addToBackStack(null);
                    }
                }else if(fragmentE.isVisible()){
                    if(fragmentA.isAdded()){
                        transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentA);
                    }else{
                        transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.flContenedor, fragmentA);
                        transaction.addToBackStack(null);
                    }
                }
                transaction.commit();
            }
        });
    }
}