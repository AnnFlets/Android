package com.fletes.myapppinturas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MACategoriaPinturas extends AppCompatActivity {

    private ListView listView;
    private TextView textViewNomCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macategoria_pinturas);
        listView = findViewById(R.id.listPinturas);
        textViewNomCat = findViewById(R.id.txtNombreCategoria);
        AdapterCategorias adapterCategorias = new AdapterCategorias(this, R.layout.lista_obras, img(),
                nombre(), precio(), descripcion());
        listView.setAdapter(adapterCategorias);
    }

    private ArrayList<Integer> img(){
        ArrayList<Integer> img = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String nomCat = bundle.getString("nomCat");
        textViewNomCat.setText(String.valueOf(nomCat));
        if(nomCat.equals("ARTE ABSTRACTO")){
            img = imgAbstracto();
        }else if(nomCat.equals("IMPRESIONISMO")){
            img = imgImpresionismo();
        }else if(nomCat.equals("REALISMO")){
            img = imgRealista();
        }else if(nomCat.equals("SURREALISMO")){
            img = imgSurrealista();
        }else{
            Toast.makeText(this, "Hubo un error en la aplicación", Toast.LENGTH_SHORT).show();
        }
        return img;
    }

    private ArrayList<Integer> imgAbstracto(){
        ArrayList<Integer> imgPintura = new ArrayList<>();
        imgPintura.add(R.drawable.ic_mar);
        imgPintura.add(R.drawable.ic_amarillo);
        imgPintura.add(R.drawable.ic_silueta);
        return imgPintura;
    }
    private ArrayList<Integer> imgImpresionismo(){
        ArrayList<Integer> imgPintura = new ArrayList<>();
        imgPintura.add(R.drawable.ic_boulevard);
        imgPintura.add(R.drawable.ic_jardin);
        imgPintura.add(R.drawable.ic_sombrilla);
        return imgPintura;
    }
    private ArrayList<Integer> imgRealista(){
        ArrayList<Integer> imgPintura = new ArrayList<>();
        imgPintura.add(R.drawable.ic_brisa);
        imgPintura.add(R.drawable.ic_snap);
        imgPintura.add(R.drawable.ic_major);
        return imgPintura;
    }
    private ArrayList<Integer> imgSurrealista(){
        ArrayList<Integer> imgPintura = new ArrayList<>();
        imgPintura.add(R.drawable.ic_persistencia);
        imgPintura.add(R.drawable.ic_carnaval);
        imgPintura.add(R.drawable.ic_hombre);
        return imgPintura;
    }

    private ArrayList<String> nombre(){
        ArrayList<String> nombre = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String nomCat = bundle.getString("nomCat");
        if(nomCat.equals("ARTE ABSTRACTO")){
            nombre = nombrePinturaAbstracta();
        }else if(nomCat.equals("IMPRESIONISMO")){
            nombre = nombrePinturaImpresionismo();
        }else if(nomCat.equals("REALISMO")){
            nombre = nombrePinturaRealismo();
        }else if(nomCat.equals("SURREALISMO")){
            nombre = nombrePinturaSurrealismo();
        }else{
            Toast.makeText(this, "Hubo un error en la aplicación", Toast.LENGTH_SHORT).show();
        }
        return nombre;
    }

    private ArrayList<String> nombrePinturaAbstracta(){
        ArrayList<String> nombrePintura = new ArrayList<>();
        nombrePintura.add("Montañas y mar");
        nombrePintura.add("Amarillo, rojo y azul");
        nombrePintura.add("Silhouette fantastique");
        return nombrePintura;
    }

    private ArrayList<String> nombrePinturaImpresionismo(){
        ArrayList<String> nombrePintura = new ArrayList<>();
        nombrePintura.add("Boulevard Montmartre de noche");
        nombrePintura.add("El jardín del artista en Giverny");
        nombrePintura.add("Mujer con sombrilla");
        return nombrePintura;
    }

    private ArrayList<String> nombrePinturaRealismo(){
        ArrayList<String> nombrePintura = new ArrayList<>();
        nombrePintura.add("A favor de la brisa");
        nombrePintura.add("Snap the Whip");
        nombrePintura.add("Matchmaking of the major");
        return nombrePintura;
    }

    private ArrayList<String> nombrePinturaSurrealismo(){
        ArrayList<String> nombrePintura = new ArrayList<>();
        nombrePintura.add("La persistencia de la memoria");
        nombrePintura.add("El Carnaval de Arlequín");
        nombrePintura.add("El hijo del hombre");
        return nombrePintura;
    }

    private ArrayList<Integer> precio(){
        ArrayList<Integer> precio = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String nomCat = bundle.getString("nomCat");
        if(nomCat.equals("ARTE ABSTRACTO")){
            precio = precioPinturaAbstracta();
        }else if(nomCat.equals("IMPRESIONISMO")){
            precio = precioPinturaImpresionismo();
        }else if(nomCat.equals("REALISMO")){
            precio = precioPinturaRealismo();
        }else if(nomCat.equals("SURREALISMO")){
            precio = precioPinturaSurrealismo();
        }else{
            Toast.makeText(this, "Hubo un error en la aplicación", Toast.LENGTH_SHORT).show();
        }
        return precio;
    }

    private ArrayList<Integer> precioPinturaAbstracta(){
        ArrayList<Integer> precioPintura = new ArrayList<>();
        precioPintura.add(1200);
        precioPintura.add(850);
        precioPintura.add(970);
        return precioPintura;
    }

    private ArrayList<Integer> precioPinturaImpresionismo(){
        ArrayList<Integer> precioPintura = new ArrayList<>();
        precioPintura.add(1550);
        precioPintura.add(1620);
        precioPintura.add(2000);
        return precioPintura;
    }

    private ArrayList<Integer> precioPinturaRealismo(){
        ArrayList<Integer> precioPintura = new ArrayList<>();
        precioPintura.add(1140);
        precioPintura.add(1230);
        precioPintura.add(1000);
        return precioPintura;
    }

    private ArrayList<Integer> precioPinturaSurrealismo(){
        ArrayList<Integer> precioPintura = new ArrayList<>();
        precioPintura.add(2680);
        precioPintura.add(1500);
        precioPintura.add(1800);
        return precioPintura;
    }

    private ArrayList<String> descripcion(){
        ArrayList<String> descripcion = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String nomCat = bundle.getString("nomCat");
        if(nomCat.equals("ARTE ABSTRACTO")){
            descripcion = descripcionPinturaAbstracta();
        }else if(nomCat.equals("IMPRESIONISMO")){
            descripcion = descripcionPinturaImpresionismo();
        }else if(nomCat.equals("REALISMO")){
            descripcion = descripcionPinturaRealismo();
        }else if(nomCat.equals("SURREALISMO")){
            descripcion = descripcionPinturaSurrealismo();
        }else{
            Toast.makeText(this, "Hubo un error en la aplicación", Toast.LENGTH_SHORT).show();
        }
        return descripcion;
    }

    private ArrayList<String> descripcionPinturaAbstracta(){
        ArrayList<String> descripcionPintura = new ArrayList<>();
        descripcionPintura.add("Obra de Helen Frankenthaler");
        descripcionPintura.add("Obra de Vasili Kandinski");
        descripcionPintura.add("Obra de Victor Hugo");
        return descripcionPintura;
    }

    private ArrayList<String> descripcionPinturaImpresionismo(){
        ArrayList<String> descripcionPintura = new ArrayList<>();
        descripcionPintura.add("Obra de Camille Pissarro");
        descripcionPintura.add("Obra de Claude Monet");
        descripcionPintura.add("Obra de Claude Monet");
        return descripcionPintura;
    }

    private ArrayList<String> descripcionPinturaRealismo(){
        ArrayList<String> descripcionPintura = new ArrayList<>();
        descripcionPintura.add("Obra de Winslow Homer");
        descripcionPintura.add("Obra de Winslow Homer");
        descripcionPintura.add("Obra de Pável Fedótov");
        return descripcionPintura;
    }

    private ArrayList<String> descripcionPinturaSurrealismo(){
        ArrayList<String> descripcionPintura = new ArrayList<>();
        descripcionPintura.add("Obra de Salvador Dalí");
        descripcionPintura.add("Obra de Joan Miró");
        descripcionPintura.add("Obra de René Magritte");
        return descripcionPintura;
    }
}