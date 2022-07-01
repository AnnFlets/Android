package com.fletes.myappejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewNum1, textViewNum2;
    private EditText editTextResultado;
    private Button buttonVerificar, buttonRegresar;
    private int numA = 10;
    private int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewNum1 = findViewById(R.id.txtNumero1);
        textViewNum2 = findViewById(R.id.txtNumero2);
        editTextResultado = findViewById(R.id.edtResultado);
        buttonRegresar = findViewById(R.id.btnRegresarS);
        buttonVerificar = findViewById(R.id.btnVerificarS);
        insertarNumerosSuma();
    }

    private void insertarNumerosSuma(){
        int num1 = (int) (Math.random()*numA);
        int num2 = (int) (Math.random()*numA);
        textViewNum1.setText(String.valueOf(num1));
        textViewNum2.setText(String.valueOf(num2));
        suma = num1 + num2;
    }

    private void verificarSuma(){
        int respuesta = Integer.parseInt(editTextResultado.getText().toString());
        if(respuesta == suma){
            Toast.makeText(this, "Es correcto, ya no eres un bebé", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrecto, vuelve a intentarlo", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickS(View view) {
        switch (view.getId()){
            case R.id.btnVerificarS:
                verificarSuma();
                break;
            case R.id.btnRegresarS:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}