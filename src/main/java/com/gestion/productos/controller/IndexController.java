package com.gestion.productos.controller;

import com.gestion.productos.entity.Producto;
import com.gestion.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave){
        List<Producto> listaProductos = productoService.listAll(palabraClave);

        modelo.addAttribute("listaProductos", listaProductos);
        modelo.addAttribute("palabraclave", palabraClave);
        return "index";
    }
}
