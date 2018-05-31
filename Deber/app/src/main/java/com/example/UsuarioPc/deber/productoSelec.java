package com.example.UsuarioPc.deber;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Control.LeerEscribirArchivos;
import Producto.Producto;

public class productoSelec extends AppCompatActivity {
    TextView nombre;
    TextView marca;
    TextView precio;
    public ArrayList<Producto> arrayListCarrito = new ArrayList<Producto>();
    public LeerEscribirArchivos controladorArchivoObjeto = new LeerEscribirArchivos();
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
       // Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("idTexto"),Toast.LENGTH_LONG).show();
        /*arrayListCarrito.add(new Producto(
                producto.getNombre(),
                producto.getMarca(),
                producto.getPrecio()
        ));*/
        arrayListCarrito.add(new Producto(
                "asd",
                "asda",
                "asdqw"
        ));
    }
public void comprarProducto(View view){

    controladorArchivoObjeto.escribirArchivo(arrayListCarrito,"Productos.txt");
    Intent intent = new Intent(getApplicationContext(), listaCompra.class);
    startActivity(intent);
}
}
