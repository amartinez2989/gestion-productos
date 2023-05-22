package com.gestion.productos.controller;

import com.gestion.productos.entity.Categoria;
import com.gestion.productos.entity.Producto;
import com.gestion.productos.repositories.CategoriaRepository;
import com.gestion.productos.services.CategoriaService;
import com.gestion.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/productos")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave){
        List<Producto> listaProductos = productoService.listAll(palabraClave);

        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("palabraclave", palabraClave);
        return "index";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo){
        List<Categoria> listaCategorias = categoriaService.listAll();
        Producto unProducto = new Producto();
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("producto",unProducto);
        return "formulario_producto";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id, Model modelo){
        List<Categoria> listaCategorias = categoriaService.listAll();

        Producto producto = productoService.get(id);
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "formulario_producto";
    }

    @RequestMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id){
        productoService.delete(id);
        return "redirect:/";
    }
}
