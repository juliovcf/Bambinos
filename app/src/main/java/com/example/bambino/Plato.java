package com.example.bambino;

public class Plato {
    private String nombre;
    private Double precio;
    private String ingredientes;


    public Plato(){}

    public Plato(String nombre, Double precio, String ingredientes){
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;

    }

    public String getNombre(){
        return nombre;
    }
    public Double getPrecio(){
        return precio;
    }
    public String getIngredientes(){
        return ingredientes;
    }

}
