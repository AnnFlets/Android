package com.fletes.myappsqlite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentDetalle extends Fragment {
    private String codigo, nombre, sabor, presentacion, tipo, precio;

    public FragmentDetalle() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            codigo = getArguments().getString("codigo");
            nombre = getArguments().getString("nombre");
            sabor = getArguments().getString("sabor");
            presentacion = getArguments().getString("presentacion");
            tipo = getArguments().getString("tipo");
            precio = getArguments().getString("precio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);
        llenarFragmento(v);
        return v;
    }

    private void llenarFragmento(View v){
        TextView textViewCodigo, textViewNombre, textViewSabor, textViewPresentacion, textViewTipo, textViewPrecio;
        textViewCodigo = v.findViewById(R.id.txtCodigoFragment);
        textViewNombre = v.findViewById(R.id.txtNombreFragment);
        textViewSabor = v.findViewById(R.id.txtSaborFragment);
        textViewPresentacion = v.findViewById(R.id.txtPresentacionFragment);
        textViewTipo = v.findViewById(R.id.txtTipoFragment);
        textViewPrecio = v.findViewById(R.id.txtPrecioFragment);
        textViewCodigo.setText(String.valueOf(codigo));
        textViewNombre.setText(String.valueOf(nombre));
        textViewSabor.setText("Sabor: " + sabor);
        textViewPresentacion.setText("Presentación: " + presentacion + " mL");
        textViewTipo.setText("Tipo: " + tipo);
        textViewPrecio.setText("Precio: Q." + precio);

    }
}