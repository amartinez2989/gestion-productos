package com.gestion.productos.services;

import com.gestion.productos.entity.Marca;
import com.gestion.productos.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> listAll(){

        return marcaRepository.findAll();
    }
    public void save(Marca marca){
        marcaRepository.save(marca);
    }

    public Marca get(Long id){
        return marcaRepository.findById(id).get();
    }

    public void delete(Long id){
        marcaRepository.deleteById(id);
    }

}
