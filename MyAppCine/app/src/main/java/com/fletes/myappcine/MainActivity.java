package com.fletes.myappcine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ImageView imageViewCarrusel;
    private Button buttonAtras, buttonAdelante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewCarrusel = findViewById(R.id.imgCarrusel);
        imageViewCarrusel.setImageResource(R.drawable.ic_blancanieves_cazador);
        imageViewCarrusel.setTag("blancaNieves");
        buttonAtras = findViewById(R.id.btnRegresarCarrusel);
        buttonAdelante = findViewById(R.id.btnAdelantarCarrusel);
        toolbar = findViewById(R.id.toolbarCartelera);
        toolbar.setTitle("Cartelera");
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.rvCartelera);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterRecycler adapterRecycler = new AdapterRecycler(this.peliculasCartelera());
        clickRecycler(adapterRecycler);
        recyclerView.setAdapter(adapterRecycler);
        this.click();

    }

    private void clickRecycler(AdapterRecycler adapterRecycler) {
        adapterRecycler.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View view) {
                trasladarInformacion(position);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemList:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                Toast.makeText(this, "Estilo lista", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemGrid:
                if(obtenerOrientacion(getApplicationContext()).equals("horizontal")){
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                    Toast.makeText(this, "Estilo cuadrícula", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Disponible en orientación horizontal", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void click() {
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atrasCarrusel();
            }
        });
        buttonAdelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adelanteCarrusel();
            }
        });
    }

    private ArrayList<PeliculaVO> peliculasCartelera(){
        ArrayList<PeliculaVO> peliCartelera = new ArrayList<>();
        peliCartelera.add(new PeliculaVO(R.drawable.ic_harry_caliz_fuego, R.string.nombrePeli1, R.string.duracionPeli1));
        peliCartelera.add(new PeliculaVO(R.drawable.ic_warcraft_el_origen, R.string.nombrePeli2, R.string.duracionPeli2));
        peliCartelera.add(new PeliculaVO(R.drawable.ic_violet_evergarden, R.string.nombrePeli3, R.string.duracionPeli3));
        peliCartelera.add(new PeliculaVO(R.drawable.ic_juego_hambre_llamas, R.string.nombrePeli4, R.string.duracionPeli4));
        peliCartelera.add(new PeliculaVO(R.drawable.ic_telefono_negro, R.string.nombrePeli5, R.string.duracionPeli5));
        peliCartelera.add(new PeliculaVO(R.drawable.ic_harry_reliquias_dos, R.string.nombrePeli6, R.string.duracionPeli6));
        return peliCartelera;
    }

    private ArrayList<PeliculaVO> peliculaElegida(){
        ArrayList<PeliculaVO> peliElegida = new ArrayList<>();
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli1, R.string.directorPeli1, R.string.repartoPeli1,
                R.string.puntuacionPeli1, R.string.recaudacionPeli1));
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli2, R.string.directorPeli2, R.string.repartoPeli2,
                R.string.puntuacionPeli2, R.string.recaudacionPeli2));
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli3, R.string.directorPeli3, R.string.repartoPeli3,
                R.string.puntuacionPeli3, R.string.recaudacionPeli3));
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli4, R.string.directorPeli4, R.string.repartoPeli4,
                R.string.puntuacionPeli4, R.string.recaudacionPeli4));
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli5, R.string.directorPeli5, R.string.repartoPeli5,
                R.string.puntuacionPeli5, R.string.recaudacionPeli5));
        peliElegida.add(new PeliculaVO(R.string.sinopsisPeli6, R.string.directorPeli6, R.string.repartoPeli6,
                R.string.puntuacionPeli6, R.string.recaudacionPeli6));
        return peliElegida;
    }

    private void trasladarInformacion(int position){
        Intent intent = new Intent(getApplicationContext(), MAPelicula.class);
        intent.putExtra("imgPeli", peliculasCartelera().get(position).getImgPeli());
        intent.putExtra("nombrePeli", peliculasCartelera().get(position).getNombrePeli());
        intent.putExtra("sinopsisPeli", peliculaElegida().get(position).getSinopsisPeli());
        intent.putExtra("directorPeli", peliculaElegida().get(position).getDirectorPeli());
        intent.putExtra("repartoPeli", peliculaElegida().get(position).getRepartoPeli());
        intent.putExtra("puntuacionPeli", peliculaElegida().get(position).getPuntuacionPeli());
        intent.putExtra("recaudacionPeli", peliculaElegida().get(position).getRecaudacionPeli());
        startActivity(intent);
    }

    private void adelanteCarrusel(){
        Integer[] peliculaCarrusel = new Integer[4];
        peliculaCarrusel[0] = R.drawable.ic_blancanieves_cazador;
        peliculaCarrusel[1] = R.drawable.ic_senior_anillos;
        peliculaCarrusel[2] = R.drawable.ic_harry_orden_fenix;
        peliculaCarrusel[3] = R.drawable.ic_your_name;
        if(imageViewCarrusel.getTag().equals("blancaNieves")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[1]);
            imageViewCarrusel.setTag("seniorAnillos");
        }else if(imageViewCarrusel.getTag().equals("seniorAnillos")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[2]);
            imageViewCarrusel.setTag("harryOrdenFenix");
        }else if(imageViewCarrusel.getTag().equals("harryOrdenFenix")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[3]);
            imageViewCarrusel.setTag("yourName");
        }else if(imageViewCarrusel.getTag().equals("yourName")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[0]);
            imageViewCarrusel.setTag("blancaNieves");
        }
    }

    private void atrasCarrusel(){
        Integer[] peliculaCarrusel = new Integer[4];
        peliculaCarrusel[0] = R.drawable.ic_blancanieves_cazador;
        peliculaCarrusel[1] = R.drawable.ic_senior_anillos;
        peliculaCarrusel[2] = R.drawable.ic_harry_orden_fenix;
        peliculaCarrusel[3] = R.drawable.ic_your_name;
        if(imageViewCarrusel.getTag().equals("yourName")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[2]);
            imageViewCarrusel.setTag("harryOrdenFenix");
        }else if(imageViewCarrusel.getTag().equals("harryOrdenFenix")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[1]);
            imageViewCarrusel.setTag("seniorAnillos");
        }else if(imageViewCarrusel.getTag().equals("seniorAnillos")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[0]);
            imageViewCarrusel.setTag("blancaNieves");
        }else if(imageViewCarrusel.getTag().equals("blancaNieves")){
            imageViewCarrusel.setImageResource(peliculaCarrusel[3]);
            imageViewCarrusel.setTag("yourName");
        }
    }


    public String obtenerOrientacion(Context context){
        int orientacion = getWindowManager().getDefaultDisplay().getRotation();
        if(orientacion == Surface.ROTATION_0 || orientacion == Surface.ROTATION_180){
            return "vertical";
        }else{
            return "horizontal";
        }
    }
}