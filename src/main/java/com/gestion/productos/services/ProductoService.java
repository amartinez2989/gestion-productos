package com.gestion.productos.services;

import com.gestion.productos.entity.Producto;
import com.gestion.productos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listAll(String palabraClave){
        if (palabraClave != null){
            return productoRepository.findAll(palabraClave);
        }
        return productoRepository.findAll();
    }

    public void save(Producto unProducto){
        productoRepository.save(unProducto);
    }

    public Producto get(Long id){
        return productoRepository.findById(id).get();
    }

    public void delete(Long id){
        productoRepository.deleteById(id);
    }
}
