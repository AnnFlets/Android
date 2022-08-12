package com.fletes.myapprecyclerviewvo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<DatosVO> datosVO = new ArrayList<>();

    public AdapterRecyclerView(ArrayList<DatosVO> datosVO) {
        this.datosVO = datosVO;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVO.get(position).getNombreRestaurante(), datosVO.get(position).getCalidadRestaurante(),
                datosVO.get(position).getImagenRestaurante());
    }

    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNombre, textViewCalidad;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycler);
            textViewCalidad = itemView.findViewById(R.id.txtCalidadRecycler);
            imageView = itemView.findViewById(R.id.imgRecycler);
        }
        private void asignarDatos(String nombre, String calidad, Integer imagen){
            textViewNombre.setText(String.valueOf(nombre));
            textViewCalidad.setText(String.valueOf(calidad));
            imageView.setImageResource(imagen);
        }
    }
}
