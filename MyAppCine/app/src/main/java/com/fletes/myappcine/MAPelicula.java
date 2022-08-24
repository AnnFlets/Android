package com.fletes.myappcine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MAPelicula extends AppCompatActivity {

    private ImageButton imageButton;
    private TextView textViewNombre, textViewSinopsis, textViewDirector,
    textViewReparto, textViewPuntuacion, textViewRecaudacion;
    private Button button;
    private TabLayout tabLayout;
    private Fragment fragmentSinopsis, fragmentDirectorReparto, fragmentPuntuacionRecaudacion;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapelicula);
        imageButton = findViewById(R.id.imgBtnImgPelicula);
        textViewNombre = findViewById(R.id.txtNombrePelicula);
        textViewSinopsis = findViewById(R.id.txtSinopsis);
        textViewDirector = findViewById(R.id.txtDirector);
        textViewReparto = findViewById(R.id.txtReparto);
        textViewPuntuacion = findViewById(R.id.txtPuntuacion);
        textViewRecaudacion = findViewById(R.id.txtRecaudacion);
        button = findViewById(R.id.btnComprarEntradas);
        tabLayout = findViewById(R.id.tlPelicula);
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
        tabLayout.addTab(tabLayout.newTab().setText("Director y Actores"));
        tabLayout.addTab(tabLayout.newTab().setText("Puntuación y Recaudación"));
        fragmentSinopsis = new FragmentSinopsis();
        fragmentDirectorReparto = new FragmentDirectorReparto();
        fragmentPuntuacionRecaudacion = new FragmentPuntuacionRecaudacion();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentSinopsis).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentDirectorReparto).hide(fragmentDirectorReparto).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor, fragmentPuntuacionRecaudacion).hide(fragmentPuntuacionRecaudacion).commit();
        this.obtenerInformacion();
        this.obtenerInformacionFragments();
        this.navegacionTabLayout();
        this.click();
    }

    private void click() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verPosterCompleto();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprarEntradas();
            }
        });
    }

    private void verPosterCompleto(){
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("imgPeli");
        Intent intent = new Intent(this, MAPosterPelicula.class);
        intent.putExtra("img", img);
        this.startActivity(intent);
    }

    private void comprarEntradas(){
        Intent intent = new Intent(this, MACompraEntradas.class);
        this.startActivity(intent);
    }

    private void navegacionTabLayout() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        if (fragmentSinopsis.isAdded()) {
                            transaction.hide(fragmentDirectorReparto).hide(fragmentPuntuacionRecaudacion).show(fragmentSinopsis);
                        }
                        else{
                            transaction.hide(fragmentDirectorReparto).hide(fragmentPuntuacionRecaudacion).add(R.id.flContenedor, fragmentSinopsis).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if (fragmentDirectorReparto.isAdded()) {
                            transaction.hide(fragmentSinopsis).hide(fragmentPuntuacionRecaudacion).show(fragmentDirectorReparto);
                        }
                        else{
                            transaction.hide(fragmentSinopsis).hide(fragmentPuntuacionRecaudacion).add(R.id.flContenedor, fragmentDirectorReparto).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if (fragmentPuntuacionRecaudacion.isAdded()) {
                            transaction.hide(fragmentDirectorReparto).hide(fragmentSinopsis).show(fragmentPuntuacionRecaudacion);
                        }
                        else{
                            transaction.hide(fragmentDirectorReparto).hide(fragmentSinopsis).add(R.id.flContenedor, fragmentPuntuacionRecaudacion).addToBackStack(null);
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

    private void obtenerInformacion() {
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("imgPeli");
        int nombre = bundle.getInt("nombrePeli");
        imageButton.setImageResource(img);
        textViewNombre.setText(nombre);
    }

    private void obtenerInformacionFragments(){
        Bundle bundle = getIntent().getExtras();
        int sinopsis = bundle.getInt("sinopsisPeli");
        int director = bundle.getInt("directorPeli");
        int reparto = bundle.getInt("repartoPeli");
        int puntuacion = bundle.getInt("puntuacionPeli");
        int recaudacion = bundle.getInt("recaudacionPeli");
        this.enviarInfoFragmentSinopsis(sinopsis);
        this.enviarInfoFragmentDirectorReparto(director, reparto);
        this.enviarInfoFragmentPuntuacionRecaudacion(puntuacion, recaudacion);
    }

    private void enviarInfoFragmentSinopsis(int sinopsis){
        Bundle bundle = new Bundle();
        bundle.putInt("sinopsis", sinopsis);
        fragmentSinopsis.setArguments(bundle);
    }
    private void enviarInfoFragmentDirectorReparto(int director, int reparto) {
        Bundle bundle = new Bundle();
        bundle.putInt("director", director);
        bundle.putInt("reparto", reparto);
        fragmentDirectorReparto.setArguments(bundle);
    }

    private void enviarInfoFragmentPuntuacionRecaudacion(int puntuacion, int recaudacion) {
        Bundle bundle = new Bundle();
        bundle.putInt("puntuacion", puntuacion);
        bundle.putInt("recaudacion", recaudacion);
        fragmentPuntuacionRecaudacion.setArguments(bundle);
    }
}