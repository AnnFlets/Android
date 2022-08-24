package com.fletes.myappcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentSinopsis extends Fragment {
    private int sinopsis;

    public FragmentSinopsis() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sinopsis = getArguments().getInt("sinopsis");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sinopsis, container, false);
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View v){
        TextView textView = v.findViewById(R.id.txtSinopsis);
        textView.setText(sinopsis);
    }
}