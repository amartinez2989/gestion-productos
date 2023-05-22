package com.gestion.productos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String hechoEn;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Column(nullable = false)
    private float precio;

    public Producto() {
    }

    public Producto(long id, String nombre, String hechoEn, Marca marca, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.hechoEn = hechoEn;
        this.marca = marca;
        this.precio = precio;
    }

    public long getId() {
        return id;
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

    public String getHechoEn() {
        return hechoEn;
    }

    public void setHechoEn(String hechoEn) {
        this.hechoEn = hechoEn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
