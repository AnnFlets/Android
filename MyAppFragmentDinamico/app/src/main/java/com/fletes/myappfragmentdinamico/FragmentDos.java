package com.fletes.myappfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentDos extends Fragment {
    public FragmentDos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dos, container, false);
        this.estructuraFragmentDos(v);
        return v;
    }

    private void estructuraFragmentDos(View v) {
        Button button;
        button = v.findViewById(R.id.btnFrgDos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Te enecuentras en el Fragment no. 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}