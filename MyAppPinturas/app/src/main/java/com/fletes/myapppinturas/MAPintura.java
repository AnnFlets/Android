package com.fletes.myapppinturas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MAPintura extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewNombre, textViewPrecio;
    private EditText editTextNombre, editTextApellido, editTextNit;
    private Button buttonComprar, buttonCancelar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapintura);
        imageView = findViewById(R.id.imgObra);
        textViewNombre = findViewById(R.id.txtNombreObra);
        textViewPrecio = findViewById(R.id.txtPrecioObra);
        editTextNombre = findViewById(R.id.edtNombre);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextNit = findViewById(R.id.edtNit);
        buttonComprar = findViewById(R.id.btnComprar);
        buttonCancelar = findViewById(R.id.btnCancelar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        obtenerInfo();
        click();
    }

    private void click() {
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladarDatosCompra();
            }
        });
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
    }

    private void trasladarDatosCompra(){
        String nomPin = textViewNombre.getText().toString();
        String nomCom = editTextNombre.getText().toString();
        String apeCom = editTextApellido.getText().toString();
        String nitCom = editTextNit.getText().toString();
        String prePin = textViewPrecio.getText().toString();
        if(!nomCom.isEmpty() && !apeCom.isEmpty() && !nitCom.isEmpty()){
            Intent intent = new Intent(this, MACompra.class);
            intent.putExtra("pin", textViewNombre.getText());
            intent.putExtra("nom", editTextNombre.getText().toString());
            intent.putExtra("ape", editTextApellido.getText().toString());
            intent.putExtra("nit", editTextNit.getText().toString());
            intent.putExtra("pre", textViewPrecio.getText());
            this.startActivity(intent);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    private void regresar(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    private void obtenerInfo(){
        Bundle bundle = getIntent().getExtras();
        int imgObra = bundle.getInt("img");
        String nomObra = bundle.getString("nom");
        int preObra = bundle.getInt("pre");
        imageView.setImageResource(imgObra);
        textViewNombre.setText(String.valueOf(nomObra));
        textViewPrecio.setText(String.valueOf(preObra));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemPincel:
                Toast.makeText(this, "Compre la pintura plis :,)", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemMenu1:
                Toast.makeText(this, "Holaaa :D", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemMenu2:
                Toast.makeText(this, "Adiós c:", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemMenu3:
                Toast.makeText(this, "¡Clic!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}