package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.EstadoTarea;
import com.Grupo6.Lab1.services.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EstadoTareaController {

    @Autowired
    private EstadoTareaService estadoTareaService;

    @PostMapping("/crearEstadoTarea")
    public EstadoTarea crearEstadoTarea(@RequestBody EstadoTarea estadoTarea){return estadoTareaService.crearEstadoTarea (estadoTarea);}

    @PutMapping("/actualizarEstadoTarea/{id}")
    public String actualizarEstadoTarea(@RequestBody EstadoTarea estadoTarea, @PathVariable Long id){
        return   estadoTareaService.actualizarEstadoTarea(estadoTarea, id);
    }

    @GetMapping("/verEstadoTarea")
    public List<EstadoTarea> mostrarEstadoTarea(){return estadoTareaService.verEstadoTarea ();}

    @DeleteMapping("/borrarEstadoTarea/{id}")
    public void borrarEstadoTarea(@PathVariable Long id){estadoTareaService.borrarEstadotarea(id);}

}
