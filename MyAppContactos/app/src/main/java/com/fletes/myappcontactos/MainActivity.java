package com.fletes.myappcontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(this.datosContacto());
        recyclerView.setAdapter(adapterRecyclerView);
    }


    private ArrayList<ContactoVO> datosContacto(){
        ArrayList<ContactoVO> datosC = new ArrayList<>();
        datosC.add(new ContactoVO(R.drawable.ic_usera, "Miguel", "30908514"));
        datosC.add(new ContactoVO(R.drawable.ic_userb, "Alexander", "15236285"));
        datosC.add(new ContactoVO(R.drawable.ic_userc, "Camila", "74965236"));
        datosC.add(new ContactoVO(R.drawable.ic_userd, "Eliza", "68412539"));
        datosC.add(new ContactoVO(R.drawable.ic_usere, "Benjamín", "52523262"));
        datosC.add(new ContactoVO(R.drawable.ic_userf, "Amelia", "36452585"));
        datosC.add(new ContactoVO(R.drawable.ic_userg, "Pedro", "45494685"));
        datosC.add(new ContactoVO(R.drawable.ic_userh, "Rocío", "25269587"));
        datosC.add(new ContactoVO(R.drawable.ic_useri, "Cassandra", "56415859"));
        datosC.add(new ContactoVO(R.drawable.ic_userj, "Ramón", "23654857"));
        return datosC;
    }
}