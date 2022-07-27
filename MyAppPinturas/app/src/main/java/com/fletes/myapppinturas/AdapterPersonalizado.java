package com.fletes.myapppinturas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizado extends BaseAdapter {

    private Context context;
    private int refList;
    ArrayList<Integer> imgCategoria = new ArrayList<>();
    ArrayList<String> nombreCategoria = new ArrayList<>();

    public AdapterPersonalizado(Context context, int refList,
                                ArrayList<Integer> imgCategoria,
                                ArrayList<String> nombreCategoria) {
        this.context = context;
        this.refList = refList;
        this.imgCategoria = imgCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public int getCount() {
        return this.nombreCategoria.size();
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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.lista_personalizada, null);
        int imgCat = this.imgCategoria.get(position);
        String nomCat = this.nombreCategoria.get(position);
        ImageView imageViewCat = v.findViewById(R.id.imgCategoria);
        TextView textViewNomCat = v.findViewById(R.id.txtCategoria);
        imageViewCat.setImageResource(imgCat);
        textViewNomCat.setText(String.valueOf(nomCat));
        return v;
    }
}
