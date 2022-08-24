package com.fletes.myappcine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {
    private static ClickListener clickListener;
    private ArrayList<PeliculaVO> peliculaCartelera = new ArrayList<>();

    public AdapterRecycler(ArrayList<PeliculaVO> peliculaCartelera) {
        this.peliculaCartelera = peliculaCartelera;
    }

    @Override
    public AdapterRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.ViewHolder holder, int position) {
        holder.establecerCartelera(peliculaCartelera.get(position).getImgPeli(),
                peliculaCartelera.get(position).getNombrePeli(),
                peliculaCartelera.get(position).getDuracionPeli());
    }

    @Override
    public int getItemCount() {
        return this.peliculaCartelera.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView textViewNombre, textViewDuracion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgCartelera);
            textViewNombre = itemView.findViewById(R.id.txtNombreCartelera);
            textViewDuracion = itemView.findViewById(R.id.txtDuracionCartelera);
            itemView.setOnClickListener(this);
        }
        private void establecerCartelera(Integer img, Integer nombre, Integer duracion) {
            imageView.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewDuracion.setText(duracion);
        }

        @Override
        public void onClick(View v) {
            clickListener.itemClick(getAdapterPosition(), v);
        }
    }
    public void setItemClickListener(ClickListener clickListener){
        AdapterRecycler.clickListener = clickListener;
    }
}