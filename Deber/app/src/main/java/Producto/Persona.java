package Producto;

public class Persona {
    String nombre,clave;

    public Persona(String nombre, String clave){
        this.nombre=nombre;
        this.clave=clave;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
