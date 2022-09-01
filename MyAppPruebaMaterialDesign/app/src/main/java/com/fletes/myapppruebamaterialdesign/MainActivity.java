package com.fletes.myapppruebamaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView imagenLike;
    boolean like = false;
    private ImageView imageViewEjeX, imageViewEjeY, imageViewAlpha, imageViewRotation,
    imageViewTodo, imageViewBucle, imageViewScale;
    private Button buttonEjeX, buttonEjeY, buttonAlpha, buttonRotation,
    buttonTodo, buttonBucle, buttonScale;

    //Proporciona el soporte para animar los objetos
    private ObjectAnimator animatorX, animatorY, animatorAlpha, animatorRotation,
    animatorAll;

    private long animationDuration = 1000;
    //Reproduce un conjunto de ObjectAnimator en un orden específico, las cuales pueden ser todas a la vez
    private AnimatorSet animatorSet;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagenLike = findViewById(R.id.animationLike);
        imageViewEjeX = findViewById(R.id.ivEjeX);
        imageViewEjeY = findViewById(R.id.ivEjeY);
        imageViewAlpha = findViewById(R.id.ivAlpha);
        imageViewRotation = findViewById(R.id.ivRotation);
        imageViewTodo = findViewById(R.id.ivTodo);
        imageViewBucle = findViewById(R.id.ivBucle);
        imageViewScale = findViewById(R.id.ivScale);
        buttonEjeX = findViewById(R.id.btEjeX);
        buttonEjeY = findViewById(R.id.btEjeY);
        buttonAlpha = findViewById(R.id.btAlpha);
        buttonRotation = findViewById(R.id.btRotation);
        buttonTodo = findViewById(R.id.btTodo);
        buttonBucle = findViewById(R.id.btBucle);
        buttonScale = findViewById(R.id.btScale);
        this.click();
    }

    private void animacion(String animacion){
        switch (animacion){
            case "ejeX":
                //Desplazamiento en eje x
                animatorX = ObjectAnimator.ofFloat(imageViewEjeX, "x", 500f);
                //Tiempo que dure la animación
                animatorX.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetX = new AnimatorSet();
                //Qué animación queremos que ejecute
                animatorSetX.play(animatorX);
                //Comenzamos la animación
                animatorSetX.start();
                break;
            case "ejeY":
                //Desplazamiento en eje y
                animatorY = ObjectAnimator.ofFloat(imageViewEjeY, "y", 500f);
                //Tiempo que dure la animación
                animatorY.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetY = new AnimatorSet();
                //Qué animación queremos que ejecute
                animatorSetY.play(animatorY);
                //Comenzamos la animación
                animatorSetY.start();
                break;
            case "alpha":
                //Volverlo opaco
                animatorAlpha = ObjectAnimator.ofFloat(imageViewAlpha, View.ALPHA, 1.0f, 0.0f);
                //Tiempo que dure la animación
                animatorAlpha.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                //Qué animación queremos que ejecute
                animatorSetAlpha.play(animatorAlpha);
                //Comenzamos la animación
                animatorSetAlpha.start();
                break;
            case "rotation":
                //Girar empezando desde el primer valor hasta el segundo valor (grados)
                animatorRotation = ObjectAnimator.ofFloat(imageViewRotation, "rotation", 0f, 360f);
                //Tiempo que dure la animación
                animatorRotation.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetRotation = new AnimatorSet();
                //Qué animación queremos que ejecute
                animatorSetRotation.play(animatorRotation);
                //Comenzamos la animación
                animatorSetRotation.start();
                break;
            case "todo":
                animatorAlpha = ObjectAnimator.ofFloat(imageViewTodo, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                animatorRotation = ObjectAnimator.ofFloat(imageViewTodo, "rotation", 0f, 360f);
                animatorRotation.setDuration(animationDuration);
                animatorX = ObjectAnimator.ofFloat(imageViewTodo, "x", 500f);
                animatorX.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetTodo = new AnimatorSet();
                //Qué animaciones queremos que ejecute
                animatorSetTodo.playTogether(animatorAlpha, animatorX, animatorRotation);
                //Comenzamos la animación
                animatorSetTodo.start();
                break;
            case "bucle":
                animatorX = ObjectAnimator.ofFloat(imageViewBucle, "x", 500f);
                //Tiempo que dure la animación
                animatorX.setDuration(animationDuration);
                //Reproducen las animaciones
                AnimatorSet animatorSetBucle = new AnimatorSet();
                //Qué animación queremos que ejecute
                animatorSetBucle.play(animatorX);
                //Comenzamos la animación
                animatorSetBucle.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animation.start();
                    }
                });
                animatorSetBucle.start();
                break;
            case "scale":
                Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
                imageViewScale.startAnimation(animationScale);
                break;
        }
    }


    private boolean likeAnimation(LottieAnimationView imagenLike, int animation, boolean like){
        Toast.makeText(this, "Diste like", Toast.LENGTH_SHORT).show();
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
        imagenLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeAnimation(imagenLike, R.raw.animation_like, like);
            }
        });
        buttonEjeX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("ejeX");
            }
        });
        buttonEjeY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("ejeY");
            }
        });
        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("alpha");
            }
        });
        buttonRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("rotation");
            }
        });
        buttonTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("todo");
            }
        });
        buttonBucle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("bucle");
            }
        });
        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("scale");
            }
        });
    }
}