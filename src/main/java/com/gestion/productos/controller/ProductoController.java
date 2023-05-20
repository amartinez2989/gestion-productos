package com.gestion.productos.controller;

import com.gestion.productos.entity.Producto;
import com.gestion.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model modelo){
        List<Producto> listaProductos = productoService.listAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo){
        Producto unProducto = new Producto();
        modelo.addAttribute("producto",unProducto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/guardar" , method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute ("producto") Producto producto){
        productoService.save(producto);
        return "redirect:/";
    }
}
