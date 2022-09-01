package com.fletes.myappejerciciosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextTelefono, editTextCorreo;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextCorreo = findViewById(R.id.edtCorreo);
        editTextTelefono = findViewById(R.id.edtTelefono);
        button = findViewById(R.id.btnGuardar);
        this.click();
        this.obtenerDatos();
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        if (!editTextNombre.getText().toString().isEmpty() &&
                !editTextApellido.getText().toString().isEmpty() &&
                !editTextTelefono.getText().toString().isEmpty() &&
                !editTextCorreo.getText().toString().isEmpty()) {
            SharedPreferences preferences = getSharedPreferences("DatosPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            String nombre = editTextNombre.getText().toString();
            String apellido = editTextApellido.getText().toString();
            String telefono = editTextTelefono.getText().toString();
            String correo = editTextCorreo.getText().toString();
            editor.putString("nombre", nombre);
            editor.putString("apellido", apellido);
            editor.putString("telefono", telefono);
            editor.putString("correo", correo);
            if (editor.commit() == true) {
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextTelefono.setText("");
                editTextCorreo.setText("");
                Toast.makeText(this, "Datos guardados con éxito", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPref", Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre", "---");
        String apellido = preferences.getString("apellido", "---");
        String telefono = preferences.getString("telefono", "---");
        String correo = preferences.getString("correo", "---");
        editTextNombre.setText(String.valueOf(nombre));
        editTextApellido.setText(String.valueOf(apellido));
        editTextTelefono.setText(String.valueOf(telefono));
        editTextCorreo.setText(String.valueOf(correo));
    }
}