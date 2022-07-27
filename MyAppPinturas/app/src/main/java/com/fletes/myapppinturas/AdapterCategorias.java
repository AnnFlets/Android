package com.fletes.myapppinturas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategorias extends BaseAdapter {

    private Context context;
    private int refList;
    ArrayList<Integer> imgPintura = new ArrayList<>();
    ArrayList<String> nombrePintura = new ArrayList<>();
    ArrayList<Integer> precioPintura = new ArrayList<>();
    ArrayList<String> descripcionPintura = new ArrayList<>();

    public AdapterCategorias(Context context, int refList, ArrayList<Integer> imgPintura, ArrayList<String> nombrePintura, ArrayList<Integer> precioPintura, ArrayList<String> descripcionPintura) {
        this.context = context;
        this.refList = refList;
        this.imgPintura = imgPintura;
        this.nombrePintura = nombrePintura;
        this.precioPintura = precioPintura;
        this.descripcionPintura = descripcionPintura;
    }

    @Override
    public int getCount() {
        return this.nombrePintura.size();
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
        v = layoutInflater.inflate(R.layout.lista_obras, null);
        int imgObra = this.imgPintura.get(position);
        String nomObra = this.nombrePintura.get(position);
        int preObra = this.precioPintura.get(position);
        String desObra = this.descripcionPintura.get(position);
        ImageView imageViewPintura = v.findViewById(R.id.imgPintura);
        TextView textViewNomPintura = v.findViewById(R.id.txtNombrePintura);
        TextView textViewPrePintura = v.findViewById(R.id.txtPrecioPintura);
        TextView textViewDesPintura = v.findViewById(R.id.txtDescripcionPintura);
        Button buttonAdquirir = v.findViewById(R.id.btnAdquirir);
        imageViewPintura.setImageResource(imgObra);
        textViewNomPintura.setText(String.valueOf(nomObra));
        textViewPrePintura.setText(String.valueOf(preObra));
        textViewDesPintura.setText(String.valueOf(desObra));
        buttonAdquirir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladarInfo(imgObra, nomObra, preObra);
            }
        });
        return v;
    }

    private void trasladarInfo(int imgObra, String nomObra, int preObra){
        Intent intent = new Intent(context, MAPintura.class);
        intent.putExtra("img", imgObra);
        intent.putExtra("nom", nomObra);
        intent.putExtra("pre", preObra);
        context.startActivity(intent);
    }
}
