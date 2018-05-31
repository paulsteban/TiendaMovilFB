package com.example.UsuarioPc.deber;


import android.app.AlertDialog;
import android.content.DialogInterface;
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

        //sesion = (boolean) getIntent().getExtras().getSerializable("sesion");
        Producto producto = (Producto) getIntent().getExtras().getSerializable("producto");
        nombre.setText(producto.getNombre());
        marca.setText(producto.getMarca());
        precio.setText(producto.getPrecio());
       // Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("idTexto"),Toast.LENGTH_LONG).show();
        arrayListCarrito.add(new Producto(
                producto.getNombre(),
                producto.getMarca(),
                producto.getPrecio()
        ));
    }
public void comprarProducto(){

    controladorArchivoObjeto.escribirArchivo(arrayListCarrito,"Productos.txt");
    Intent intent = new Intent(getApplicationContext(), listaCompra.class);
    startActivity(intent);
}
    public void dialogoAlert(View view) {

        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("Tienda Virtual");
        alertDialogo.setMessage("Esta seguro que quiere comprar este producto ");
        alertDialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                  //  comprarProducto();

                    Toast.makeText(getApplicationContext(), "TE la creiste man", Toast.LENGTH_LONG).show();// estoy denttro de un metodo getaplicationcontext


            }



        });
        alertDialogo.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setNeutralButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogo.setCancelable(false);//para cancelar sin aplastar el boton de cancelar
        alertDialogo.create();
        alertDialogo.show();

    }
}
