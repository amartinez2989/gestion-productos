package com.gestion.productos.services;

import com.gestion.productos.entity.Categoria;
import com.gestion.productos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listAll(){

        return categoriaRepository.findAll();
    }

    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }
    public Categoria get(Integer id){
        return categoriaRepository.findById(id).get();
    }
    public void delete(Integer id){
       categoriaRepository.deleteById(id);
    }

}
