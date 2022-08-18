package com.fletes.myappfragmentdinamico2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private Fragment fragment1, fragment2, fragment3;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tlId);
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 3"));
        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment2).hide(fragment2).hide(fragment3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment3).hide(fragment1).hide(fragment2).commit();
        accionTabLayout();
    }

    private void accionTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if(fragment1.isAdded()){
                            transaction.hide(fragment2).hide(fragment3).show(fragment1);
                        }else{
                            transaction.hide(fragment2).hide(fragment3).add(R.id.frlContenedor, fragment1).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.hide(fragment1).hide(fragment3).show(fragment2);
                        }else{
                            transaction.hide(fragment1).hide(fragment3).add(R.id.frlContenedor, fragment2).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if(fragment3.isAdded()){
                            transaction.hide(fragment1).hide(fragment2).show(fragment3);
                        }else{
                            transaction.hide(fragment1).hide(fragment2).add(R.id.frlContenedor, fragment3).addToBackStack(null);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}