package com.fletes.myappejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private Button buttonComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextEdad = findViewById(R.id.edtEdad);
        buttonComprobar = findViewById(R.id.btnComprobar);
        this.click();
    }

    private int verificarUsuario(){
        String nombre = editTextNombre.getText().toString();
        String edad = editTextEdad.getText().toString();
        int num = 1;
        if(!edad.isEmpty() && !nombre.isEmpty()){
            int edadUsuario = Integer.parseInt(edad);
            if(edadUsuario < 18){
                num = 2;
            }else{
                num = 3;
            }
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
        return num;
    }
    private void click() {
        Intent intent1 = new Intent(this, MainActivity2.class);
        Intent intent2 = new Intent(this, MainActivity3.class);
        buttonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificarUsuario() == 2){
                    startActivity(intent1);
                    finish();
                }
                if(verificarUsuario() == 3){
                    startActivity(intent2);
                    finish();
                }
            }
        });
    }
}