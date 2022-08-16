package com.fletes.myappfragmentestaticos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentB extends Fragment {
    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        this.estructuraFragment(v);
        return v;
    }

    private void estructuraFragment(View v){
        Button button;
        TextView textView;
        button = v.findViewById(R.id.btnPresionarFrgB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se puede acceder a un elemento de un fragment diferente
                TextView textView = getActivity().findViewById(R.id.txtMostrarFrgA);
                textView.setText("Lluvia en la Ciudad de Guatemala");
            }
        });
    }
}