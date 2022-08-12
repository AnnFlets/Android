package com.fletes.myappcontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private ArrayList<ContactoVO> contactoVO = new ArrayList<>();

    public AdapterRecyclerView(ArrayList<ContactoVO> contactoVO) {
        this.contactoVO = contactoVO;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_element, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {
        holder.asignarInfo(contactoVO.get(position).getImagenContacto(), contactoVO.get(position).getNombreContacto(),
                contactoVO.get(position).getNumeroContacto());
    }

    @Override
    public int getItemCount() {
        return this.contactoVO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textViewNombre, textViewNumero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgContacto);
            textViewNombre = itemView.findViewById(R.id.txtNombreContacto);
            textViewNumero = itemView.findViewById(R.id.txtNumeroContacto);
        }
        private void asignarInfo(Integer img, String nombre, String numero){
            imageView.setImageResource(img);
            textViewNombre.setText(String.valueOf(nombre));
            textViewNumero.setText(String.valueOf(numero));
        }
    }
}