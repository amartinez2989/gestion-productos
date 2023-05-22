package com.gestion.productos.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private List<Producto> productos;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos= new ArrayList<>();

    public Marca() {
    }

    public long getId() {
        return id;
    }

    public Marca(long id, String nombre, List<Producto> productos, List<Modelo> modelos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
        this.modelos = modelos;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
