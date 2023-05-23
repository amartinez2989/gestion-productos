package com.gestion.productos.controller;

import com.gestion.productos.entity.Marca;
import com.gestion.productos.entity.Modelo;
import com.gestion.productos.services.MarcaService;
import com.gestion.productos.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ModeloController {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/modelos")
    public String listarMarcas(Model modelo){
        List<Modelo> listaModelos = modeloService.listAll();
        modelo.addAttribute("listaModelos", listaModelos);
        return "modelos";
    }
    @GetMapping("/modelos/nuevo")
    public String mostrarFormularioDeRegistrarMarcas(Model model){
        Modelo modelo = new Modelo();
        List<Marca> listaMarcas = marcaService.listAll();

        model.addAttribute("listaMarcas", listaMarcas);
        model.addAttribute("modelo",modelo);
        return "formulario_modelo";
    }

    @PostMapping("/modelos/guardar")
    public String guardarMarca(Modelo modelo1){
        modeloService.save(modelo1);
        return "redirect:/modelos";
    }

    @GetMapping("/modelos/editar/{id}")
    public String mostrarFormularioDeEditarModelos(@PathVariable(name = "id") Long id, Model modelo1){
        List<Marca> listaMarcas = marcaService.listAll();

        Modelo modelo = modeloService.get(id);
        modelo1.addAttribute("modelo", modelo);
        modelo1.addAttribute("listaMarcas", listaMarcas);
        return "formulario_modelo";
    }

    @RequestMapping("/modelos/eliminar/{id}")
    public String eliminarModelos(@PathVariable(name = "id") Long id){
        modeloService.delete(id);
        return "redirect:/modelos";
    }
}
