package com.fletes.myapprecyclerimg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<Integer> img = new ArrayList<>();
    private ArrayList<String> nombre = new ArrayList<>();

    public AdapterRecyclerView(ArrayList<Integer> img, ArrayList<String> nombre) {
        this.img = img;
        this.nombre = nombre;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_element, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.asignarDatos(img.get(position), nombre.get(position));
    }

    @Override
    public int getItemCount() {
        return this.nombre.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imgAnimal);
            textView = itemView.findViewById(R.id.txtAnimal);
        }
        public void asignarDatos(int img, String nombre){
            imageView.setImageResource(img);
            textView.setText(String.valueOf(nombre));
        }
    }
}