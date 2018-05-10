package Producto;
import java.io.Serializable;

public class Producto implements Serializable{

    String nombre,marca, precio;
    Producto tiendaPro[];

    public Producto() {
    }

    public Producto(String nombre, String marca, String precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() { return precio; }

    public void setPrecio(String precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Nombre:"+this.nombre + " Marca: "+this.marca+" Precio: "+this.precio ;
    }

    public Producto [] cargarProducto(){
        tiendaPro = new Producto[] {
                new Producto("Agua","Dasani","0.50"),
                new Producto("Chocolate","Manicho","0.50"),
                new Producto("Galletas","Oreo","0.75"),
                new Producto("Sancks","Doritos", "0.60")

        };
        return tiendaPro;
    }


}