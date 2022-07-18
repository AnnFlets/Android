package com.fletes.myappbisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class MA2 extends AppCompatActivity {

    private TextView textViewBisiesto, textViewMeses, textViewSemanas, textViewDias;
    private Button buttonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma2);
        textViewBisiesto = findViewById(R.id.txtBisiesto);
        textViewMeses = findViewById(R.id.txtMeses);
        textViewSemanas = findViewById(R.id.txtSemanas);
        textViewDias = findViewById(R.id.txtDias);
        buttonRegresar = findViewById(R.id.btnRegresar);
        obtenerDatos();
        this.click();
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String anio = bundle.getString("anio");
            int anioB = Integer.valueOf(anio);
            if(anioB % 4 == 0 && (anioB % 100 != 0 || anioB % 400 == 0)){
                textViewBisiesto.setText("BISIESTO");
            }else{
                textViewBisiesto.setText("NO BISIESTO");
            }
            Calendar calen1 = Calendar.getInstance();
            Calendar calen2 = Calendar.getInstance();
            calen1.set(Calendar.YEAR, anioB);
            calen1.set(Calendar.MONTH, Calendar.JANUARY);
            calen1.set(Calendar.DAY_OF_MONTH, 1);
            calen2.set(Calendar.YEAR, anioB + 1);
            calen2.set(Calendar.MONTH, Calendar.JANUARY);
            calen2.set(Calendar.DAY_OF_MONTH, 1);
            long milis = calen2.getTimeInMillis() - calen1.getTimeInMillis();
            long dias = milis / 1000 / 60 / 60 / 24;
            long semanas = milis / 1000 / 60 / 60 / 24 / 7;
            long meses = milis / 1000 / 60 / 60 / 24 / 30;
            String dia = String.valueOf(dias);
            String semana = String.valueOf(semanas);
            String mes = String.valueOf(meses);
            textViewMeses.setText(mes);
            textViewSemanas.setText(semana);
            textViewDias.setText(dia);
        }else{
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }
    }

    private void click() {
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarAPrincipal();
            }
        });
    }

    private void regresarAPrincipal(){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}