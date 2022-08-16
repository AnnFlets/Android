package com.fletes.myappfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentTres extends Fragment {
    public FragmentTres() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tres, container, false);
        this.estructuraFragmentTres(v);
        return v;
    }

    private void estructuraFragmentTres(View v) {
        Button button;
        button = v.findViewById(R.id.btnFrgTres);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Te encuentras en el Fragment no. 3", Toast.LENGTH_SHORT).show();
            }
        });
    }
}