package com.fletes.myappcine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {
    private Context context;
    int refGrid;
    ArrayList<Integer> asiento = new ArrayList<>();

    public AdapterGrid(Context context, int refGrid, ArrayList<Integer> asiento) {
        this.context = context;
        this.refGrid = refGrid;
        this.asiento = asiento;
    }

    @Override
    public int getCount() {
        return this.asiento.size();
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
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.grid_asientos, null);
        int imgAsiento = asiento.get(position);
        ImageView imageView = view.findViewById(R.id.imgAsiento);
        imageView.setImageResource(imgAsiento);
        return view;
    }
}
