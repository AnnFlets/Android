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

public class MAActualizarSQLite extends AppCompatActivity {

    private ListView listView;
    private EditText editTextNombre, editTextSabor, editTextPresentacion, editTextTipo, editTextPrecio;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maactualizar_sqlite);
        listView = findViewById(R.id.lvBebidasActualizar);
        editTextNombre = findViewById(R.id.edtNombreActualizar);
        editTextSabor = findViewById(R.id.edtSaborActualizar);
        editTextPresentacion = findViewById(R.id.edtPresentacionActualizar);
        editTextTipo = findViewById(R.id.edtTipoActualizar);
        editTextPrecio = findViewById(R.id.edtPrecioActualizar);
        button = findViewById(R.id.btnActualizarBebida);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarListaActualizar());
        this.clickItemLista();
        listView.setAdapter(arrayAdapter);
        this.clickActualizar();
    }

    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                llenarEditTextActualizar(position);
            }
        });
    }

    private void clickActualizar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarRegistro();
            }
        });
    }

    private ArrayList<String> llenarListaActualizar(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo, getApplicationContext()) != null){
            for(BebidaVO listaVO : bdao.listarBebida(bvo, getApplicationContext())){
                lista.add(listaVO.getCodBebida() + ". " + listaVO.getNombreBebida());
            }
        }
        return lista;
    }

    private void llenarEditTextActualizar(int position){
        ArrayList<BebidaVO> datosActualizar = new ArrayList<>();
        datosActualizar = bdao.listarBebida(bvo, getApplicationContext());
        editTextNombre.setText(datosActualizar.get(position).getNombreBebida().toString());
        editTextSabor.setText(datosActualizar.get(position).getSaborBebida().toString());
        editTextPresentacion.setText(String.valueOf(datosActualizar.get(position).getPresentacionBebida()));
        editTextTipo.setText(datosActualizar.get(position).getTipoBebida().toString());
        editTextPrecio.setText(String.valueOf(datosActualizar.get(position).getPrecioBebida()));
        bvo.setCodBebida(datosActualizar.get(position).getCodBebida());
    }

    private void actualizarRegistro(){
        if(!editTextNombre.getText().toString().isEmpty() &&
        !editTextSabor.getText().toString().isEmpty() &&
        !editTextPresentacion.getText().toString().isEmpty() &&
        !editTextTipo.getText().toString().isEmpty() &&
        !editTextPrecio.getText().toString().isEmpty()){
            bvo.setNombreBebida(editTextNombre.getText().toString());
            bvo.setSaborBebida(editTextSabor.getText().toString());
            bvo.setPresentacionBebida(Integer.parseInt(editTextPresentacion.getText().toString()));
            bvo.setTipoBebida(editTextTipo.getText().toString());
            bvo.setPrecioBebida(Double.parseDouble(editTextPrecio.getText().toString()));
            if(bdao.actualizarBebida(bvo, getApplicationContext())){
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextPresentacion.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");
                ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, llenarListaActualizar());
                listView.setAdapter(arrayAdapter);
                Toast.makeText(this, "Bebida actualizada correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Error en la actualización", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}