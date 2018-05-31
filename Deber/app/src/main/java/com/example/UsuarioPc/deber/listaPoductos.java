package com.example.UsuarioPc.deber;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import Control.LeerEscribirArchivos;
import Producto.Producto;

public class listaPoductos extends AppCompatActivity {

    ListView listaInvitado;
    ArrayAdapter<String> adapteri;
    String [] nombrePoducto;
    public LeerEscribirArchivos controladorArchivoObjeto = new LeerEscribirArchivos();
    public ArrayList<Producto> arrayListCompra = new ArrayList<Producto>();
    ArrayAdapter<Producto> adapter;
    Producto [] productoCompra;

    PopupMenu popUpMenuInvitado;
    PopupMenu popUpMenuUser;

    public void cargarProducto(){
        productoCompra = new Producto().cargarProducto();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaproductos);

        listaInvitado = (ListView) findViewById(R.id.listaInvitado);


        if((getIntent().getExtras().getString("loging")).equals("User")){
            cargarProducto();
            adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, productoCompra);
            listaInvitado.setAdapter(adapter);
        }else{
            cargarProducto();
            adapteri = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,cargarNombres());
            listaInvitado.setAdapter(adapteri);
        }

        listaInvitado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int selecion, long l) {
                if((getIntent().getExtras().getString("loging")).equals("User")){
                    menuLogingSelec(view, productoCompra[selecion]);
                }else{
                    menuInvitadoSelec(view, productoCompra[selecion]);
                }
            }
        });
    }

    public String [] cargarNombres(){
        nombrePoducto = new String[productoCompra.length];
        for (int i = 0; i< nombrePoducto.length; i++){
            nombrePoducto[i]= productoCompra[i].getNombre();
        }
        return  nombrePoducto;
    }

    public void menuLogingSelec(View view, final Producto objProducto)
    {
        popUpMenuUser= new PopupMenu(this, view);
        popUpMenuUser.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        envioObjeto(objProducto);
                        return true;
                    case R.id.comprar:
                        arrayListCompra.add(new Producto(
                                objProducto.getNombre().toString(),
                                objProducto.getMarca().toString(),
                                objProducto.getPrecio().toString()
                        ));
                        Toast.makeText(getApplicationContext(),"Producto añadido al carrito de compras",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.comparar:
                        controladorArchivoObjeto.escribirArchivo(arrayListCompra,"Productos.txt");
                        Toast.makeText(getApplicationContext(),"Carrito de Compras",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), listaCompra.class);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenuUser.inflate(R.menu.menulog);
        popUpMenuUser.show();
    }

    public void menuInvitadoSelec(View view, final Producto objProducto)
    {
        popUpMenuInvitado= new PopupMenu(this, view);
        popUpMenuInvitado.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        envioObjeto(objProducto);
                        return true;
                    case R.id.comprar:
                        dialogoAlert();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenuInvitado.inflate(R.menu.menuinv);
        popUpMenuInvitado.show();
    }

    public void envioObjeto(Producto objProducto){
        Intent intent = new Intent(getApplicationContext(), productoSelec.class);
        intent.putExtra("producto", objProducto);
        startActivity(intent);
    }

    public void dialogoAlert() {

        AlertDialog.Builder alertDialogo = new AlertDialog.Builder(this);//ES IMPORTANTE VER DE QUE LIBRERIA LLAMAMO ES LA DE LA APP, el contexto es this o getapplication context si estoy en un meoto
        alertDialogo.setTitle("Tienda Virtual");
        alertDialogo.setMessage("Desea comprar el producto,Inicia sesion");
        alertDialogo.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("sesion", true);
                startActivity(intent);
            }
        });
        alertDialogo.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Tu te lo pierdes", Toast.LENGTH_LONG).show();
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

