package com.fletes.myapprecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Realizar el extends y solventar los errores
public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder>{
    //Declaramos la colección que nos permitirá recibir datos
    private ArrayList<String> articulos = new ArrayList<>();
    //Creamos el constructor para poder realizar la implementación del objeto
    public AdaptadorRecyclerView(ArrayList<String> articulos) {
        this.articulos = articulos;
    }

    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Realizamos el inflate para poder tener la relación
        //entre la parte del diseño con la parte lógica
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorRecyclerView.ViewHolder holder, int position) {
        //Obtenemos el valor que viene y se lo asignamos
        //al método respectivo para que lo setee al elemento
        //view
        holder.asignarDatos(articulos.get(position));
    }

    @Override
    public int getItemCount() {
        //Definimos el tamaño que tendrá nuestro recyclerview
        return this.articulos.size();
    }

    //Para esta clase nos podemos hacer la idea de que trabaja
    //muy similar a MainActivity
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtTextoRecycler);
        }

        //Método para poder asignar los valores provenientes
        //del arraylist a nuestros elementos views
        public void asignarDatos(String texto1){
            textView.setText(String.valueOf(texto1));
        }
    }
}
