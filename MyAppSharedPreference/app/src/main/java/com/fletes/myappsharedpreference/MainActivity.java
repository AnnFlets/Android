package com.fletes.myappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombreSP);
        editTextEdad = findViewById(R.id.edtEdadSP);
        button = findViewById(R.id.btnAlmacenarSP);
        this.click();
        this.obtenerDatos();
    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacenarDatos();
            }
        });
    }

    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty()
        && !editTextEdad.getText().toString().isEmpty()){
            //Instancia la clase SharedPreference para utilizar su objeto
            //ya que es el me permitirá realizar la acción de almacenado
            //El primer argumento del método o constructor es el nombre
            //del archivo. EL otro el modo, que es la accesibilidad del archivo
            //casi siempre es privado
            //Encuentra el archivo de ese nombre o lo crea si no lo encuentra
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
            String nombre = editTextNombre.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());
            //Almacenar los datos que se encuentran en las variables
            //Permite registrar a través de etiquetas xml un dato
            //A través de clave - valor
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", nombre);
            editor.putInt("edad", edad);
            //Terminamos el proceso y se ejecute
            //editor.commit();
            //Si se hizo el commit, realiza las instrucciones del if
            if(editor.commit() == true){
                //Limpiamos los edt
                editTextNombre.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos almacenados correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Error almacenamiento de datos", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
        //Se asignan los datos que están almacenados en el shared_pref
        //Se usa preferences.getString() para obtener los datos
        //El primero es el nombre o clave del valor y el segundo es el
        //parámetro base o valores por defecto es un valor del mismo tipo
        //Esto por si el archivo está vacío, que me devuelva esos valores
        String nombre = preferences.getString("nombre", "---");
        int edad = preferences.getInt("edad", 0);
        if(edad == 0){
            editTextEdad.setText("");
        }else{
            editTextEdad.setText(String.valueOf(edad));
        }
        editTextNombre.setText(String.valueOf(nombre));
    }
}