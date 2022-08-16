package com.fletes.myappfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentUno extends Fragment {
    public FragmentUno() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_uno, container, false);
        this.estructuraFragmentUno(v);
        return v;
    }

    private void estructuraFragmentUno(View v) {
        Button button;
        button = v.findViewById(R.id.btnFrgUno);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Te encuentras en el Fragment no. 1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}