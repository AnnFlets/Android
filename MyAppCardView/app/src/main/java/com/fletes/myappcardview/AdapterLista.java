package com.fletes.myappcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {
    private Context context;
    private int referenciaLista;
    ArrayList<String> saludo = new ArrayList<>();

    public AdapterLista(Context context, int referenciaLista, ArrayList<String> saludo) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.saludo = saludo;
    }

    @Override
    public int getCount() {
        return this.saludo.size();
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
        v = layoutInflater.inflate(R.layout.list_card_view, null);
        String texto = saludo.get(position);
        TextView textView = v.findViewById(R.id.txtSaludo);
        textView.setText(String.valueOf(texto));
        return v;
    }
}
