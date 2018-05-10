package com.example.kathy.deber;


import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import Producto.Producto;

public class productoSelec extends AppCompatActivity {
    TextView nombre;
    TextView marca;
    TextView precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.productoselec);
        nombre=(TextView)findViewById(R.id.textView2);
        marca=(TextView)findViewById(R.id.textView3);
        precio=(TextView)findViewById(R.id.textView4);


        Producto producto = (Producto) getIntent().getExtras().getSerializable("producto");
        nombre.setText(producto.getNombre());
        marca.setText(producto.getMarca());
        precio.setText(producto.getPrecio());
        Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("idTexto"),Toast.LENGTH_LONG).show();
    }

}
