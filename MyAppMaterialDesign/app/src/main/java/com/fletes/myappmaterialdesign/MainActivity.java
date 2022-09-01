package com.fletes.myappmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonSnackBar, buttonDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSnackBar = findViewById(R.id.btnSnackBar);
        buttonDialogo = findViewById(R.id.btnDialogo);
        this.click();
    }

    private String[] construirArray(){
        String[] itemsDialog = new String[3];
        itemsDialog[0] = "Rojo";
        itemsDialog[1] = "Amarillo";
        itemsDialog[2] = "Azul";
        return itemsDialog;
    }

    private boolean[] arrayBoolean(){
        //Si están checkeados o no los elementos
        boolean[] condition = new boolean[3];
        condition[0] = false;
        condition[1] = false;
        condition[2] = false;
        return condition;
    }

    private void click() {
        buttonSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //La snackbar es como un Toast, pero que contiene un texto que permite realizar una acción.
                //Se declara el objeto snackbar, se manda la vista, el texto que este tendrá, y cuánto durará su aparición.
                //LENGTH_SHORT --> tiempo corto | LENGTH_LONG --> tiempo largo | LENGTH_INDEFINITE --> tiempo indefinido
                Snackbar snackbar = Snackbar.make(v, "You just clicked the snackbar button", Snackbar.LENGTH_SHORT);
                //Permite que un snackbar no cubra un componente (especialmente de navegación), por lo que se utiliza el método setAnchorView(elemento),
                //y se manda como parámetro el elemento que no queremos cubrir, haciendo que el snackbar aparezca arriba de este.
                snackbar.setAnchorView(buttonDialogo);
                //Nos permite establecer el tiempo que el snackbar permanecerá visible. El tiempo es en milisegundos.
                //Inhabilita el Snackbar.LENGTH_SHORT, Snackbar.LENGTH_LONG y Snackbar.LENGTH_INDEFINITE
                snackbar.setDuration(10000);
                //Agregar una animación
                //ANIMATION_MODE_FADE --> aparece y se desvanece | ANIMATION_MODE_SLIDE --> se desliza desde el fondo y se desliza hasta desaparecer abajo
                snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                //Para establecer un texto con acción en el snackbar
                snackbar.setAction("OKAY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Acción a ocurrir al pulsar el texto del snackbar
                        buttonDialogo.setBackgroundColor(Color.RED);
                    }
                });
                //Mostrar el snackbar
                snackbar.show();
            }
        });
        buttonDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el objeto Dialogo, mandando el contexto como parámetro
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
                //Poner título al diálogo
                builder.setTitle("Mensaje de alerta");
                //Establecer una lista de elementos, donde se seleccione solo 1
                //checkedItem es el valor checkeado por defecto
                /*builder.setSingleChoiceItems(construirArray(), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Seleccionó: " + which, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });*/
                builder.setMultiChoiceItems(construirArray(), arrayBoolean(), new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                //Poner mensaje
                //builder.setMessage("Este es un mensaje cualquiera solo para probar este componente xd");
                //Agregar un ícono
                //builder.setIcon(R.mipmap.ic_launcher);
                //Colocar botones para realizar una acción si se acepta o niega algo, de acuerdo a lo que se seleccione
                //Botón positivo
                builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Terminos aceptados", Toast.LENGTH_SHORT).show();
                    }
                });
                //Botón negativo
                builder.setNegativeButton("NOPE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Terminos denegados", Toast.LENGTH_SHORT).show();
                    }
                });
                //PERSONALIZAR DIALOG
                builder.setBackground(getResources().getDrawable(R.drawable.dialogo_design, null));
                //Mostrar dialogo
                builder.show();
            }
        });
    }

}