package com.fletes.myapprecyclerclickfragmenttraslado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {
    //Paso 2
//paso 2
    private static ClickListener clickListener;

    private ArrayList<DatosVO> datosVO = new ArrayList<>();

    public AdapterRecycler(ArrayList<DatosVO> datosVO) {
        this.datosVO = datosVO;
    }

    @NonNull
    @Override
    public AdapterRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.ViewHolder holder, int position) {
        holder.setData(datosVO.get(position).getImagen(),
                datosVO.get(position).getNombre(),
                datosVO.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    //Paso 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textViewNombre, textViewPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgRecycler);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycler);
            textViewPrecio = itemView.findViewById(R.id.txtPrecioRecycler);
            //Paso 6
            itemView.setOnClickListener(this);

        }

        private void setData(Integer img, Integer nombre, Integer precio) {
            imageView.setImageResource(img);
            textViewNombre.setText(nombre);
            textViewPrecio.setText(precio);
        }

        //Paso 4
        @Override
        public void onClick(View view) {
            //Paso 7
            clickListener.itemClick(getAdapterPosition(), view);
        }
    }
    //Paso 5
    public void setItemClickListener(ClickListener clickListener){
        AdapterRecycler.clickListener = clickListener;
    }
}