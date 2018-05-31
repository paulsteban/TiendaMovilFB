package com.example.UsuarioPc.deber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Control.LeerEscribirArchivos;
import Producto.Producto;

public class listaCompra extends AppCompatActivity {
    ListView listacompras;
    LeerEscribirArchivos controladorArchivo = new LeerEscribirArchivos();
    ArrayAdapter<Producto> adapterCarro;
    List<Producto> your_array_list = new ArrayList<Producto>();
  //  Producto [] productoCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacompra);
        listacompras = (ListView)findViewById(R.id.ListaCompras);
        your_array_list=controladorArchivo.leerArchivos("Productos.txt");
        adapterCarro = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, your_array_list );
        listacompras.setAdapter(adapterCarro);

    }

}
