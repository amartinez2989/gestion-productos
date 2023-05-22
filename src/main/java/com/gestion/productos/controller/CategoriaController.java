package com.gestion.productos.controller;

import com.gestion.productos.entity.Categoria;
import com.gestion.productos.entity.Producto;
import com.gestion.productos.repositories.CategoriaRepository;
import com.gestion.productos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model modelo){
        List<Categoria> listaCategorias = categoriaService.listAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }
    @RequestMapping("/categorias/nuevo")
    public String mostrarFormularioDeRegistrarCategoria(Model modelo){
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria",categoria);
        return "formulario_categoria";
    }

    @RequestMapping(value = "/categorias/guardar" , method = RequestMethod.POST)
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

    @RequestMapping("/categorias/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarCategoria(@PathVariable(name = "id") Integer id){
        ModelAndView modelo = new ModelAndView("formulario_categoria");
        Categoria categoria = categoriaService.get(id);
        modelo.addObject("categoria", categoria);
        return modelo;
    }

    @RequestMapping("/categorias/eliminar/{id}")
    public String eliminarCategorias(@PathVariable(name = "id") Integer id){
        categoriaService.delete(id);
        return "redirect:/categorias";
    }
}
