package com.fletes.myappgridcolores;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {

    private Context context;
    int refGrid;
    ArrayList<String> colorFondo = new ArrayList<>();
    ArrayList<String> nombreColor = new ArrayList<>();

    public AdapterGrid(Context context, int refGrid, ArrayList<String> colorFondo, ArrayList<String> nombreColor) {
        this.context = context;
        this.refGrid = refGrid;
        this.colorFondo = colorFondo;
        this.nombreColor = nombreColor;
    }

    @Override
    public int getCount() {
        return this.colorFondo.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado, null);
        String fondo = colorFondo.get(position);
        String nombre = nombreColor.get(position);
        TextView textViewBackground = v.findViewById(R.id.txtFondo);
        TextView textViewNombre = v.findViewById(R.id.txtNombreColor);
        textViewBackground.setBackgroundColor(Color.parseColor(fondo.toString()));
        textViewNombre.setText(String.valueOf(nombre));
        return v;
    }
}