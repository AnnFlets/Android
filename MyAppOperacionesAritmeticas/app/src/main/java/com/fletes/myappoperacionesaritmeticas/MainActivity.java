package com.fletes.myappoperacionesaritmeticas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResultado;
    private EditText editTextNumero1, editTextNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResultado = findViewById(R.id.txtResultado);
        editTextNumero1 = findViewById(R.id.edtNumero1);
        editTextNumero2 = findViewById(R.id.edtNumero2);
    }

    private void suma(){
        String numero1 = editTextNumero1.getText().toString();
        String numero2 = editTextNumero2.getText().toString();
        if(!numero1.isEmpty() && !numero2.isEmpty()){
            int resultado = Integer.parseInt(numero1) + Integer.parseInt(numero2);
            textViewResultado.setText("El resultado de la suma es: " + resultado);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void resta(){
        String numero1 = editTextNumero1.getText().toString();
        String numero2 = editTextNumero2.getText().toString();
        if(!numero1.isEmpty() && !numero2.isEmpty()){
            int resultado = Integer.parseInt(numero1) - Integer.parseInt(numero2);
            textViewResultado.setText("El resultado de la resta es: " + resultado);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void multiplicacion(){
        String numero1 = editTextNumero1.getText().toString();
        String numero2 = editTextNumero2.getText().toString();
        if(!numero1.isEmpty() && !numero2.isEmpty()){
            int resultado = Integer.parseInt(numero1) * Integer.parseInt(numero2);
            textViewResultado.setText("El resultado de la multiplicación es: " + resultado);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void division(){
        String numero1 = editTextNumero1.getText().toString();
        String numero2 = editTextNumero2.getText().toString();
        if(!numero1.isEmpty() && !numero2.isEmpty()){
            if(!numero2.equals("0")) {
                int resultado = Integer.parseInt(numero1) / Integer.parseInt(numero2);
                textViewResultado.setText("El resultado de la división es: " + resultado);
            }else{
                Toast.makeText(this, "Error, división entre 0", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void mayor(){
        String numero1 = editTextNumero1.getText().toString();
        String numero2 = editTextNumero2.getText().toString();
        if(!numero1.isEmpty() && !numero2.isEmpty()){
            int num1 = Integer.parseInt(numero1);
            int num2 = Integer.parseInt(numero2);
            if(num1 > num2){
                textViewResultado.setText("El número mayor es: " + numero1);
            }else if(num2 > num1){
                textViewResultado.setText("El número mayor es: " + numero2);
            }else{
                textViewResultado.setText("Los números son iguales");
            }
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSumar:
                this.suma();
                break;
            case R.id.btnRestar:
                this.resta();
                break;
            case R.id.btnMultiplicar:
                this.multiplicacion();
                break;
            case R.id.btnDividir:
                this.division();
                break;
            case R.id.btnMayor:
                this.mayor();
                break;
        }
    }
}