package com.fletes.myappcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDirectorReparto extends Fragment {
    private int director;
    private int reparto;

    public FragmentDirectorReparto() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            director = getArguments().getInt("director");
            reparto = getArguments().getInt("reparto");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_director_reparto, container, false);
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View view) {
        TextView textViewDirector = view.findViewById(R.id.txtDirector);
        TextView textViewReparto = view.findViewById(R.id.txtReparto);
        textViewDirector.setText(director);
        textViewReparto.setText(reparto);
    }
}