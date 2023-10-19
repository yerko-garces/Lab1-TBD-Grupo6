package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.EstadoTarea;
import com.Grupo6.Lab1.services.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class EstadoTareaController {

    @Autowired
    private EstadoTareaService estadoTareaService;

    @PostMapping("/crearEstadoTarea")
    public void crearEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        estadoTareaService.crearEstadoTarea (estadoTarea);
    }

    @PutMapping("/actualizarEstadoTarea/{id}")
    public void actualizarEstadoTarea(@RequestBody EstadoTarea estadoTarea, @PathVariable Long id){
        estadoTareaService.actualizarEstadoTarea(estadoTarea, id);
    }

    @GetMapping("/verEstadoTarea")
    public void mostrarEstadoTarea(){estadoTareaService.verEstadoTarea ();}

    @DeleteMapping("/borrarEmergencia/{id}")
    public void borrarEstadoTarea(@PathVariable Long id){estadoTareaService.borrarEstadotarea(id);}

}
