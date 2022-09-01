package com.fletes.myapppruebamaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView imagenLikeA, imagenLikeB, imagenLikeC;
    boolean like = false;
    private Button buttonSnackbar, buttonDialog;
    private boolean controlColorSnackbar = false;
    private boolean controlColorDialog = false;
    private ImageButton imageButtonCorazon;
    private FloatingActionButton floatingActionButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagenLikeA = findViewById(R.id.animationLikeA);
        imagenLikeB = findViewById(R.id.animationLikeB);
        imagenLikeC = findViewById(R.id.animationLikeC);
        buttonSnackbar = findViewById(R.id.btnSnackbar);
        buttonDialog = findViewById(R.id.btnDialog);
        imageButtonCorazon = findViewById(R.id.imgBtnCorazon);
        floatingActionButton = findViewById(R.id.fabColor);
        this.click();
    }

    private boolean likeAnimation(LottieAnimationView imagenLike, int animation, boolean like){
        if(!like){
            imagenLike.setAnimation(animation);
            imagenLike.setRepeatCount(0);
            imagenLike.playAnimation();
        }else{
            imagenLike.setImageResource(R.drawable.ic_corazon);
        }
        return !like;
    }

    private void click() {
        imageButtonCorazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeAnimation(imagenLikeA, R.raw.animation_like, like);
                likeAnimation(imagenLikeB, R.raw.animation_like, like);
                likeAnimation(imagenLikeC, R.raw.animation_like, like);
            }
        });
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearDialogo(v);
            }
        });
        buttonSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearSnackbar(v);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarColorBotonDialog();
            }
        });
    }

    private void cambiarColorBotonDialog(){
        if(controlColorDialog){
            buttonDialog.setBackgroundColor(Color.parseColor("#ED2E97"));
        }else{
            buttonDialog.setBackgroundColor(Color.BLUE);
        }
        controlColorDialog = !controlColorDialog;
    }

    private void crearDialogo(View view){
        //Crear el objeto diálogo
        MaterialAlertDialogBuilder builderDialog = new MaterialAlertDialogBuilder(MainActivity.this);
        //Poner título al diálogo
        builderDialog.setTitle("Seleccione colores");
        //Establecer una lista de elementos, donde se seleccionen múltiples opciones
        builderDialog.setMultiChoiceItems(construirArrayOpciones(), construirArrayBoolean(), new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            }
        });
        //Botón positivo
        builderDialog.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Términos aceptados", Toast.LENGTH_SHORT).show();
            }
        });
        //Botón negativo
        builderDialog.setNegativeButton("NOPE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Términos denegados", Toast.LENGTH_SHORT).show();
            }
        });
        //Personalizar diálogo
        builderDialog.setBackground(getResources().getDrawable(R.drawable.dialog_design, null));
        //Mostrar el diálogo
        builderDialog.show();
    }

    //Presenta las opciones disponibles
    private String[] construirArrayOpciones(){
        String[] opciones = new String[4];
        opciones[0] = "Rojo";
        opciones[1] = "Amarillo";
        opciones[2] = "Azul";
        opciones[3] = "Verde";
        return opciones;
    }

    //Indica si están seleccionados o no las opciones
    private boolean[] construirArrayBoolean(){
        boolean[] codicion = new boolean[4];
        codicion[0] = false;
        codicion[1] = false;
        codicion[2] = false;
        codicion[3] = false;
        return codicion;
    }

    private void crearSnackbar(View view){
        //Declarar el objeto snackbar
        Snackbar snackbar = Snackbar.make(view, "Cambiar color al pulsar OKAY", Snackbar.LENGTH_SHORT);
        //Hacer que aparezca arriba del componente parámetro
        snackbar.setAnchorView(floatingActionButton);
        //Establecer el tiempo que será visible
        snackbar.setDuration(8000);
        //Agregar animación
        snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
        //Determinar un botón con acción
        snackbar.setAction("OKAY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cambiarColorBotonSnackbar();
                    }
                });
        //Mostrar el snackbar
        snackbar.show();
    }

    private void cambiarColorBotonSnackbar(){
        if(controlColorSnackbar){
            buttonSnackbar.setBackgroundColor(Color.parseColor("#ED2E97"));
        }else{
            buttonSnackbar.setBackgroundColor(Color.BLUE);
        }
        controlColorSnackbar = !controlColorSnackbar;
    }
}