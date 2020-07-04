package com.example.recyclerview;

public class Productos {

    String nombre;
    String imagen;
    String descripcion;
    double precio;

    public Productos( String nombre, String imagen,String descripcion,double precio){
        this.nombre=nombre;
        this.imagen=imagen;
        this.descripcion=descripcion;
        this.precio=precio;
    }
    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }


}
