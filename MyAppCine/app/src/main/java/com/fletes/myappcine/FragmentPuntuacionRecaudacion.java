package com.fletes.myappcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPuntuacionRecaudacion extends Fragment {
    private int puntuacion;
    private int recaudacion;

    public FragmentPuntuacionRecaudacion() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            puntuacion = getArguments().getInt("puntuacion");
            recaudacion = getArguments().getInt("recaudacion");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_puntuacion_recaudacion, container, false);
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View view) {
        TextView textViewPuntuacion = view.findViewById(R.id.txtPuntuacion);
        TextView textViewRecaudacion = view.findViewById(R.id.txtRecaudacion);
        textViewPuntuacion.setText(puntuacion);
        textViewRecaudacion.setText(recaudacion);
    }
}