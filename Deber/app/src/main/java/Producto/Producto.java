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
                new Producto("Portátil Asus Rog Strix","Asus","1500"),
                new Producto("Portátil MSI GS63 7RD-096XES Stealth Pro","MSI","1100"),
                new Producto("Portátil HP Pavilion 15-BC301NS","HP","850"),
                new Producto("Portátil Lenovo Legion Y520-15IKBN","Lenovo", "800")

        };
        return tiendaPro;
    }


}