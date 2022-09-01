package com.fletes.myappmaterialdesigndos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private FloatingActionButton fabAdd;
    private LinearLayout layoutSheet;
    private BottomSheetBehavior bottomSheetBehavior;
    private Button buttonDatePicker;
    private TextView textViewDate;
    private LottieAnimationView like;
    boolean likeA = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        like = findViewById(R.id.animationLike);
        bottomAppBar = findViewById(R.id.btnAppBar);
        fabAdd = findViewById(R.id.fabAdd);
        layoutSheet = findViewById(R.id.layoutBtnSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(layoutSheet);
        setSupportActionBar(bottomAppBar);
        textViewDate = findViewById(R.id.txtDate);
        buttonDatePicker = findViewById(R.id.btnDatePicker);
        //Creamos nuestro Date Picker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        MaterialDatePicker materialDatePicker = builder.build();
        builder.setTitleText("SELECT A DATE");
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE PICKER");
            }
        });
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                textViewDate.setText("Selected Date: " + materialDatePicker.getHeaderText());
            }
        });
        this.click();
    }

    private boolean likeAnimation(LottieAnimationView like, int animation, boolean likeA){
        if(!likeA){
            like.setAnimation(animation);
            like.playAnimation();
        }else{
            like.setImageResource(R.drawable.ic_corazon);
        }
        return !likeA;
    }

    private void click() {
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeA = likeAnimation(like, R.raw.like, likeA);
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(bottomSheetBehavior.STATE_EXPANDED);
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
        });
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "AAAA", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bottom_app_bar_menu, menu);
        return true;
    }
}