package com.gestion.productos.controller;

import com.gestion.productos.entity.Marca;
import com.gestion.productos.entity.Modelo;
import com.gestion.productos.services.ModeloService;
import com.gestion.productos.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/marcas")
    public String listarMarcas(Model modelo){
        List<Marca> listaMarcas = marcaService.listAll();
        modelo.addAttribute("listaMarcas", listaMarcas);
        return "marcas";
    }
    @GetMapping("/marcas/nuevo")
    public String mostrarFormularioDeRegistrarMarcas(Model modelo){
        Marca marca = new Marca();
        List<Modelo> listaModelos = modeloService.listAll();
        modelo.addAttribute("marca",marca);
        modelo.addAttribute("listaModelos", listaModelos);
        return "formulario_marca";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca){
        marcaService.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/editar/{id}")
    public String mostrarFormularioDeEditarMarca(@PathVariable(name = "id") Long id, Model modelo){
        Marca marca = marcaService.get(id);
        List<Modelo> listaModelos = modeloService.listAll();
        modelo.addAttribute("marca", marca);
        modelo.addAttribute("listaModelos", listaModelos);
        return "formulario_marca";
    }

    @RequestMapping("/marcas/eliminar/{id}")
    public String eliminarMarca(@PathVariable(name = "id") Long id){
        marcaService.delete(id);
        return "redirect:/marcas";
    }
}
