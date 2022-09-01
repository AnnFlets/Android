package com.fletes.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fletes.myappsqlite.basededatos.BebidaDAO;
import com.fletes.myappsqlite.basededatos.BebidaVO;

public class MABuscarIdSQLite extends AppCompatActivity {

    private EditText editTextCodigo;
    private ImageButton imageButtonBuscar;
    private TextView textViewCodigo, textViewNombre, textViewSabor, textViewPresentacion, textViewTipo, textViewPrecio;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sqlite);
        editTextCodigo = findViewById(R.id.edtCodigoBebida);
        imageButtonBuscar = findViewById(R.id.imgBtnBuscar);
        textViewCodigo = findViewById(R.id.txtCodigoBebida);
        textViewNombre = findViewById(R.id.txtNombreBebida);
        textViewSabor = findViewById(R.id.txtSaborBebida);
        textViewPresentacion = findViewById(R.id.txtPresentacionBebida);
        textViewTipo = findViewById(R.id.txtTipoBebida);
        textViewPrecio = findViewById(R.id.txtPrecioBebida);
        this.clickBuscar();
    }

    private void clickBuscar() {
        imageButtonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarIdBebida();
            }
        });
    }

    private void buscarIdBebida(){
        if(!editTextCodigo.getText().toString().isEmpty()){
            bvo.setCodBebida(Integer.parseInt(editTextCodigo.getText().toString()));
            //bdao.buscarIdBebida(bvo, getApplicationContext()).getCount() > 0
            //bdao.buscarIdBebida(bvo, getApplicationContext()) != null
            if(bdao.buscarIdBebida(bvo, getApplicationContext()) != null){
                if(bdao.buscarIdBebida(bvo, getApplicationContext()).getCount() > 0){
                    textViewCodigo.setText("Código: " + bvo.getCodBebida());
                    textViewNombre.setText("Nombre: " + bvo.getNombreBebida());
                    textViewSabor.setText("Sabor: " + bvo.getSaborBebida());
                    textViewPresentacion.setText("Presentación: " + bvo.getPresentacionBebida() + " mL");
                    textViewTipo.setText("Tipo: " + bvo.getTipoBebida());
                    textViewPrecio.setText("Precio: Q. " + bvo.getPrecioBebida());
                }else {
                    textViewCodigo.setText("Código:");
                    textViewNombre.setText("Nombre:");
                    textViewSabor.setText("Sabor:");
                    textViewPresentacion.setText("Presentación:");
                    textViewTipo.setText("Tipo:");
                    textViewPrecio.setText("Precio:");
                    Toast.makeText(this, "No se encontró Bebida con ese código", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Error en la búsqueda", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}