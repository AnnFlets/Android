package com.fletes.myapprecyclerclickfragmenttraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdapterRecycler adapterRecycler = new AdapterRecycler(this.setItem());
        clickRecycler(adapterRecycler);
        recyclerView.setAdapter(adapterRecycler);

    }

    private void clickRecycler(AdapterRecycler adaptadorRecycler){
        adaptadorRecycler.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View v) {
                trasladarDatosCompletos(position);
            }
        });
    }


    private ArrayList<DatosVO> setItem(){
        ArrayList<DatosVO> item = new ArrayList<>();
        item.add(new DatosVO(R.drawable.ic_telefono, R.string.nombreD1, R.string.precioD1));
        item.add(new DatosVO(R.drawable.ic_laptop, R.string.nombreD2, R.string.precioD2));
        item.add(new DatosVO(R.drawable.ic_audifonos, R.string.nombreD3, R.string.precioD3));
        item.add(new DatosVO(R.drawable.ic_television, R.string.nombreD4, R.string.precioD4));
        return item;
    }
    private ArrayList<DatosVO> datosInformacionAdicional(){
        ArrayList<DatosVO> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVO(R.string.detalleD1,R.string.especificacionesD1));
        datosInfo.add(new DatosVO(R.string.detalleD2,R.string.especificacionesD2));
        datosInfo.add(new DatosVO(R.string.detalleD3,R.string.especificacionesD3));
        datosInfo.add(new DatosVO(R.string.detalleD4,R.string.especificacionesD4));
        return datosInfo;
    }
    private void trasladarDatosCompletos(int position){
        Intent intent = new Intent(getApplicationContext(),MAInformacionAdicional.class);
        intent.putExtra("nombreD", setItem().get(position).getNombre());
        intent.putExtra("imgD", setItem().get(position).getImagen());

        intent.putExtra("detalleD", datosInformacionAdicional().get(position).getDetalle());
        intent.putExtra("especificacionesD", datosInformacionAdicional().get(position).getEspecificaciones());
        startActivity(intent);
    }
}