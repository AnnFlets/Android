package com.fletes.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.fletes.myappsqlite.basededatos.BebidaDAO;
import com.fletes.myappsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAEliminarSQLite extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sqlite);
        listView = findViewById(R.id.lvBebidasEliminar);
        editText = findViewById(R.id.edtNombreBebidaEliminar);
        button = findViewById(R.id.btnEliminarRegistro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
        this.clickItemListener();
        listView.setAdapter(arrayAdapter);
        this.clickEliminar();
    }

    private void clickItemListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                llenarEditTextNombre(position);
            }
        });
    }

    private void clickEliminar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarRegistro();
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo, getApplicationContext()) != null){
            for(BebidaVO vo : bdao.listarBebida(bvo, getApplicationContext())){
                lista.add(vo.getCodBebida() + ". " + vo.getNombreBebida());
            }
        }
        return lista;
    }

    private void llenarEditTextNombre(int position){
        ArrayList<BebidaVO> datoEliminar = bdao.listarBebida(bvo, getApplicationContext());
        editText.setText(datoEliminar.get(position).getNombreBebida());
        bvo.setCodBebida(datoEliminar.get(position).getCodBebida());

    }

    private void eliminarRegistro(){
        if(!editText.getText().toString().isEmpty()){
            if(bdao.eliminarBebida(bvo, getApplicationContext())){
                editText.setText("");
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
                listView.setAdapter(arrayAdapter);
                Toast.makeText(this, "Bebida eliminada correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Error en la eliminación", Toast.LENGTH_SHORT).show(); 
            }
        }else{
            Toast.makeText(this, "Debe seleccionar una bebida para eliminarla", Toast.LENGTH_SHORT).show();
        }
    }
}