package com.fletes.myappejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private TextView textViewNumero1, textViewNumero2;
    private EditText editTextRespuesta;
    private Button buttonVeficarM, buttonRegresarM;
    private int numAleatorio = 10;
    private int multiplicacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textViewNumero1 = findViewById(R.id.txtNum1);
        textViewNumero2 = findViewById(R.id.txtNum2);
        editTextRespuesta = findViewById(R.id.edtRespuesta);
        buttonVeficarM = findViewById(R.id.btnVerificarM);
        buttonRegresarM = findViewById(R.id.btnRegresarM);
        insertarNumerosMultiplicacion();
    }

    private void insertarNumerosMultiplicacion(){
        int num1 = (int) (Math.random()*numAleatorio);
        int num2 = (int) (Math.random()*numAleatorio);
        textViewNumero1.setText(String.valueOf(num1));
        textViewNumero2.setText(String.valueOf(num2));
        multiplicacion = num1 * num2;
    }

    private void verificarMultiplicacion(){
        int respuesta = Integer.parseInt(editTextRespuesta.getText().toString());
        if(respuesta == multiplicacion){
            Toast.makeText(this, "Excelente, eres todo un adulto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrecto, vuelve a intentarlo", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickM(View view) {
        switch (view.getId()){
            case R.id.btnVerificarM:
                verificarMultiplicacion();
                break;
            case R.id.btnRegresarM:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}