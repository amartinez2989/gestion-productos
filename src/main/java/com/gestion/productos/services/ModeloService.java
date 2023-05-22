package com.gestion.productos.services;

import com.gestion.productos.entity.Modelo;
import com.gestion.productos.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    ModeloRepository modeloRepository;

    public List<Modelo> listAll(){

        return modeloRepository.findAll();
    }

    public void save(Modelo categoria){
        modeloRepository.save(categoria);
    }
    public Modelo get(Integer id){
        return modeloRepository.findById(id).get();
    }
    public void delete(Integer id){
       modeloRepository.deleteById(id);
    }

}
