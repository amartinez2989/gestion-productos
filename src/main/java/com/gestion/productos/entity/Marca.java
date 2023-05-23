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

    @OneToMany(mappedBy = "marca", cascade={CascadeType.REMOVE}, orphanRemoval=false)
    private List<Producto> productos;

    @OneToMany(mappedBy = "marca", cascade={CascadeType.REMOVE}, orphanRemoval=false)
    private List<Modelo> modelos= new ArrayList<>();

    public Marca() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void agregarModelo(Modelo modelo) {
        modelos.add(modelo);
        modelo.setMarca(this);
    }

    public void eliminarModelo(Modelo modelo) {
        modelos.remove(modelo);
        modelo.setMarca(null);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
