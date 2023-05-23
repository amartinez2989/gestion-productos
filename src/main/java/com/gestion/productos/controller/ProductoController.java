package com.gestion.productos.controller;

import com.gestion.productos.entity.Marca;
import com.gestion.productos.entity.Modelo;
import com.gestion.productos.entity.Producto;
import com.gestion.productos.repositories.MarcaRepository;
import com.gestion.productos.services.MarcaService;
import com.gestion.productos.services.ModeloService;
import com.gestion.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;



@RequestMapping
@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/productos/modelos")
    public ResponseEntity<?> getModelosByMarcaId(@RequestParam("marcaId") Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid brand Id: " + marcaId));
        return ResponseEntity.ok(marca.getModelos());
    }

    @RequestMapping("/productos")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave){
        List<Producto> listaProductos = productoService.listAll(palabraClave);
        List<Modelo> listModelos = modeloService.listAll();
        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("palabraclave", palabraClave);
        return "index";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo){
        List<Marca> listaMarcas = marcaService.listAll();
        List<Modelo> listaModelos = modeloService.listAll();
        Producto unProducto = new Producto();

        modelo.addAttribute("listaMarcas", listaMarcas);
        modelo.addAttribute("listaModelos",listaModelos);
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
        List<Marca> listaMarcas = marcaService.listAll();

        Producto producto = productoService.get(id);
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("listaMarcas", listaMarcas);
        return "formulario_producto";
    }

    @RequestMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id){
        productoService.delete(id);
        return "redirect:/";
    }

}
