package com.gestion.productos.controller;

import com.gestion.productos.entity.Producto;
import com.gestion.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/productos")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave){
        List<Producto> listaProductos = productoService.listAll(palabraClave);

        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("palabraclave", palabraClave);
        return "index";
    }

    @RequestMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo){
        Producto unProducto = new Producto();
        modelo.addAttribute("producto",unProducto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/productos/guardar" , method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute ("producto") Producto producto){
        productoService.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/productos/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id){
        ModelAndView modelo = new ModelAndView("editar_producto");

        Producto producto = productoService.get(id);
        modelo.addObject("producto", producto);
        return modelo;
    }

    @RequestMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id){
        productoService.delete(id);
        return "redirect:/";
    }
}
